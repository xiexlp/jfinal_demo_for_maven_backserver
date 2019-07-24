package com.js.isearch.index;

import com.js.common.db.DbUtils;
import com.js.common.db.HikariDb;
import com.js.common.db.HikariFlexibleDb;
import com.js.isearch.orm.Doc;
import com.js.isearch.orm.Topic;
import com.js.isearch.serv.DocServ;
import com.js.isearch.serv.TopicServ;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/***
 * 这个是将ejf_topic-->ejf_doc中去
 */
public class DataMove {

    public static void main1(String[] args) {
        //move();
        //更新原字段的索引状态
       // updateTopicIndexStatus("content","ejf_topic","iforum");

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        for(int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

    public static void main(String[] args) {

        move();

    }


    public static final String url_pre="https://localhost/boot/";


    /**
     * 将ejf_topic数据备份到ejf_doc中去,返回转移的数目
     */
    public  static int move(){
        //将ejf_topic ->ejf_doc中去
        String sql = "select * from ejf_topic as a where a.index_status=0";
        Connection con = HikariFlexibleDb.getConnection();
        List<Topic> topicList =new ArrayList<>();
        topicList.clear();
        Topic topic1 =null;
        ResultSet rs =null;
        PreparedStatement ps=null;
        try {
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                topic1 = new Topic();
                setFindParamNo(rs,topic1);
                topicList.add(topic1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(rs,ps);
            DbUtils.closeConn(con);
        }

        //List<Topic> topicList = TopicServ.n().findAll();
        DocServ docServ = DocServ.n();
        int sum=0;
        for(Topic topic:topicList){
            System.out.println("topic:"+topic.getTitle());
            Doc d = new Doc();
            d.setBody(topic.getContent());
            d.setBodySize(topic.getContent().length());
            d.setTitle(topic.getTitle());
            d.setTitleSize(topic.getTitle().length());
            d.setFieldId(topic.getTopicId());
            d.setHost("localhost");
            d.setUrl(url_pre+"topic/topicattach?topicId="+topic.getTopicId());
            d.setDbname("iforum");
            d.setTablename("ejf_topic");
            d.setFieldname("content");
            d.setCreateTime(System.currentTimeMillis());
            d.setUpdateTime(System.currentTimeMillis());
            d.setIndexStage(0);
            d.setIndexStatus("0");
            int r=docServ.saveAutoId(d);
            if(r>0){
                sum++;
                System.out.println("存入成功:"+r);
                //更新这个topic的索引状态
                String updateSql = "update ejf_topic set index_status=1 where topic_id="+topic.getTopicId();
                int result = HikariFlexibleDb.exeUpdate(updateSql);
                if(result>0){
                    System.out.println("更新主题索引状态成功");
                }else {
                    System.out.println("更新主题索引状态失败");
                }
            }else {
                System.out.println("存入失败:"+r);
            }
        }
        return sum;
    }

    /**
     * 更新ejf_topoc的索引状态
     */
    public static void updateTopicIndexStatus(String fieldname,String tablename,String dbname){
        List<Topic> topicList = findAllTopicFromIforum();
        //String tablename = "ejf_topic";
        for(Topic topic:topicList){
            int topicId = topic.getTopicId();
            //查看是否已经拷贝过来了，这个topicl,
            List<Long> topicIdList = DocServ.n().findDocIdByFieldnameFieldIdTablenameDbname(fieldname,topicId,tablename,dbname);
            int size = topicIdList.size();
            System.out.println("size:"+size);
            //存在,已经被索引，更新索引状态为1
            if(size>0){
                String sql = "update ejf_topic set index_status=1 where topic_id="+topicId;
                int result = HikariFlexibleDb.exeUpdate(sql);
                if(result>0){
                    System.out.println("更新成功");
                }
            }
        }
    }

    public static int moveATopic2NewDatabase(Topic topic,String tablename){
    	//查看 ejf_doc里面是否有该 topic

        Connection con= HikariDb.getConnection();
        return  0;
        //String sql = "select doc_id from ejf_doc where tablename="+tablename+" and topic_id="+topic.getTopicId();

    }

    public static List<Topic> findAllTopicFromIforum(){
        List<Topic> topicList = new ArrayList<>();
        //HikariConfig config = new HikariConfig();

        try {
            Connection con= HikariFlexibleDb.getConnection();
            PreparedStatement ps =con.prepareStatement("select * FROM ejf_topic");
            ResultSet rs=ps.executeQuery();
            Topic topic =null;
            while (rs.next()) {
                topic = new Topic();
                setFindParamNo(rs,topic);
                topicList.add(topic);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return topicList;
    }


    protected static void setFindParamNo(ResultSet r,Topic topic) throws Exception{
        topic.setTopicId(r.getInt(1));
        topic.setAttachIcon(r.getString(2));
        topic.setAttaches(r.getInt(3));
        topic.setCatId(r.getInt(4));
        topic.setContent(r.getString(5));
        topic.setCreateTime(r.getLong(6));
        topic.setDiggdns(r.getInt(7));
        topic.setDiggups(r.getInt(8));
        topic.setHighColor(r.getString(9));
        topic.setHighExpireDate(r.getLong(10));
        topic.setIsDigest(r.getInt(11));
        topic.setIsHidePost(r.getInt(12));
        topic.setIsReplyNotice(r.getString(13));
        topic.setIsSolved(r.getString(14));
        topic.setLastNickname(r.getString(15));
        topic.setLastPostTime(r.getLong(16));
        topic.setLastPostUser(r.getString(17));
        topic.setNickname(r.getString(18));
        topic.setRemoteIp(r.getString(19));
        topic.setReplies(r.getInt(20));
        topic.setReward(r.getInt(21));
        topic.setSectionId(r.getInt(22));
        topic.setSpecType(r.getInt(23));
        topic.setState(r.getInt(24));
        topic.setTitle(r.getString(25));
        topic.setTopExpireDate(r.getLong(26));
        topic.setTopScope(r.getInt(27));
        topic.setUpdateTime(r.getLong(28));
        topic.setUpdateUser(r.getString(29));
        topic.setUserId(r.getInt(30));
        topic.setVisits(r.getInt(31));
        topic.setBoardId(r.getInt(32));
        topic.setLikes(r.getInt(33));
        topic.setUsername(r.getString(34));
        topic.setIndexStatus(r.getInt(35));
    }


}
