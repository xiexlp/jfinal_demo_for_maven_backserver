package com.js.isearch.dao;

/**
* last update time:"18-05-08 14:47:28"
* last update user:pku
*/

import com.js.isearch.orm.Postings;
import java.util.List;
import com.js.common.util.PageList;
import com.js.isearch.daoex.PostingsDaoEx;

public interface PostingsDao extends PostingsDaoEx{




    //放在dao里面
    public List<Long> findPostingIdByTokenIdDocId(long tokenId,long docId);


    //dao no bean
    public int incPositionsUpdateTimeByPostingId(String positions,long updateTime,long postingId);


    //dao no bean
    public int incFrequencyPositionsUpdateTimeByPostingId(int frequency,String positions,long updateTime,long postingId);



    //放在dao里面
    public List<Postings> findByDocId(long docId);

    //放在dao里面
    public PageList<Postings> findByAllPage(int pageNo,int total);


    //放在dao里面
    public PageList<Postings> findByDocIdPage(long docId,int pageNo,int total);



    //dao no bean
    public int updatePositionsUpdateTimeByPostingId(String positions,long updateTime,long postingId);



    //dao no bean
    public int incFrequencyUpdateTimeByPostingId(int frequencyInc,long updateTime,long postingId);


    //dao no bean
    public int deleteByPostingId(long postingId);

    //dao no bean
    public int deleteByDocId(long docId);

    //放在dao里面
    public List<Postings> findDocIdPositionsByToken(String token);


    //放在dao里面
    public List<Long> findPostingIdByTokenIdDocIdFieldname(long tokenId,long docId,String fieldname);


    //放在dao里面
    public List<Postings> findDocIdPositionsFieldnameByToken(String token);


}
