package com.js.cluster.nginx.backserver.orm;

import com.js.isearch.orm.Doc;
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.List;

public class Hit implements Comparable<Hit>{

    long docId;
    String title;
    String body;
    String url;
    String query;

    int hitCount=0;
    double score=0;
    double distance;
    //命中的首位置
    List<Integer> shotStartPosList =new ArrayList<>();
    List<Position> postionList=new ArrayList<>();

    int titleCount=0;
    int contentCount=0;

    public Hit(){
    }

    public Hit(Doc doc){
        this.docId = doc.getDocId();
        this.title = doc.getTitle();
        //纯文本
        this.body = Jsoup.parse(doc.getBody()).text();
        this.url = doc.getUrl();
        this.score = doc.getScore();
        this.hitCount = doc.getHitCount();
        //this.query = query;
    }

    public long getDocId() {
        return docId;
    }

    public void setDocId(long docId) {
        this.docId = docId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Position> getPostionList() {
        return postionList;
    }

    public void setPostionList(List<Position> postionList) {
        this.postionList = postionList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<Integer> getShotStartPosList() {
        return shotStartPosList;
    }

    public void setShotStartPosList(List<Integer> shotStartPosList) {
        this.shotStartPosList = shotStartPosList;
    }


    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public Hit addScore(double addNum){
        this.score = this.score+addNum;
        return this;
    }


    public int getTitleCount() {
        return titleCount;
    }

    public void setTitleCount(int titleCount) {
        this.titleCount = titleCount;
    }

    public int getContentCount() {
        return contentCount;
    }

    public void setContentCount(int contentCount) {
        this.contentCount = contentCount;
    }

    @Override
    public int compareTo(Hit o) {
        if(this.score>o.getScore()){
            return -1;
        }else if (this.score==o.getScore()){
            return 0;
        }else {
            return 1;
        }
    }
}
