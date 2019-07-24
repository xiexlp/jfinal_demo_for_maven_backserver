package com.js.isearch.dao;

/**
* last update time:"18-05-08 14:47:06"
* last update user:pku
*/

import com.js.isearch.orm.Doc;
import java.util.List;
import com.js.common.util.PageList;
import com.js.isearch.daoex.DocDaoEx;

public interface DocDao extends DocDaoEx{


    //dao no bean
    public int updateBodyUpdateTimeByDocId(String body,long updateTime,long docId);

    //dao no bean
    public int updateUpdateTimeIndexStatusByDocId(long updateTime,String indexStatus,long docId);


    //放在dao里面
    public PageList<Doc> findByAllPage(int pageNo,int total);


    public PageList<Doc> findByAllPageOrder(int pageNo,int total,String fieldname,boolean asc);

    //dao no bean
    public int updateIndexStageByDocId(int indexStage,long docId);


    //放在dao里面
    public List<Long> findDocIdByFieldnameFieldIdTablenameDbname(String fieldname,long fieldId,String tablename,String dbname);


    //放在dao里面
    public List<Doc> findByIndexStage(int indexStage);


//dao no bean
public int updateUrlByDocId(String url,long docId);


}