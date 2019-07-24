package com.js.cluster.nginx.backserver.orm;

import java.util.List;

public class Position {
    //long docId;
    String fieldname;
    WordPos wordPos;
    String query ;
    List<Integer> posList;

    public Position(){}
    public Position(String fieldname,WordPos wordPos){
        this.fieldname = fieldname;
        this.wordPos = wordPos;
        this.query = wordPos.getWord();
    }

    public Position(String fieldname,String query){
        this.fieldname = fieldname;
        this.query = query;
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public List<Integer> getPosList() {
        return posList;
    }

    public void setPosList(List<Integer> posList) {
        this.posList = posList;
    }


    public WordPos getWordPos() {
        return wordPos;
    }

    public void setWordPos(WordPos wordPos) {
        this.wordPos = wordPos;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
