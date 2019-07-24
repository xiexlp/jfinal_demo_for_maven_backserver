package com.js.isearch.daoex;

/**
* last update time:"18-05-14 15:20:13"
* last update user:pku
*/

import com.js.isearch.orm.Token;
import java.util.List;
import com.js.common.util.PageList;

public interface TokenDaoEx{

public int save(Token token);
public int saveAutoId(Token token);

public int saveAutoReturnId(Token token);


public Token get(long tokenId);

public int delete(long tokenId);

public int update(Token token);

public List find(String hql);

public List<Token> findAll();

public PageList<Token> findByPage(int pageNo,int total);

}
