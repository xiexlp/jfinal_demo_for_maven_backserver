package com.js.isearch.serv;

/**
* last update time:"18-05-08 14:47:31"
* last update user:pku
*/

import com.js.isearch.orm.Postings;
import com.js.isearch.daoimpl.PostingsDaoimpl;
import com.js.isearch.dao.PostingsDao;
import com.js.isearch.servex.PostingsServEx;
import java.util.List;
import com.js.common.util.PageList;

public class PostingsServ extends PostingsServEx{

private PostingsDao postingsDao;

public PostingsServ(){
this.postingsDao =new PostingsDaoimpl();
}

public static PostingsServ n(){
return new PostingsServ();
}


    //放在server里面
    public List<Long> findPostingIdByTokenIdDocId(long tokenId,long docId){
        return postingsDao.findPostingIdByTokenIdDocId(tokenId,docId);
    }


    //server no bean
    public int incPositionsUpdateTimeByPostingId(String positions,long updateTime,long postingId){
        return postingsDao.incPositionsUpdateTimeByPostingId(positions,updateTime,postingId);
    }

    //server no bean
    public int incFrequencyPositionsUpdateTimeByPostingId(int frequency,String positions,long updateTime,long postingId){
        return postingsDao.incFrequencyPositionsUpdateTimeByPostingId(frequency,positions,updateTime,postingId);
    }


    //放在server里面
    public List<Postings> findByDocId(long docId){
        return postingsDao.findByDocId(docId);
    }


    //放在server里面
    public PageList<Postings> findByDocIdPage(long docId,int pageNo,int total){
        return postingsDao.findByDocIdPage(docId,pageNo,total);
    }


    //放在server里面
    public PageList<Postings> findByAllPage(int pageNo,int total){
        return postingsDao.findByAllPage(pageNo,total);
    }


    //server no bean
    public int updatePositionsUpdateTimeByPostingId(String positions,long updateTime,long postingId){
        return postingsDao.updatePositionsUpdateTimeByPostingId(positions,updateTime,postingId);
    }



    //server no bean
    public int incFrequencyUpdateTimeByPostingId(int frequencyInc,long updateTime,long postingId){
        return postingsDao.incFrequencyUpdateTimeByPostingId(frequencyInc,updateTime,postingId);
    }


    //server no bean
    public int deleteByPostingId(long postingId){
        return postingsDao.deleteByPostingId(postingId);
    }

    //server no bean
    public int deleteByDocId(long docId){
        return postingsDao.deleteByDocId(docId);
    }


    /**
     * 搜索
     */
    //放在server里面
    public List<Postings> findDocIdPositionsByToken(String token){
        return postingsDao.findDocIdPositionsByToken(token);
    }

    //放在server里面
    public List<Postings> findDocIdPositionsFieldnameByToken(String token){
        return postingsDao.findDocIdPositionsFieldnameByToken(token);
    }


    //放在server里面
    public List<Long> findPostingIdByTokenIdDocIdFieldname(long tokenId,long docId,String fieldname){
        return postingsDao.findPostingIdByTokenIdDocIdFieldname(tokenId,docId,fieldname);
    }





}
