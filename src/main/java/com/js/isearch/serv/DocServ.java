package com.js.isearch.serv;

/**
* last update time:"18-05-08 14:47:09"
* last update user:pku
*/

import com.js.isearch.orm.Doc;
import com.js.isearch.daoimpl.DocDaoimpl;
import com.js.isearch.dao.DocDao;
import com.js.isearch.servex.DocServEx;
import java.util.List;
import com.js.common.util.PageList;

public class DocServ extends DocServEx{

private DocDao docDao;

public DocServ(){
this.docDao =new DocDaoimpl();
}

public static DocServ n(){
return new DocServ();
}

    //server no bean
    public int updateBodyUpdateTimeByDocId(String body,long updateTime,long docId){
        return docDao.updateBodyUpdateTimeByDocId(body,updateTime,docId);
    }


    //server no bean
    public int updateUpdateTimeIndexStatusByDocId(long updateTime,String indexStatus,long docId){
        return docDao.updateUpdateTimeIndexStatusByDocId(updateTime,indexStatus,docId);
    }


    //放在server里面
    public PageList<Doc> findByAllPage(int pageNo,int total){
        return docDao.findByAllPage(pageNo,total);
    }


    //放在server里面
    public PageList<Doc> findByAllPageOrder(int pageNo,int total,String fieldname,boolean asc){
        return docDao.findByAllPageOrder(pageNo,total,fieldname,asc);
    }


    //server no bean
    public int updateIndexStageByDocId(int indexStage,long docId){
        return docDao.updateIndexStageByDocId(indexStage,docId);
    }
    
    
  //放在server里面
    public List<Long> findDocIdByFieldnameFieldIdTablenameDbname(String fieldname,long fieldId,String tablename,String dbname){
    return docDao.findDocIdByFieldnameFieldIdTablenameDbname(fieldname,fieldId,tablename,dbname);
    }



    //放在server里面
    public List<Doc> findByIndexStage(int indexStage){
        return docDao.findByIndexStage(indexStage);
    }










}
