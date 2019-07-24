package com.js.isearch.servex;

/**
* last update time:"18-09-27 16:21:57"
* last update user:pku
*/

import com.js.isearch.orm.Postings;
import com.js.isearch.daoimplex.PostingsDaoimplEx;
import com.js.isearch.daoex.PostingsDaoEx;

import com.js.isearch.daoimpl.PostingsDaoimpl;
import com.js.isearch.dao.PostingsDao;
import java.util.List;
import com.js.common.util.PageList;

public class PostingsServEx{

private PostingsDaoEx postingsDaoEx;

public PostingsServEx(){
this.postingsDaoEx =new PostingsDaoimplEx();
}

public static PostingsServEx n(){
return new PostingsServEx();
}

public int save(Postings postings){
return this.postingsDaoEx.save(postings);
}
public int saveAutoId(Postings postings){
return this.postingsDaoEx.saveAutoId(postings);
}

public int saveAutoReturnId(Postings postings){
return this.postingsDaoEx.saveAutoReturnId(postings);
}


public Postings get(long postingId){
return this.postingsDaoEx.get(postingId);
}

public int delete(long postingId){
return this.postingsDaoEx.delete(postingId);
}

public int updateSet(String set,String where){
return this.postingsDaoEx.updateSet(set,where);
}

public int deleteWhere(String where){
return this.postingsDaoEx.deleteWhere(where);
}


public int update(Postings postings){
return this.postingsDaoEx.update(postings);
}

public List<Postings> find(String hql){
return this.postingsDaoEx.find(hql);
}

public List<Postings> findNames(List<String> names,String wherehql){
    return this.postingsDaoEx.findNames(names,wherehql);
    }


    public PageList<Postings> findNamesPage(List<String> names,String wherehql,int pageNo,int total){
        return this.postingsDaoEx.findNamesPage(names,wherehql,pageNo,total);
        }



public List<Postings> findAll(){
return this.postingsDaoEx.findAll();
}

public PageList<Postings> findByPage(int pageNo,int total){
return this.postingsDaoEx.findByPage(pageNo,total);
}

public PageList<Postings> findByPageOrder(int pageNo,int total,String fieldname,boolean asc){
return this.postingsDaoEx.findByPageOrder(pageNo,total,fieldname,asc);
}
        public List<Postings> findNameArray(String[] names,String wherehql){
        return this.postingsDaoEx.findNameArray(names,wherehql);
        }

        public PageList<Postings> findNameArrayPage(String[] names,String wherehql,int pageNo,int total){
        return this.postingsDaoEx.findNameArrayPage(names,wherehql,pageNo,total);
        }



}
