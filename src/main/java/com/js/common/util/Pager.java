package com.js.common.util;

import java.util.List;

/**
 * 这个类专门使用于json,数据的存取
 */
public class Pager<Hit> {

    PageInfo pageInfo;
    List<Hit> hitList;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }


    public List<Hit> getHitList() {
        return hitList;
    }

    public void setHitList(List<Hit> hitList) {
        this.hitList = hitList;
    }
}
