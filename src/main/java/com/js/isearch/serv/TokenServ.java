package com.js.isearch.serv;

/**
* last update time:"18-05-08 14:47:50"
* last update user:pku
*/

import com.js.isearch.orm.Token;
import com.js.isearch.daoimpl.TokenDaoimpl;
import com.js.isearch.dao.TokenDao;
import com.js.isearch.servex.TokenServEx;
import java.util.List;
import com.js.common.util.PageList;

public class TokenServ extends TokenServEx{

private TokenDao tokenDao;

public TokenServ(){
this.tokenDao =new TokenDaoimpl();
}

public static TokenServ n(){
return new TokenServ();
}


    //放在server里面
    public List<Long> findTokenIdByToken(String token){
        return tokenDao.findTokenIdByToken(token);
    }


    //server no bean
    public int incDocCount(long tokenId,int num){
        return tokenDao.incDocCount(tokenId,num);
    }


    //放在server里面
    public PageList<Token> findByAllPage(int pageNo,int total){
        return tokenDao.findByAllPage(pageNo,total);
    }

    public PageList<Token> findByAllPageOrder(int pageNo,int total,String fieldname,boolean asc){
        return tokenDao.findByAllPage(pageNo,total,fieldname,asc);
    }

    //server no bean
    public int updateDocs(String docs,long tokenId){
        return tokenDao.updateDocs(docs,tokenId);
    }

    //server no bean
    public int updateDocCountDocs(int docCount,String docs,long tokenId){
        return tokenDao.updateDocCountDocs(docCount,docs,tokenId);
    }



}
