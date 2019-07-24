package com.js.isearch.orm;

/**
* last update time:"18-05-08 14:46:54"
* last update user:pku
*/

import java.sql.Timestamp;
import com.js.common.anno.TableAnno;
import com.js.common.util.TimeUtil;
import com.js.isearch.config.GeneralConfig;
import com.js.isearch.ormex.DocEx;
import java.util.HashMap;
import java.util.Map;

@TableAnno(name="ejf_doc")
public class Doc extends DocEx{


    public String getCreateTimeFormat(){
        return TimeUtil.getTimeFormat(getCreateTime(), GeneralConfig.TIME_FORMAT1);
    }

    double score;
    int hitCount;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public Doc addScore(double addNum){
        this.score = this.score+addNum;
        return this;
    }
}