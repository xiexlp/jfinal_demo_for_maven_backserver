package com.js.isearch.daoimplex;

/**
* last update time:"18-05-08 15:19:43"
* last update user:pku
*/


import com.js.common.db.*;
import com.js.isearch.orm.Topic;
import com.js.isearch.daoex.TopicDaoEx;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import java.sql.Connection;
import com.js.common.util.Globe;
import java.sql.Statement;
import com.js.common.util.PageList;


public class TopicDaoimplEx implements TopicDaoEx {

public String dbname= Globe.dbname;

public List find(String hql) {
return null;
}

public int save(Topic topic) {
PreparedStatement p = null;
Connection conn=null;
int result=-1;
String sql = "insert ejf_topic(`topic_id`,`attach_icon`,`attaches`,`cat_id`,`content`,`create_time`,`diggdns`,`diggups`,`high_color`,`high_expire_date`,`is_digest`,`is_hide_post`,`is_reply_notice`,`is_solved`,`last_nickname`,`last_post_time`,`last_post_user`,`nickname`,`remote_ip`,`replies`,`reward`,`section_id`,`spec_type`,`state`,`title`,`top_expire_date`,`top_scope`,`update_time`,`update_user`,`user_id`,`visits`,`board_id`,`likes`,`username`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
try {
//p = DbHotel.getIforum_index_dbConnection();
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
setStatement(p,topic);
result=p.executeUpdate();
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return result;
}



public int saveAutoReturnId(Topic topic) {
PreparedStatement p = null;
int result=-1;
int returnID=-1;
ResultSet r = null;
Connection conn=null;
String sql = "insert ejf_topic(`attach_icon`,`attaches`,`cat_id`,`content`,`create_time`,`diggdns`,`diggups`,`high_color`,`high_expire_date`,`is_digest`,`is_hide_post`,`is_reply_notice`,`is_solved`,`last_nickname`,`last_post_time`,`last_post_user`,`nickname`,`remote_ip`,`replies`,`reward`,`section_id`,`spec_type`,`state`,`title`,`top_expire_date`,`top_scope`,`update_time`,`update_user`,`user_id`,`visits`,`board_id`,`likes`,`username`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("insert ejf_topic(`attach_icon`,`attaches`,`cat_id`,`content`,`create_time`,`diggdns`,`diggups`,`high_color`,`high_expire_date`,`is_digest`,`is_hide_post`,`is_reply_notice`,`is_solved`,`last_nickname`,`last_post_time`,`last_post_user`,`nickname`,`remote_ip`,`replies`,`reward`,`section_id`,`spec_type`,`state`,`title`,`top_expire_date`,`top_scope`,`update_time`,`update_user`,`user_id`,`visits`,`board_id`,`likes`,`username`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
setStatementAutoId(p,topic);
result=p.executeUpdate();
r = p.getGeneratedKeys();
if (r != null&&r.next()) {
returnID=r.getInt(1);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return returnID;
}

public int saveAutoId(Topic topic) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
String sql = "insert ejf_topic(`attach_icon`,`attaches`,`cat_id`,`content`,`create_time`,`diggdns`,`diggups`,`high_color`,`high_expire_date`,`is_digest`,`is_hide_post`,`is_reply_notice`,`is_solved`,`last_nickname`,`last_post_time`,`last_post_user`,`nickname`,`remote_ip`,`replies`,`reward`,`section_id`,`spec_type`,`state`,`title`,`top_expire_date`,`top_scope`,`update_time`,`update_user`,`user_id`,`visits`,`board_id`,`likes`,`username`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("insert ejf_topic(`attach_icon`,`attaches`,`cat_id`,`content`,`create_time`,`diggdns`,`diggups`,`high_color`,`high_expire_date`,`is_digest`,`is_hide_post`,`is_reply_notice`,`is_solved`,`last_nickname`,`last_post_time`,`last_post_user`,`nickname`,`remote_ip`,`replies`,`reward`,`section_id`,`spec_type`,`state`,`title`,`top_expire_date`,`top_scope`,`update_time`,`update_user`,`user_id`,`visits`,`board_id`,`likes`,`username`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//p = DbHotel.getConnectionByName(dbname).prepareStatement(sql);
conn =HikariDb.getConnection();
p=conn.prepareStatement("insert ejf_topic(`attach_icon`,`attaches`,`cat_id`,`content`,`create_time`,`diggdns`,`diggups`,`high_color`,`high_expire_date`,`is_digest`,`is_hide_post`,`is_reply_notice`,`is_solved`,`last_nickname`,`last_post_time`,`last_post_user`,`nickname`,`remote_ip`,`replies`,`reward`,`section_id`,`spec_type`,`state`,`title`,`top_expire_date`,`top_scope`,`update_time`,`update_user`,`user_id`,`visits`,`board_id`,`likes`,`username`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
setStatementAutoId(p,topic);
result=p.executeUpdate();
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return result;
}

private void setStatement(PreparedStatement p,Topic topic) throws Exception{
p.setObject(1,topic.getTopicId());
p.setString(2,topic.getAttachIcon());
p.setObject(3,topic.getAttaches());
p.setObject(4,topic.getCatId());
p.setString(5,topic.getContent());
p.setLong(6,topic.getCreateTime());
p.setObject(7,topic.getDiggdns());
p.setObject(8,topic.getDiggups());
p.setString(9,topic.getHighColor());
p.setLong(10,topic.getHighExpireDate());
p.setObject(11,topic.getIsDigest());
p.setObject(12,topic.getIsHidePost());
p.setString(13,topic.getIsReplyNotice());
p.setString(14,topic.getIsSolved());
p.setString(15,topic.getLastNickname());
p.setLong(16,topic.getLastPostTime());
p.setString(17,topic.getLastPostUser());
p.setString(18,topic.getNickname());
p.setString(19,topic.getRemoteIp());
p.setObject(20,topic.getReplies());
p.setObject(21,topic.getReward());
p.setObject(22,topic.getSectionId());
p.setObject(23,topic.getSpecType());
p.setObject(24,topic.getState());
p.setString(25,topic.getTitle());
p.setLong(26,topic.getTopExpireDate());
p.setObject(27,topic.getTopScope());
p.setLong(28,topic.getUpdateTime());
p.setString(29,topic.getUpdateUser());
p.setObject(30,topic.getUserId());
p.setObject(31,topic.getVisits());
p.setObject(32,topic.getBoardId());
p.setObject(33,topic.getLikes());
p.setString(34,topic.getUsername());

}

private void setStatementAutoId(PreparedStatement p,Topic topic) throws Exception{
    p.setString(1,topic.getAttachIcon());
p.setObject(2,topic.getAttaches());
p.setObject(3,topic.getCatId());
p.setString(4,topic.getContent());
p.setLong(5,topic.getCreateTime());
p.setObject(6,topic.getDiggdns());
p.setObject(7,topic.getDiggups());
p.setString(8,topic.getHighColor());
p.setLong(9,topic.getHighExpireDate());
p.setObject(10,topic.getIsDigest());
p.setObject(11,topic.getIsHidePost());
p.setString(12,topic.getIsReplyNotice());
p.setString(13,topic.getIsSolved());
p.setString(14,topic.getLastNickname());
p.setLong(15,topic.getLastPostTime());
p.setString(16,topic.getLastPostUser());
p.setString(17,topic.getNickname());
p.setString(18,topic.getRemoteIp());
p.setObject(19,topic.getReplies());
p.setObject(20,topic.getReward());
p.setObject(21,topic.getSectionId());
p.setObject(22,topic.getSpecType());
p.setObject(23,topic.getState());
p.setString(24,topic.getTitle());
p.setLong(25,topic.getTopExpireDate());
p.setObject(26,topic.getTopScope());
p.setLong(27,topic.getUpdateTime());
p.setString(28,topic.getUpdateUser());
p.setObject(29,topic.getUserId());
p.setObject(30,topic.getVisits());
p.setObject(31,topic.getBoardId());
p.setObject(32,topic.getLikes());
p.setString(33,topic.getUsername());

}

public List<Topic> findAll() {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
Topic topic = null;
List<Topic> list = new ArrayList();
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select a.topic_id,a.attach_icon,a.attaches,a.cat_id,a.content,a.create_time,a.diggdns,a.diggups,a.high_color,a.high_expire_date,a.is_digest,a.is_hide_post,a.is_reply_notice,a.is_solved,a.last_nickname,a.last_post_time,a.last_post_user,a.nickname,a.remote_ip,a.replies,a.reward,a.section_id,a.spec_type,a.state,a.title,a.top_expire_date,a.top_scope,a.update_time,a.update_user,a.user_id,a.visits,a.board_id,a.likes,a.username from ejf_topic as a");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select a.topic_id,a.attach_icon,a.attaches,a.cat_id,a.content,a.create_time,a.diggdns,a.diggups,a.high_color,a.high_expire_date,a.is_digest,a.is_hide_post,a.is_reply_notice,a.is_solved,a.last_nickname,a.last_post_time,a.last_post_user,a.nickname,a.remote_ip,a.replies,a.reward,a.section_id,a.spec_type,a.state,a.title,a.top_expire_date,a.top_scope,a.update_time,a.update_user,a.user_id,a.visits,a.board_id,a.likes,a.username from ejf_topic as a");
r = p.executeQuery();
while (r.next()) {
topic = new Topic();
setFindParamNo(r, topic);
list.add(topic);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return list;
}

public PageList<Topic> findByPage(int pageNo,int total) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
Topic topic = null;
PageList<Topic> list = new PageList(pageNo,total);
String sql = "select a.topic_id,a.attach_icon,a.attaches,a.cat_id,a.content,a.create_time,a.diggdns,a.diggups,a.high_color,a.high_expire_date,a.is_digest,a.is_hide_post,a.is_reply_notice,a.is_solved,a.last_nickname,a.last_post_time,a.last_post_user,a.nickname,a.remote_ip,a.replies,a.reward,a.section_id,a.spec_type,a.state,a.title,a.top_expire_date,a.top_scope,a.update_time,a.update_user,a.user_id,a.visits,a.board_id,a.likes,a.username from ejf_topic as a ORDER BY a.create_time DESC LIMIT ?,?";
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select a.topic_id,a.attach_icon,a.attaches,a.cat_id,a.content,a.create_time,a.diggdns,a.diggups,a.high_color,a.high_expire_date,a.is_digest,a.is_hide_post,a.is_reply_notice,a.is_solved,a.last_nickname,a.last_post_time,a.last_post_user,a.nickname,a.remote_ip,a.replies,a.reward,a.section_id,a.spec_type,a.state,a.title,a.top_expire_date,a.top_scope,a.update_time,a.update_user,a.user_id,a.visits,a.board_id,a.likes,a.username from ejf_topic as a ORDER BY a.create_time DESC LIMIT ?,?");
conn =HikariDb.getConnection();
p=conn.prepareStatement(sql);
p.setInt(1,list.getOffset());
p.setInt(2,list.getPageSize());
r = p.executeQuery();
while (r.next()) {
topic = new Topic();
setFindParamNo(r, topic);
list.add(topic);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return list;
}



public int update(Topic topic) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("update ejf_topic set `attach_icon`=?,`attaches`=?,`cat_id`=?,`content`=?,`create_time`=?,`diggdns`=?,`diggups`=?,`high_color`=?,`high_expire_date`=?,`is_digest`=?,`is_hide_post`=?,`is_reply_notice`=?,`is_solved`=?,`last_nickname`=?,`last_post_time`=?,`last_post_user`=?,`nickname`=?,`remote_ip`=?,`replies`=?,`reward`=?,`section_id`=?,`spec_type`=?,`state`=?,`title`=?,`top_expire_date`=?,`top_scope`=?,`update_time`=?,`update_user`=?,`user_id`=?,`visits`=?,`board_id`=?,`likes`=?,`username`=? where topic_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("update ejf_topic set `attach_icon`=?,`attaches`=?,`cat_id`=?,`content`=?,`create_time`=?,`diggdns`=?,`diggups`=?,`high_color`=?,`high_expire_date`=?,`is_digest`=?,`is_hide_post`=?,`is_reply_notice`=?,`is_solved`=?,`last_nickname`=?,`last_post_time`=?,`last_post_user`=?,`nickname`=?,`remote_ip`=?,`replies`=?,`reward`=?,`section_id`=?,`spec_type`=?,`state`=?,`title`=?,`top_expire_date`=?,`top_scope`=?,`update_time`=?,`update_user`=?,`user_id`=?,`visits`=?,`board_id`=?,`likes`=?,`username`=? where topic_id=? ");
p.setString(1,topic.getAttachIcon());
p.setObject(2,topic.getAttaches());
p.setObject(3,topic.getCatId());
p.setString(4,topic.getContent());
p.setLong(5,topic.getCreateTime());
p.setObject(6,topic.getDiggdns());
p.setObject(7,topic.getDiggups());
p.setString(8,topic.getHighColor());
p.setLong(9,topic.getHighExpireDate());
p.setObject(10,topic.getIsDigest());
p.setObject(11,topic.getIsHidePost());
p.setString(12,topic.getIsReplyNotice());
p.setString(13,topic.getIsSolved());
p.setString(14,topic.getLastNickname());
p.setLong(15,topic.getLastPostTime());
p.setString(16,topic.getLastPostUser());
p.setString(17,topic.getNickname());
p.setString(18,topic.getRemoteIp());
p.setObject(19,topic.getReplies());
p.setObject(20,topic.getReward());
p.setObject(21,topic.getSectionId());
p.setObject(22,topic.getSpecType());
p.setObject(23,topic.getState());
p.setString(24,topic.getTitle());
p.setLong(25,topic.getTopExpireDate());
p.setObject(26,topic.getTopScope());
p.setLong(27,topic.getUpdateTime());
p.setString(28,topic.getUpdateUser());
p.setObject(29,topic.getUserId());
p.setObject(30,topic.getVisits());
p.setObject(31,topic.getBoardId());
p.setObject(32,topic.getLikes());
p.setString(33,topic.getUsername());
p.setInt(34,topic.getTopicId());

result=p.executeUpdate();
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return result;
}

public int delete(int topicId) {
PreparedStatement p = null;
int result=-1;
Connection conn=null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("delete from ejf_topic where topic_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("delete from ejf_topic where topic_id=? ");
p.setInt(1,topicId);

result=p.executeUpdate();
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return result;
}

public Topic get(int topicId) {
PreparedStatement p = null;
ResultSet r = null;
Connection conn=null;
Topic topic = null;
try {
//p = DbHotel.getIforum_index_dbConnection().prepareStatement("select `topic_id`,`attach_icon`,`attaches`,`cat_id`,`content`,`create_time`,`diggdns`,`diggups`,`high_color`,`high_expire_date`,`is_digest`,`is_hide_post`,`is_reply_notice`,`is_solved`,`last_nickname`,`last_post_time`,`last_post_user`,`nickname`,`remote_ip`,`replies`,`reward`,`section_id`,`spec_type`,`state`,`title`,`top_expire_date`,`top_scope`,`update_time`,`update_user`,`user_id`,`visits`,`board_id`,`likes`,`username` from ejf_topic where topic_id=? ");
conn =HikariDb.getConnection();
p=conn.prepareStatement("select `topic_id`,`attach_icon`,`attaches`,`cat_id`,`content`,`create_time`,`diggdns`,`diggups`,`high_color`,`high_expire_date`,`is_digest`,`is_hide_post`,`is_reply_notice`,`is_solved`,`last_nickname`,`last_post_time`,`last_post_user`,`nickname`,`remote_ip`,`replies`,`reward`,`section_id`,`spec_type`,`state`,`title`,`top_expire_date`,`top_scope`,`update_time`,`update_user`,`user_id`,`visits`,`board_id`,`likes`,`username` from ejf_topic where topic_id=? ");
p.setInt(1,topicId);

r=p.executeQuery();
while (r.next()) {
topic =new Topic();
setFindParamNo(r, topic);
}
} catch (Exception e) {
e.printStackTrace();
throw new DatabaseException(e);
} finally {
DbUtils.close(r, p);
DbUtils.closeConn(conn);
//DbHotel.closeIforum_index_dbConnection();
}
return topic;
}




protected void setFindParam(ResultSet r,Topic topic) throws Exception{
topic.setTopicId(r.getInt("topic_id"));
topic.setAttachIcon(r.getString("attach_icon"));
topic.setAttaches(r.getInt("attaches"));
topic.setCatId(r.getInt("cat_id"));
topic.setContent(r.getString("content"));
topic.setCreateTime(r.getLong("create_time"));
topic.setDiggdns(r.getInt("diggdns"));
topic.setDiggups(r.getInt("diggups"));
topic.setHighColor(r.getString("high_color"));
topic.setHighExpireDate(r.getLong("high_expire_date"));
topic.setIsDigest(r.getInt("is_digest"));
topic.setIsHidePost(r.getInt("is_hide_post"));
topic.setIsReplyNotice(r.getString("is_reply_notice"));
topic.setIsSolved(r.getString("is_solved"));
topic.setLastNickname(r.getString("last_nickname"));
topic.setLastPostTime(r.getLong("last_post_time"));
topic.setLastPostUser(r.getString("last_post_user"));
topic.setNickname(r.getString("nickname"));
topic.setRemoteIp(r.getString("remote_ip"));
topic.setReplies(r.getInt("replies"));
topic.setReward(r.getInt("reward"));
topic.setSectionId(r.getInt("section_id"));
topic.setSpecType(r.getInt("spec_type"));
topic.setState(r.getInt("state"));
topic.setTitle(r.getString("title"));
topic.setTopExpireDate(r.getLong("top_expire_date"));
topic.setTopScope(r.getInt("top_scope"));
topic.setUpdateTime(r.getLong("update_time"));
topic.setUpdateUser(r.getString("update_user"));
topic.setUserId(r.getInt("user_id"));
topic.setVisits(r.getInt("visits"));
topic.setBoardId(r.getInt("board_id"));
topic.setLikes(r.getInt("likes"));
topic.setUsername(r.getString("username"));
}

protected void setFindParamNo(ResultSet r,Topic topic) throws Exception{
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
}

}
