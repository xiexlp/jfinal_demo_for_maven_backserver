package com.js.cluster.nginx.backserver.controllerex;

import com.js.common.util.ControllerAdaper;
import com.js.common.util.PageList;
import com.js.isearch.orm.CurrencyPos;
import com.js.isearch.serv.CurrencyPosServ;
import com.js.isearch.servread.CurrencyPosServRead;

import java.util.List;
import java.sql.Timestamp;
import java.sql.Date;

public class CurrencyPosControllerEx extends ControllerAdaper {


public void currencyPosnew(){
String method = getRequest().getMethod();
if(method.equalsIgnoreCase("GET")) {
//List<Group> groups = GroupServ.n().findAll();
    //  setAttr("groups",groups);
    //List<Manufacturer> manus = ManufacturerServ.n().findAll();
        //System.out.println("manus size:"+manus.size());
        //setAttr("manus",manus);
        //render("currencyPosnew.html");
        }else if(method.equalsIgnoreCase("POST")){
        //User user = getUserFromRequest();
        CurrencyPos currencyPos= getCurrencyPosFromRequest();
        //int r = UserServ.n().saveAutoId(user);

                    int r=CurrencyPosServ.n().saveAutoId(currencyPos);
        

        if(r>0){
        redirect("/boot/currencyPos/currencyPoss");
        }else {
        System.out.println("新增失败");
        }
        }
        }


        public void currencyPosPartAdd(){
        String method = getRequest().getMethod();
        if(method.equalsIgnoreCase("GET")) {
        //List<Group> groups = GroupServ.n().findAll();
            //  setAttr("groups",groups);
            //List<Manufacturer> manus = ManufacturerServ.n().findAll();
                //System.out.println("manus size:"+manus.size());
                //setAttr("manus",manus);
                //render("currencyPosnew.html");
                }else if(method.equalsIgnoreCase("POST")){
                //User user = getUserFromRequest();
                CurrencyPos currencyPos= getCurrencyPosFromRequest();
                //int r = UserServ.n().saveAutoId(user);

                                    int r=CurrencyPosServ.n().saveAutoId(currencyPos);
                

                if(r>0){
                redirect("/boot/currencyPos/currencyPoss");
                }else {
                System.out.println("新增失败");
                }
                }
                }


        public void currencyPosedit(){
        String method = getRequest().getMethod();
        if(method.equalsIgnoreCase("GET")) {
        //List<Manufacturer> manus = ManufacturerServ.n().findAll();
            //System.out.println("manus size:"+users.size());
            //List<Group> groups = GroupServ.n().findAll();
                //System.out.println("group size:"+groups.size());
                //int userID= getIntPara("userID", 1);
                                    int currencyPosId = getIntPara("currencyPosId",1);
                    if(currencyPosId==0) {
                    System.out.println("出错");
                    return;
                    }
                                CurrencyPos currencyPos = CurrencyPosServ.n().get(currencyPosId);
                //setAttr("groups",groups);
                setAttr("currencyPos",currencyPos);
                //render("currencyPosedit.html");
                }else if(method.equalsIgnoreCase("POST")){
                CurrencyPos currencyPos = getCurrencyPosFromRequestEdit();
                if(currencyPos==null) {
                System.out.println("id不存在");
                return;
                }
                CurrencyPosServ currencyPosServ = CurrencyPosServ.n();
                int r=0;
                r=currencyPosServ.update(currencyPos);
                if(r>0) redirect("/boot/currencyPos/currencyPoss");
                else {
                System.out.println("出错");
                }
                }
                }



                public void currencyPosPartUpdate(){
                String method = getRequest().getMethod();
                if(method.equalsIgnoreCase("GET")) {
                                                    int currencyPosId = getIntPara("currencyPosId",1);
                            if(currencyPosId==0) {
                            System.out.println("出错");
                            return;
                            }
                                                CurrencyPos currencyPos = CurrencyPosServ.n().get(currencyPosId);
                        setAttr("currencyPos",currencyPos);
                        }else if(method.equalsIgnoreCase("POST")){
                        CurrencyPos currencyPos = getCurrencyPosFromRequestEdit();
                        if(currencyPos==null) {
                        System.out.println("id不存在");
                        return;
                        }
                        CurrencyPosServ currencyPosServ = CurrencyPosServ.n();
                        int r=0;
                        r=currencyPosServ.update(currencyPos);
                        if(r>0) redirect("/boot/currencyPos/currencyPoss");
                        else {
                        System.out.println("出错");
                        }
                        }
                        }


                //controller list方法，放在controller里面
                public void currencyPoslist(){
                int pageNo = getIntPara("pageNo",1);
                PageList<CurrencyPos> currencyPoslist = CurrencyPosServ.n().findByPage(pageNo,21);
                setAttr("currencyPoslist", currencyPoslist);
                System.out.println("list size:" + currencyPoslist.size());
                String actionUrl = "currencyPoslist?1=1";
                setPageInfo(currencyPoslist, actionUrl);
                //render("currencyPoslist.html");
                }


                        //controller list方法，放在controller里面
                        public void currencyPosPartPage() {
                        int pageNo = getIntPara("pageNo", 1);
                        String sortBy = getStrPara("sortBy","");
                        int sort = getIntPara("sort",0);
                        int pageSize = getIntPara("pageSize",100);
                        //PageList<CurrencyPos> currencyPoslist = CurrencyPosServ.n().findByPage(pageNo, 21);

                           // CurrencyStatus currencyStatus = CurrencyStatusServ.n().get(1);
                           // long priceBatchTime = currencyStatus.getPriceLastBatchTime();
                          //  int panelNum = currencyStatus.getPricePanelNum();
                            long total= 201;

                            PageList<CurrencyPos> currencyPoslist = CurrencyPosServRead.n().findByPage(pageNo,(int)total);
                               // String priceBatchTimeFormat = TimeUtil.getTimeFormat(priceBatchTime,TimeUtil.DATE_FORMAT);
                                //setAttr("priceBatchTimeFormat", priceBatchTimeFormat);
                                setAttr("total", total);
                                setAttr("sortBy",sortBy);
                                setAttr("sort",sort);
                                setAttr("currencyPoslist", currencyPoslist);
                                System.out.println("list size:" + currencyPoslist.size());
                                String actionUrl = "currencyPosPartPage?1=1";
                                setPageInfo(currencyPoslist, actionUrl);
                                //render("currencyPrices.html");
                                }



