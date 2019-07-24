package com.js.cluster.nginx.backserver.controllerex;

import com.js.common.util.ControllerAdaper;
import com.js.common.util.PageList;
import com.js.isearch.orm.CurrencyInfo;
import com.js.isearch.serv.CurrencyInfoServ;
import com.js.isearch.servread.CurrencyInfoServRead;

import java.util.List;
import java.sql.Timestamp;
import java.sql.Date;

public class CurrencyInfoControllerEx extends ControllerAdaper {


public void currencyInfonew(){
String method = getRequest().getMethod();
if(method.equalsIgnoreCase("GET")) {
//List<Group> groups = GroupServ.n().findAll();
    //  setAttr("groups",groups);
    //List<Manufacturer> manus = ManufacturerServ.n().findAll();
        //System.out.println("manus size:"+manus.size());
        //setAttr("manus",manus);
        //render("currencyInfonew.html");
        }else if(method.equalsIgnoreCase("POST")){
        //User user = getUserFromRequest();
        CurrencyInfo currencyInfo= getCurrencyInfoFromRequest();
        //int r = UserServ.n().saveAutoId(user);

                    int r=CurrencyInfoServ.n().saveAutoId(currencyInfo);
        

        if(r>0){
        redirect("/boot/currencyInfo/currencyInfos");
        }else {
        System.out.println("新增失败");
        }
        }
        }


        public void currencyInfoPartAdd(){
        String method = getRequest().getMethod();
        if(method.equalsIgnoreCase("GET")) {
        //List<Group> groups = GroupServ.n().findAll();
            //  setAttr("groups",groups);
            //List<Manufacturer> manus = ManufacturerServ.n().findAll();
                //System.out.println("manus size:"+manus.size());
                //setAttr("manus",manus);
                //render("currencyInfonew.html");
                }else if(method.equalsIgnoreCase("POST")){
                //User user = getUserFromRequest();
                CurrencyInfo currencyInfo= getCurrencyInfoFromRequest();
                //int r = UserServ.n().saveAutoId(user);

                                    int r=CurrencyInfoServ.n().saveAutoId(currencyInfo);
                

                if(r>0){
                redirect("/boot/currencyInfo/currencyInfos");
                }else {
                System.out.println("新增失败");
                }
                }
                }


        public void currencyInfoedit(){
        String method = getRequest().getMethod();
        if(method.equalsIgnoreCase("GET")) {
        //List<Manufacturer> manus = ManufacturerServ.n().findAll();
            //System.out.println("manus size:"+users.size());
            //List<Group> groups = GroupServ.n().findAll();
                //System.out.println("group size:"+groups.size());
                //int userID= getIntPara("userID", 1);
                                    int currencyId = getIntPara("currencyId",1);
                    if(currencyId==0) {
                    System.out.println("出错");
                    return;
                    }
                                CurrencyInfo currencyInfo = CurrencyInfoServ.n().get(currencyId);
                //setAttr("groups",groups);
                setAttr("currencyInfo",currencyInfo);
                //render("currencyInfoedit.html");
                }else if(method.equalsIgnoreCase("POST")){
                CurrencyInfo currencyInfo = getCurrencyInfoFromRequestEdit();
                if(currencyInfo==null) {
                System.out.println("id不存在");
                return;
                }
                CurrencyInfoServ currencyInfoServ = CurrencyInfoServ.n();
                int r=0;
                r=currencyInfoServ.update(currencyInfo);
                if(r>0) redirect("/boot/currencyInfo/currencyInfos");
                else {
                System.out.println("出错");
                }
                }
                }



                public void currencyInfoPartUpdate(){
                String method = getRequest().getMethod();
                if(method.equalsIgnoreCase("GET")) {
                                                    int currencyId = getIntPara("currencyId",1);
                            if(currencyId==0) {
                            System.out.println("出错");
                            return;
                            }
                                                CurrencyInfo currencyInfo = CurrencyInfoServ.n().get(currencyId);
                        setAttr("currencyInfo",currencyInfo);
                        }else if(method.equalsIgnoreCase("POST")){
                        CurrencyInfo currencyInfo = getCurrencyInfoFromRequestEdit();
                        if(currencyInfo==null) {
                        System.out.println("id不存在");
                        return;
                        }
                        CurrencyInfoServ currencyInfoServ = CurrencyInfoServ.n();
                        int r=0;
                        r=currencyInfoServ.update(currencyInfo);
                        if(r>0) redirect("/boot/currencyInfo/currencyInfos");
                        else {
                        System.out.println("出错");
                        }
                        }
                        }


                //controller list方法，放在controller里面
                public void currencyInfolist(){
                int pageNo = getIntPara("pageNo",1);
                PageList<CurrencyInfo> currencyInfolist = CurrencyInfoServ.n().findByPage(pageNo,21);
                setAttr("currencyInfolist", currencyInfolist);
                System.out.println("list size:" + currencyInfolist.size());
                String actionUrl = "currencyInfolist?1=1";
                setPageInfo(currencyInfolist, actionUrl);
                //render("currencyInfolist.html");
                }


