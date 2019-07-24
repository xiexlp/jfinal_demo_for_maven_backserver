package com.js.isearch.daoex;

/**
* last update time:"18-05-25 16:03:58"
* last update user:pku
*/

import com.js.isearch.orm.Doc;
import java.util.List;
import com.js.common.util.PageList;

public interface DocDaoEx{

public int save(Doc doc);
public int saveAutoId(Doc doc);

public int saveAutoReturnId(Doc doc);


public Doc get(long docId);

public int delete(long docId);

public int update(Doc doc);

public List find(String hql);

public List<Doc> findAll();

public PageList<Doc> findByPage(int pageNo,int total);

}
