package com.js.cluster.nginx.backserver.controller;

import com.js.common.util.*;
import com.js.isearch.orm.CurrencyPos;
import com.js.isearch.orm.CurrencyPrice;
import com.js.isearch.orm.CurrencyStatus;
import com.js.isearch.serv.CurrencyPriceServ;
import com.js.cluster.nginx.backserver.controllerex.CurrencyPriceControllerEx;

import java.util.List;

import com.js.common.util.PageList;
import com.js.isearch.serv.CurrencyStatusServ;
import com.js.isearch.servread.CurrencyPosServRead;
import com.js.isearch.servread.CurrencyPriceServRead;

import java.sql.Timestamp;


public class CurrencyPriceController extends CurrencyPriceControllerEx {

    public void currencyPriceadd() {
        String method = getRequest().getMethod();
        if (method.equalsIgnoreCase("GET")) {
//List<Group> groups = GroupServ.n().findAll();
            //  setAttr("groups",groups);
            //List<Manufacturer> manus = ManufacturerServ.n().findAll();
            //System.out.println("manus size:"+manus.size());
            //setAttr("manus",manus);
            //render("currencyPricenew.html");
        } else if (method.equalsIgnoreCase("POST")) {
            //User user = getUserFromRequest();
            CurrencyPrice currencyPrice = getCurrencyPriceFromRequest();
            //int r = UserServ.n().saveAutoId(user);

            int r = CurrencyPriceServ.n().saveAutoId(currencyPrice);


            if (r > 0) {
                redirect("/boot/currencyPrice/currencyPrices");
            } else {
                System.out.println("新增失败");
            }
        }
    }


    public void currencyPriceupdate() {
        String method = getRequest().getMethod();
        if (method.equalsIgnoreCase("GET")) {
            //List<Manufacturer> manus = ManufacturerServ.n().findAll();
            //System.out.println("manus size:"+users.size());
            //List<Group> groups = GroupServ.n().findAll();
            //System.out.println("group size:"+groups.size());
            //int userID= getIntPara("userID", 1);

            int currencyPriceId = getIntPara("currencyPriceId", 1);
            if (currencyPriceId == 0) {
                System.out.println("出错");
                return;
            }
            CurrencyPrice currencyPrice = CurrencyPriceServ.n().get(currencyPriceId);
            //setAttr("groups",groups);
            setAttr("currencyPrice", currencyPrice);
            //render("currencyPriceupdate.html");
        } else if (method.equalsIgnoreCase("POST")) {
            CurrencyPrice currencyPrice = getCurrencyPriceFromRequestEdit();
            if (currencyPrice == null) {
                System.out.println("id不存在");
                return;
            }
            CurrencyPriceServ currencyPriceServ = CurrencyPriceServ.n();
            int r = 0;
            r = currencyPriceServ.update(currencyPrice);
            if (r > 0) redirect("/boot/currencyPrice/currencyPrices");
            else {
                System.out.println("出错");
            }
        }
    }


    //controller list方法，放在controller里面
    public void currencyPricePartPage() {
    	
    	
    	long startTime = System.currentTimeMillis();
    	
        int pageNo = getIntPara("pageNo", 1);
        String sortBy = getStrPara("sortBy","");
        int sort = getIntPara("sort",0);
        int pageSize = getIntPara("pageSize",100);
        //PageList<CurrencyPrice> currencyPricelist = CurrencyPriceServ.n().findByPage(pageNo, 21);

        CurrencyStatus currencyStatus = CurrencyStatusServ.n().get(1);
        long priceBatchTime = currencyStatus.getPriceLastBatchTime();
        int panelNum = currencyStatus.getPricePanelNum();

        PageList<CurrencyPrice> currencyPricelist = CurrencyPriceServRead.n().find_OrderBy_ByBatchTimeEqPage(priceBatchTime,pageNo,panelNum,sortBy,sort,pageSize);
        String priceBatchTimeFormat = TimeUtil.getTimeFormat(priceBatchTime,TimeUtil.DATE_FORMAT);
        setAttr("priceBatchTimeFormat", priceBatchTimeFormat);
        setAttr("total", panelNum);
        setAttr("sortBy",sortBy);
        setAttr("sort",sort);
        setAttr("currencyPricelist", currencyPricelist);
        System.out.println("list size:" + currencyPricelist.size());
        String actionUrl = "currencyPricePartPage?1=1";
        setPageInfo(currencyPricelist, actionUrl);

        long endTime = System.currentTimeMillis();

        System.out.println("花费时间:"+(endTime-startTime));

        //render("currencyPrices.html");
    }

    //controller list方法，放在controller里面
    public void currencyPricePartPage_microservice() {


        long startTime = System.currentTimeMillis();
        int pageNo = getIntPara("pageNo", 1);
        String sortBy = getStrPara("sortBy","");
        int sort = getIntPara("sort",0);
        int pageSize = getIntPara("pageSize",100);

        CurrencyStatus currencyStatus= CurrencyStatusServ.n().get(1);
        int panelNum =currencyStatus.getPricePanelNum();
        long priceLastBatchTime = currencyStatus.getPriceLastBatchTime();
        String priceLastBatchTimeFormat = TimeUtil.getTimeFormat(priceLastBatchTime,TimeUtil.DATE_FORMAT);

        PageList<CurrencyPrice> currencyPricelist = CurrencyPriceServRead.n().find_OrderBy_ByBatchTimeEqPage(priceLastBatchTime,pageNo, panelNum,sortBy,sort,pageSize);
        setAttr("currencyPricelist", currencyPricelist);
        setAttr("posLastBatchTimeFormat",priceLastBatchTimeFormat);
        setAttr("sortBy",sortBy);
        setAttr("sort",sort);
        System.out.println("list size:" + currencyPricelist.size());
        String actionUrl = "currencyPricePartPage?1=1";
        //不为空的话
        if(!sortBy.equalsIgnoreCase("")) {
            actionUrl = "currencyPricePartPage?1=1&sortBy="+sortBy+"&sort="+sort;
        }
        setPageInfo(currencyPricelist, actionUrl);

        PageArray pageArray = new PageArray();
        pageArray.setBatchTime(priceLastBatchTimeFormat);
        pageArray.setActionUrl(actionUrl);
        pageArray.setDataList(currencyPricelist);
        pageArray.setPageNo(currencyPricelist.getPageNo());
        pageArray.setPageSize(currencyPricelist.getPageSize());
        pageArray.setTotal(currencyPricelist.getTotal());
        pageArray.setPageTotal(currencyPricelist.getPageTotal());
        pageArray.setSort(sort);
        pageArray.setSortBy(sortBy);

        long endTime = System.currentTimeMillis();

        System.out.println("花费时间:"+(endTime-startTime));

        renderJson(pageArray);
        //render("currencyPoss.html");
    }



    //controller list方法，放在controller里面
    public void currencyPrices() {
        int pageNo = getIntPara("pageNo", 1);
        PageList<CurrencyPrice> currencyPricelist = CurrencyPriceServ.n().findByPage(pageNo, 21);
        setAttr("currencyPricelist", currencyPricelist);
        System.out.println("list size:" + currencyPricelist.size());
        String actionUrl = "currencyPrices?1=1";
        setPageInfo(currencyPricelist, actionUrl);
//render("currencyPrices.html");
    }


}