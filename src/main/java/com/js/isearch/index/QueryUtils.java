package com.js.isearch.index;


import com.js.common.util.PageList;
import com.js.isearch.orm.Query;
import com.js.isearch.orm.QueryLog;
import com.js.isearch.serv.QueryLogServ;
import com.js.isearch.serv.QueryServ;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 对用户的查询行为进行分析和统计,将日志中的用户输入分词存入到query表格中
 */
public class QueryUtils {


    public static void main(String[] args) {


    }

    public static void main_deleteWhere(String[] args) {
        String where = "where log_id=1";
        int result = QueryLogServ.n().deleteWhere(where);
    }

    public static void main_updateSet(String[] args) {
        String set=" set index_status=1";
        String where = " where log_id=1";
        int result =QueryLogServ.n().updateSet(set,where);
        System.out.println("update result:"+result);
    }

    /***
     * 搜索 指定字段，分页，需要置顶查询条件,注意返回来的结果在map里面，还需要设定
     * @param args
     */
    public static void main_findNamesPage(String[] args) {
        List<String> fieldnames = new ArrayList<>();
        fieldnames.add("log_id");fieldnames.add("query");

        PageList<QueryLog> queryLogs = QueryLogServ.n().findNamesPage(fieldnames,"where index_status=1",1,21);
        System.out.println("查询数目:"+queryLogs.size());
        for(QueryLog queryLog:queryLogs){
            queryLog.setQuery((String)queryLog.getMap().get("query"));
            //System.out.println(queryLog.getQuery());
            String query = (String)queryLog.getMap().get("query");
            System.out.println(query);
            System.out.println("queryLog query:"+queryLog.getQuery());
        }
    }

    /***
     * 使用 sql 语句查询部分字段
     * @param args
     */
    public static void main_findNames(String[] args) {
        List<String> fieldnames = new ArrayList<>();
        fieldnames.add("log_id");fieldnames.add("query");

        List<QueryLog> queryLogs = QueryLogServ.n().findNames(fieldnames,"where index_status=1");
        System.out.println("查询数目:"+queryLogs.size());
        for(QueryLog queryLog:queryLogs){
            String query = (String)queryLog.getMap().get("query");
            System.out.println(query);
        }
    }


    /**
     * 使用sql语句查询
     * @param args
     */
    public static void main_findsql(String[] args) {
        List<QueryLog> queryLogs = QueryLogServ.n().find("select * from ejf_query_log where index_status=1");
        System.out.println("查询数目:"+queryLogs.size());
        for(QueryLog queryLog:queryLogs){
            System.out.println(queryLog.getQuery());
            String query = queryLog.getQuery();
            System.out.println(query);
        }
    }


    /**
     * 分词
     * @param query
     */
    public static void anlyze(String query) {
        //构建IK分词器，使用smart分词模式
        Analyzer analyzer = new IKAnalyzer(false, true, false);

        //获取Lucene的TokenStream对象
        TokenStream ts = null;
        try {
            ts = analyzer.tokenStream("myfield", new StringReader(query));
            //获取词元位置属性
            OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
            //获取词元文本属性
            CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
            //获取词元文本属性
            TypeAttribute type = ts.addAttribute(TypeAttribute.class);
            PositionIncrementAttribute pos = ts.addAttribute(PositionIncrementAttribute.class);
            //重置TokenStream（重置StringReader）
            ts.reset();
            //迭代获取分词结果
            while (ts.incrementToken()) {
                System.out.println(offset.startOffset() + " - " + offset.endOffset() + " : " + pos.getPositionIncrement() + " | " + term.toString() + " | " + type.type());
                String t = term.toString();
            }
            //关闭TokenStream（关闭StringReader）
            ts.end();   // Perform end-of-stream operations, e.g. set the final offset.
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放TokenStream的所有资源
            if (ts != null) {
                try {
                    ts.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /**
     * 分词
     * @param queryLog
     */
    public static void anlyzeLog(QueryLog queryLog) {
        //构建IK分词器，使用smart分词模式
        //Analyzer analyzer = new IKAnalyzer(false, true, false);
        Analyzer analyzer = new IKAnalyzer(true, true, true);
        //获取Lucene的TokenStream对象
        TokenStream ts = null;
        try {
            ts = analyzer.tokenStream("myfield", new StringReader(queryLog.getQuery()));
            //获取词元位置属性
            OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
            //获取词元文本属性
            CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
            //获取词元文本属性
            TypeAttribute type = ts.addAttribute(TypeAttribute.class);
            PositionIncrementAttribute pos = ts.addAttribute(PositionIncrementAttribute.class);
            //重置TokenStream（重置StringReader）
            ts.reset();
            //迭代获取分词结果
            while (ts.incrementToken()) {
                System.out.println(offset.startOffset() + " - " + offset.endOffset() + " : " + pos.getPositionIncrement() + " | " + term.toString() + " | " + type.type());
                String t = term.toString();

                int len = term.toString().length();
                System.out.println("len:"+len);
                if(len<IndexConfig.TOKEN_MIN_LENGTH) continue;

                Query query1 = new Query();
                query1.setCreateTime(queryLog.getCreateTime());
                query1.setQuery(queryLog.getQuery());
                query1.setToken(t);
                query1.setUpdateTime(System.currentTimeMillis());

                int r=QueryServ.n().saveAutoId(query1);
                if(r>0){
                    System.out.println("查询分析成功");

                    queryLog.setIndexStatus(1);
                    QueryLogServ.n().update(queryLog);

                }else {
                    System.out.println("查询分析失败");
                }
            }
            //关闭TokenStream（关闭StringReader）
            ts.end();   // Perform end-of-stream operations, e.g. set the final offset.
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放TokenStream的所有资源
            if (ts != null) {
                try {
                    ts.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
