package com.js.isearch.servex;

/**
* last update time:"18-05-25 16:04:01"
* last update user:pku
*/

import com.js.isearch.orm.Doc;
import com.js.isearch.daoimplex.DocDaoimplEx;
import com.js.isearch.daoex.DocDaoEx;
import java.util.List;
import com.js.common.util.PageList;

public class DocServEx{

private DocDaoEx docDaoEx;

public DocServEx(){
this.docDaoEx =new DocDaoimplEx();
}

public static DocServEx n(){
return new DocServEx();
}

public int save(Doc doc){
return this.docDaoEx.save(doc);
}
public int saveAutoId(Doc doc){
return this.docDaoEx.saveAutoId(doc);
}

public int saveAutoReturnId(Doc doc){
return this.docDaoEx.saveAutoReturnId(doc);
}


public Doc get(long docId){
return this.docDaoEx.get(docId);
}

public int delete(long docId){
return this.docDaoEx.delete(docId);
}

public int update(Doc doc){
return this.docDaoEx.update(doc);
}

public List find(String hql){
return null;
}

public List<Doc> findAll(){
return this.docDaoEx.findAll();
}

public PageList<Doc> findByPage(int pageNo,int total){
return this.docDaoEx.findByPage(pageNo,total);
}

}
