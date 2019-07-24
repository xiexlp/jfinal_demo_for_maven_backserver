package com.js.isearch.servread;

/**
* last update time:"19-01-31 20:04:39"
* last update user:pku
*/

import com.js.isearch.orm.Doc;
import com.js.isearch.daoimpl.DocDaoimpl;
import com.js.isearch.dao.DocDao;
import com.js.isearch.servex.DocServEx;
import java.util.List;
import com.js.common.util.PageList;

public class DocServRead extends DocServEx{

private DocDao docDao;

public DocServRead(){
this.docDao =new DocDaoimpl();
}

public static DocServRead n(){
return new DocServRead();
}

}