                //放在controller delete方法
                public void currencyPosdel(){
                //int departID = getIntPara("departID",0);

                                    int currencyPosId = getIntPara("currencyPosId",1);
                    if(currencyPosId==0) {
                    System.out.println("出错");
                    return;
                    }
                

                int r = CurrencyPosServ.n().delete(currencyPosId);
                if(r>0) redirect("/boot/currencyPos/currencyPoslist");
                }

                public CurrencyPos getCurrencyPosFromRequest(){
                CurrencyPos currencyPos = new CurrencyPos();
                                                                                                                                                                                                                String currencyName = getStrPara("currencyName","");
                                                currencyPos.setCurrencyName(currencyName);
                                                                                                                                            String symbol = getStrPara("symbol","");
                                                currencyPos.setSymbol(symbol);
                                                                                                                                            String logoUrl = getStrPara("logoUrl","");
                                                currencyPos.setLogoUrl(logoUrl);
                                                                                                                                            double currentPrice = getDoublePara("currentPrice",0);
                                                currencyPos.setCurrentPrice(currentPrice);
                                                                                                                                            double priceChange = getDoublePara("priceChange",0);
                                                currencyPos.setPriceChange(priceChange);
                                                                                                                                            long volume=getLongPara("volume",0);
                                                currencyPos.setVolume(volume);
                                                                                                                                            double marketCap = getDoublePara("marketCap",0);
                                                currencyPos.setMarketCap(marketCap);
                                                                                                                                            double roi = getDoublePara("roi",0);
                                                currencyPos.setRoi(roi);
                                                                                                                                            int nodeNum=getIntPara("nodeNum",0);
                                                currencyPos.setNodeNum(nodeNum);
                                                                                                                                            int requiredNum=getIntPara("requiredNum",0);
                                                currencyPos.setRequiredNum(requiredNum);
                                                                                                                                            double mnWorth = getDoublePara("mnWorth",0);
                                                currencyPos.setMnWorth(mnWorth);
                                                                                                                                            long createTime=getLongPara("createTime",0);
                                                currencyPos.setCreateTime(createTime);
                                                                                                                                            long updateTime=getLongPara("updateTime",0);
                                                currencyPos.setUpdateTime(updateTime);
                                                                                                                                            String infoUrl = getStrPara("infoUrl","");
                                                currencyPos.setInfoUrl(infoUrl);
                                                                                                                                            int currencyId=getIntPara("currencyId",0);
                                                currencyPos.setCurrencyId(currencyId);
                                                                                                                                            long batchTime=getLongPara("batchTime",0);
                                                currencyPos.setBatchTime(batchTime);
                                                                                                                                            String detailLink = getStrPara("detailLink","");
                                                currencyPos.setDetailLink(detailLink);
                                                    return currencyPos;
                }


                public CurrencyPos getCurrencyPosFromRequestEdit(){
                CurrencyPos currencyPos = new CurrencyPos();
                                                                            int currencyPosId=getIntPara("currencyPosId",0);
                                        currencyPos.setCurrencyPosId(currencyPosId);
                                                                            String currencyName = getStrPara("currencyName","");
                                        currencyPos.setCurrencyName(currencyName);
                                                                            String symbol = getStrPara("symbol","");
                                        currencyPos.setSymbol(symbol);
                                                                            String logoUrl = getStrPara("logoUrl","");
                                        currencyPos.setLogoUrl(logoUrl);
                                                                            double currentPrice = getDoublePara("currentPrice",0);
                                        currencyPos.setCurrentPrice(currentPrice);
                                                                            double priceChange = getDoublePara("priceChange",0);
                                        currencyPos.setPriceChange(priceChange);
                                                                            long volume=getLongPara("volume",0);
                                        currencyPos.setVolume(volume);
                                                                            double marketCap = getDoublePara("marketCap",0);
                                        currencyPos.setMarketCap(marketCap);
                                                                            double roi = getDoublePara("roi",0);
                                        currencyPos.setRoi(roi);
                                                                            int nodeNum=getIntPara("nodeNum",0);
                                        currencyPos.setNodeNum(nodeNum);
                                                                            int requiredNum=getIntPara("requiredNum",0);
                                        currencyPos.setRequiredNum(requiredNum);
                                                                            double mnWorth = getDoublePara("mnWorth",0);
                                        currencyPos.setMnWorth(mnWorth);
                                                                            long createTime=getLongPara("createTime",0);
                                        currencyPos.setCreateTime(createTime);
                                                                            long updateTime=getLongPara("updateTime",0);
                                        currencyPos.setUpdateTime(updateTime);
                                                                            String infoUrl = getStrPara("infoUrl","");
                                        currencyPos.setInfoUrl(infoUrl);
                                                                            int currencyId=getIntPara("currencyId",0);
                                        currencyPos.setCurrencyId(currencyId);
                                                                            long batchTime=getLongPara("batchTime",0);
                                        currencyPos.setBatchTime(batchTime);
                                                                            String detailLink = getStrPara("detailLink","");
                                        currencyPos.setDetailLink(detailLink);
                                return currencyPos;
                }

                }

