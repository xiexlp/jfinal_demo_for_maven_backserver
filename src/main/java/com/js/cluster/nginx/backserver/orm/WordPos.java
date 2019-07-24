package com.js.cluster.nginx.backserver.orm;

public class WordPos {

    String word;
    int pos;
    int endOffset;
    int posIncrement;
    String type;


    public WordPos(String word,int pos,int endOffset,int posIncrement,String type){
        this.word =word;
        this.pos = pos;
        this.endOffset = endOffset;
        this.posIncrement = posIncrement;
        this.type = type;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getPosIncrement() {
        return posIncrement;
    }

    public void setPosIncrement(int posIncrement) {
        this.posIncrement = posIncrement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEndOffset() {
        return endOffset;
    }

    public void setEndOffset(int endOffset) {
        this.endOffset = endOffset;
    }
}
