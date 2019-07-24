package com.js.cluster.nginx.backserver.controller;

import com.js.common.util.*;
import com.js.isearch.orm.CurrencyPos;
import com.js.isearch.orm.CurrencyStatus;
import com.js.isearch.serv.CurrencyPosServ;
import com.js.cluster.nginx.backserver.controllerex.CurrencyPosControllerEx;

import java.util.List;

import com.js.common.util.PageList;
import com.js.isearch.serv.CurrencyStatusServ;
import com.js.isearch.servread.CurrencyPosServRead;

import java.sql.Timestamp;


public class CurrencyPosController extends CurrencyPosControllerEx {

    public void currencyPosadd() {
        String method = getRequest().getMethod();
        if (method.equalsIgnoreCase("GET")) {
//List<Group> groups = GroupServ.n().findAll();
            //  setAttr("groups",groups);
            //List<Manufacturer> manus = ManufacturerServ.n().findAll();
            //System.out.println("manus size:"+manus.size());
            //setAttr("manus",manus);
            //render("currencyPosnew.html");
        } else if (method.equalsIgnoreCase("POST")) {
            //User user = getUserFromRequest();
            CurrencyPos currencyPos = getCurrencyPosFromRequest();
            //int r = UserServ.n().saveAutoId(user);

            int r = CurrencyPosServ.n().saveAutoId(currencyPos);


            if (r > 0) {
                redirect("/boot/currencyPos/currencyPoss");
            } else {
                System.out.println("新增失败");
            }
        }
    }


    public void currencyPosupdate() {
        String method = getRequest().getMethod();
        if (method.equalsIgnoreCase("GET")) {
            //List<Manufacturer> manus = ManufacturerServ.n().findAll();
            //System.out.println("manus size:"+users.size());
            //List<Group> groups = GroupServ.n().findAll();
            //System.out.println("group size:"+groups.size());
            //int userID= getIntPara("userID", 1);

            int currencyPosId = getIntPara("currencyPosId", 1);
            if (currencyPosId == 0) {
                System.out.println("出错");
                return;
            }
            CurrencyPos currencyPos = CurrencyPosServ.n().get(currencyPosId);
            //setAttr("groups",groups);
            setAttr("currencyPos", currencyPos);
            //render("currencyPosupdate.html");
        } else if (method.equalsIgnoreCase("POST")) {
            CurrencyPos currencyPos = getCurrencyPosFromRequestEdit();
            if (currencyPos == null) {
                System.out.println("id不存在");
                return;
            }
            CurrencyPosServ currencyPosServ = CurrencyPosServ.n();
            int r = 0;
            r = currencyPosServ.update(currencyPos);
            if (r > 0) redirect("/boot/currencyPos/currencyPoss");
            else {
                System.out.println("出错");
            }
        }
    }

    //controller list方法，放在controller里面
    public void currencyPosPartPage() {

        long startTime = System.currentTimeMillis();

        int pageNo = getIntPara("pageNo", 1);
        String sortBy = getStrPara("sortBy","");
        int sort = getIntPara("sort",0);

        CurrencyStatus currencyStatus= CurrencyStatusServ.n().get(1);
        int panelNum =currencyStatus.getPosPanelNum();
        long posLastBatchTime = currencyStatus.getPosLastBatchTime();
        String posLastBatchTimeFormat = TimeUtil.getTimeFormat(posLastBatchTime,TimeUtil.DATE_FORMAT);

        PageList<CurrencyPos> currencyPoslist = CurrencyPosServRead.n().find_OrderBy_ByBatchTimeEqPage(posLastBatchTime,pageNo, panelNum,sortBy,sort);
        setAttr("currencyPoslist", currencyPoslist);
        setAttr("posLastBatchTimeFormat",posLastBatchTimeFormat);
        setAttr("sortBy",sortBy);
        setAttr("sort",sort);
        System.out.println("list size:" + currencyPoslist.size());
        String actionUrl = "currencyPosPartPage?1=1";
        //不为空的话
        if(!sortBy.equalsIgnoreCase("")) {
            actionUrl = "currencyPosPartPage?1=1&sortBy="+sortBy+"&sort="+sort;
        }
        setPageInfo(currencyPoslist, actionUrl);

        long endTime = System.currentTimeMillis();

        System.out.println("花费时间:"+(endTime-startTime));

        //render("currencyPoss.html");
    }

    //controller list方法，放在controller里面
    public void currencyPosPartPage_microservice() {


        long startTime = System.currentTimeMillis();
        int pageNo = getIntPara("pageNo", 1);
        String sortBy = getStrPara("sortBy","");
        int sort = getIntPara("sort",0);

        CurrencyStatus currencyStatus= CurrencyStatusServ.n().get(1);
        int panelNum =currencyStatus.getPosPanelNum();
        long posLastBatchTime = currencyStatus.getPosLastBatchTime();
        String posLastBatchTimeFormat = TimeUtil.getTimeFormat(posLastBatchTime,TimeUtil.DATE_FORMAT);

        PageList<CurrencyPos> currencyPoslist = CurrencyPosServRead.n().find_OrderBy_ByBatchTimeEqPage(posLastBatchTime,pageNo, panelNum,sortBy,sort);
        setAttr("currencyPoslist", currencyPoslist);
        setAttr("posLastBatchTimeFormat",posLastBatchTimeFormat);
        setAttr("sortBy",sortBy);
        setAttr("sort",sort);
        System.out.println("list size:" + currencyPoslist.size());
        String actionUrl = "currencyPosPartPage?1=1";
        //不为空的话
        if(!sortBy.equalsIgnoreCase("")) {
            actionUrl = "currencyPosPartPage?1=1&sortBy="+sortBy+"&sort="+sort;
        }
        setPageInfo(currencyPoslist, actionUrl);

        PageArray pageArray = new PageArray();

        pageArray.setActionUrl(actionUrl);
        pageArray.setDataList(currencyPoslist);
        pageArray.setPageNo(currencyPoslist.getPageNo());
        pageArray.setPageSize(currencyPoslist.getPageSize());
        pageArray.setTotal(currencyPoslist.getTotal());
        pageArray.setPageTotal(currencyPoslist.getPageTotal());
        pageArray.setSort(sort);
        pageArray.setSortBy(sortBy);

        long endTime = System.currentTimeMillis();

        System.out.println("花费时间:"+(endTime-startTime));

        renderJson(pageArray);
        //render("currencyPoss.html");
    }

    //controller list方法，放在controller里面
    public void currencyPoss() {
        int pageNo = getIntPara("pageNo", 1);
        PageList<CurrencyPos> currencyPoslist = CurrencyPosServ.n().findByPage(pageNo, 21);
        setAttr("currencyPoslist", currencyPoslist);
        System.out.println("list size:" + currencyPoslist.size());
        String actionUrl = "currencyPoss?1=1";
        setPageInfo(currencyPoslist, actionUrl);
//render("currencyPoss.html");
    }


}