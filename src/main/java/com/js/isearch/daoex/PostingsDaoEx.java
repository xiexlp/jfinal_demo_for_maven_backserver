package com.js.isearch.daoex;

/**
* last update time:"18-09-27 16:21:57"
* last update user:pku
*/

import com.js.isearch.orm.Postings;
import java.util.List;
import com.js.common.util.PageList;

public interface PostingsDaoEx{

public int save(Postings postings);
public int saveAutoId(Postings postings);

public int saveAutoReturnId(Postings postings);


public Postings get(long postingId);

public int delete(long postingId);

public int update(Postings postings);

public int updateSet(String set,String where);

public int deleteWhere(String where);

public List<Postings> find(String hql);

public List<Postings> findNames(List<String> names,String wherehql);

    public PageList<Postings> findNamesPage(List<String> names,String wherehql,int pageNo,int total);
        public List<Postings> findNameArray(String[] names,String wherehql);

            public PageList<Postings> findNameArrayPage(String[] names,String wherehql,int pageNo,int total);


public List<Postings> findAll();

public PageList<Postings> findByPage(int pageNo,int total);

public PageList<Postings> findByPageOrder(int pageNo,int total,String fieldname,boolean asc);

}