                        //controller list方法，放在controller里面
                        public void currencyInfoPartPage() {
                        int pageNo = getIntPara("pageNo", 1);
                        String sortBy = getStrPara("sortBy","");
                        int sort = getIntPara("sort",0);
                        int pageSize = getIntPara("pageSize",100);
                        //PageList<CurrencyInfo> currencyInfolist = CurrencyInfoServ.n().findByPage(pageNo, 21);

                           // CurrencyStatus currencyStatus = CurrencyStatusServ.n().get(1);
                           // long priceBatchTime = currencyStatus.getPriceLastBatchTime();
                          //  int panelNum = currencyStatus.getPricePanelNum();
                            long total= 201;

                            PageList<CurrencyInfo> currencyInfolist = CurrencyInfoServRead.n().findByPage(pageNo,(int)total);
                               // String priceBatchTimeFormat = TimeUtil.getTimeFormat(priceBatchTime,TimeUtil.DATE_FORMAT);
                                //setAttr("priceBatchTimeFormat", priceBatchTimeFormat);
                                setAttr("total", total);
                                setAttr("sortBy",sortBy);
                                setAttr("sort",sort);
                                setAttr("currencyInfolist", currencyInfolist);
                                System.out.println("list size:" + currencyInfolist.size());
                                String actionUrl = "currencyInfoPartPage?1=1";
                                setPageInfo(currencyInfolist, actionUrl);
                                //render("currencyPrices.html");
                                }



                //放在controller delete方法
                public void currencyInfodel(){
                //int departID = getIntPara("departID",0);

                                    int currencyId = getIntPara("currencyId",1);
                    if(currencyId==0) {
                    System.out.println("出错");
                    return;
                    }
                

                int r = CurrencyInfoServ.n().delete(currencyId);
                if(r>0) redirect("/boot/currencyInfo/currencyInfolist");
                }

                public CurrencyInfo getCurrencyInfoFromRequest(){
                CurrencyInfo currencyInfo = new CurrencyInfo();
                                                                                                                                                                                                                String name = getStrPara("name","");
                                                currencyInfo.setName(name);
                                                                                                                                            String symbol = getStrPara("symbol","");
                                                currencyInfo.setSymbol(symbol);
                                                                                                                                            long volume=getLongPara("volume",0);
                                                currencyInfo.setVolume(volume);
                                                                                                                                            long circulatingVolume=getLongPara("circulatingVolume",0);
                                                currencyInfo.setCirculatingVolume(circulatingVolume);
                                                                                                                                            double initPrice = getDoublePara("initPrice",0);
                                                currencyInfo.setInitPrice(initPrice);
                                                                                                                                            long initDate=getLongPara("initDate",0);
                                                currencyInfo.setInitDate(initDate);
                                                                                                                                            String url = getStrPara("url","");
                                                currencyInfo.setUrl(url);
                                                                                                                                            String currencyDesc = getStrPara("currencyDesc","");
                                                currencyInfo.setCurrencyDesc(currencyDesc);
                                                                                                                                            int srcWebId=getIntPara("srcWebId",0);
                                                currencyInfo.setSrcWebId(srcWebId);
                                                                                                                                            String currencyIdName = getStrPara("currencyIdName","");
                                                currencyInfo.setCurrencyIdName(currencyIdName);
                                                                                                                                            String detailLink = getStrPara("detailLink","");
                                                currencyInfo.setDetailLink(detailLink);
                                                                                                                                            String masterLink = getStrPara("masterLink","");
                                                currencyInfo.setMasterLink(masterLink);
                                                    return currencyInfo;
                }


                public CurrencyInfo getCurrencyInfoFromRequestEdit(){
                CurrencyInfo currencyInfo = new CurrencyInfo();
                                                                            int currencyId=getIntPara("currencyId",0);
                                        currencyInfo.setCurrencyId(currencyId);
                                                                            String name = getStrPara("name","");
                                        currencyInfo.setName(name);
                                                                            String symbol = getStrPara("symbol","");
                                        currencyInfo.setSymbol(symbol);
                                                                            long volume=getLongPara("volume",0);
                                        currencyInfo.setVolume(volume);
                                                                            long circulatingVolume=getLongPara("circulatingVolume",0);
                                        currencyInfo.setCirculatingVolume(circulatingVolume);
                                                                            double initPrice = getDoublePara("initPrice",0);
                                        currencyInfo.setInitPrice(initPrice);
                                                                            long initDate=getLongPara("initDate",0);
                                        currencyInfo.setInitDate(initDate);
                                                                            String url = getStrPara("url","");
                                        currencyInfo.setUrl(url);
                                                                            String currencyDesc = getStrPara("currencyDesc","");
                                        currencyInfo.setCurrencyDesc(currencyDesc);
                                                                            int srcWebId=getIntPara("srcWebId",0);
                                        currencyInfo.setSrcWebId(srcWebId);
                                                                            String currencyIdName = getStrPara("currencyIdName","");
                                        currencyInfo.setCurrencyIdName(currencyIdName);
                                                                            String detailLink = getStrPara("detailLink","");
                                        currencyInfo.setDetailLink(detailLink);
                                                                            String masterLink = getStrPara("masterLink","");
                                        currencyInfo.setMasterLink(masterLink);
                                return currencyInfo;
                }

                }

