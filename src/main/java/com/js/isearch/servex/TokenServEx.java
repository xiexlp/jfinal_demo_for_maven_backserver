package com.js.isearch.servex;

/**
* last update time:"18-05-14 15:20:15"
* last update user:pku
*/

import com.js.isearch.orm.Token;
import com.js.isearch.daoimplex.TokenDaoimplEx;
import com.js.isearch.daoex.TokenDaoEx;
import java.util.List;
import com.js.common.util.PageList;

public class TokenServEx{

private TokenDaoEx tokenDaoEx;

public TokenServEx(){
this.tokenDaoEx =new TokenDaoimplEx();
}

public static TokenServEx n(){
return new TokenServEx();
}

public int save(Token token){
return this.tokenDaoEx.save(token);
}
public int saveAutoId(Token token){
return this.tokenDaoEx.saveAutoId(token);
}

public int saveAutoReturnId(Token token){
return this.tokenDaoEx.saveAutoReturnId(token);
}


public Token get(long tokenId){
return this.tokenDaoEx.get(tokenId);
}

public int delete(long tokenId){
return this.tokenDaoEx.delete(tokenId);
}

public int update(Token token){
return this.tokenDaoEx.update(token);
}

public List find(String hql){
return null;
}

public List<Token> findAll(){
return this.tokenDaoEx.findAll();
}

public PageList<Token> findByPage(int pageNo,int total){
return this.tokenDaoEx.findByPage(pageNo,total);
}

}
