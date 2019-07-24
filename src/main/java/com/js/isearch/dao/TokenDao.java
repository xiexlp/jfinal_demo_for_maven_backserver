package com.js.isearch.dao;

/**
* last update time:"18-05-08 14:47:48"
* last update user:pku
*/

import com.js.isearch.orm.Token;
import java.util.List;
import com.js.common.util.PageList;
import com.js.isearch.daoex.TokenDaoEx;

public interface TokenDao extends TokenDaoEx{


    //放在dao里面
    public List<Long> findTokenIdByToken(String token);


    //dao no bean
    public int incDocCount(long tokenId,int num);

    //放在dao里面
    public PageList<Token> findByAllPage(int pageNo,int total);


    public PageList<Token> findByAllPage(int pageNo,int total,String fieldname,boolean asc);


    //dao no bean
    public int updateDocs(String docs,long tokenId);

    //dao no bean
    public int updateDocCountDocs(int docCount,String docs,long tokenId);

}
