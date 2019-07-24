package com.js.isearch.servupdate;

/**
* last update time:"19-01-31 20:04:40"
* last update user:pku
*/

import com.js.isearch.orm.Doc;
import com.js.isearch.daoimpl.DocDaoimpl;
import com.js.isearch.dao.DocDao;
import com.js.isearch.servex.DocServEx;
import java.util.List;
import com.js.common.util.PageList;

public class DocServUpdate extends DocServEx{

private DocDao docDao;

public DocServUpdate(){
this.docDao =new DocDaoimpl();
}

public static DocServUpdate n(){
return new DocServUpdate();
}
//server no bean
public int updateUrlByDocId(String url,long docId){
return docDao.updateUrlByDocId(url,docId);
}

}