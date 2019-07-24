package com.js.cluster.nginx.backserver.orm;

import com.js.isearch.orm.Doc;

import java.util.ArrayList;
import java.util.List;

public class DocResult {

    private Long docId;
    private String fieldname;
    private String title;
    private String content;

    private List<Position> positionList=new ArrayList<>();

    public DocResult(long docId,String fieldname){
        this.docId =docId;
        this.fieldname = fieldname;
    }

    public DocResult(Doc doc, String fieldname){
        this.docId = doc.getDocId();
        this.fieldname =fieldname;
        this.title = doc.getTitle();
        this.content = doc.getBody();
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }

    public String toString(){
           StringBuffer sb = new StringBuffer();
           sb.append("docId:");
           sb.append(getDocId()).append(",");
           sb.append("fieldname:");
           sb.append(getFieldname());
           return sb.toString();
    }
}
