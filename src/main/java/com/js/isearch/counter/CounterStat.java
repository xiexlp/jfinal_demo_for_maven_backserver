package com.js.isearch.counter;


/**
 * 对每个板块帖子进行计数
 */
public class CounterStat {

    public static void main(String[] args) {
        String dbname="iforum";
        int boardId = 1;
        String countSql  = "select count(*) from ejf_topic as t where t.board_id="+ boardId;
       int count =  DbCounterUtil.query(dbname,countSql);
        System.out.println("count:"+count);
    }






}
