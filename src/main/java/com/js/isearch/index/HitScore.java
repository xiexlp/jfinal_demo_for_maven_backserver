package com.js.isearch.index;

import com.js.cluster.nginx.backserver.orm.Hit;
import com.js.cluster.nginx.backserver.orm.Position;
import com.js.cluster.nginx.backserver.orm.WordPos;

import java.util.ArrayList;
import java.util.List;

/***
 * 使用hitscore准确搜索出命中的位置
 */
public class HitScore {

    public static void scoreHitList(List<Hit> hitList){
        int size = hitList.size();
        Hit hit = null;
        for(int i=0;i<size;i++){
            hit = hitList.get(i);
            scoreAHit(hit);
        }
    }

    /***
     * 准确搜索出命中的位置
     * @param hit
     */
    public static void scoreAHit(Hit hit){
        List<Position> positionList =hit.getPostionList();
        //Position position =null;
        int posSize = 0;
        //positionList = hit.getPostionList();
        posSize = positionList.size();

        Integer[] queryDistance = new Integer[posSize-1];
        WordPos lastWordPos =positionList.get(0).getWordPos();
        WordPos wordPos =null;
        for(int i=1;i<posSize;i++){
            wordPos = positionList.get(i).getWordPos();
            queryDistance[i-1]=wordPos.getPos()-lastWordPos.getPos();
            lastWordPos = wordPos;
        }
        System.out.println("last query distance:"+queryDistance);
        showIntegerArray(queryDistance);

        Position nextPosition= null;

        Position position= positionList.get(0);
        List<Integer> posList = position.getPosList();
        int posLen= posList.size();

        List<Integer> shotPosStartList=new ArrayList<>();

        for(int i=0;i<posLen;i++){
            int pos = posList.get(i);
            int lastPos =pos;
            int posDistanceSum=0;
            int posDistanceDifSum=0;
            row:for(int j=1;j<posSize;j++){
                nextPosition = positionList.get(j);
                int len = nextPosition.getPosList().size();
                line:for(int k=0;k<len;k++){
                    int nextPos = nextPosition.getPosList().get(k);
                    if(nextPos<=lastPos) continue line;
                    else {
                        int distance = nextPos-lastPos;
                        int distanceDif = distance-queryDistance[j-1];
                        posDistanceSum+=distance;
                        posDistanceDifSum+=distanceDif;
                        lastPos = nextPos;
                        if(distanceDif<2) continue row;
                    }
                }
            }
            //如果posDistanceSum小于2*长度之后，算命中
            if(posDistanceSum<=2*posLen){
                shotPosStartList.add(pos);
            }
            //如果posDistanceDifSum小于1*长度，算命中
            if(posDistanceDifSum<=1*posLen){
                shotPosStartList.add(pos);
            }
        }
        hit.setShotStartPosList(shotPosStartList);
        //越多分数越高
        hit.setScore(shotPosStartList.size());
    }

    public static void showIntegerArray(Integer[] distances){
        System.out.println("array integer:");
        int len = distances.length;
        for(Integer i:distances){
            System.out.println(" "+i);
        }
    }


}
