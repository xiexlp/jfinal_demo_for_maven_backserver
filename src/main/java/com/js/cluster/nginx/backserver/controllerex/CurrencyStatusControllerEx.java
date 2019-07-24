package com.js.cluster.nginx.backserver.controllerex;

import com.js.common.util.ControllerAdaper;
import com.js.common.util.PageList;
import com.js.isearch.orm.CurrencyStatus;
import com.js.isearch.serv.CurrencyStatusServ;
import java.util.List;
import java.sql.Timestamp;
import java.sql.Date;

public class CurrencyStatusControllerEx extends ControllerAdaper {


public void currencyStatusnew(){
String method = getRequest().getMethod();
if(method.equalsIgnoreCase("GET")) {
//List<Group> groups = GroupServ.n().findAll();
    //  setAttr("groups",groups);
    //List<Manufacturer> manus = ManufacturerServ.n().findAll();
        //System.out.println("manus size:"+manus.size());
        //setAttr("manus",manus);
        //render("currencyStatusnew.html");
        }else if(method.equalsIgnoreCase("POST")){
        //User user = getUserFromRequest();
        CurrencyStatus currencyStatus= getCurrencyStatusFromRequest();
        //int r = UserServ.n().saveAutoId(user);

                    int r=CurrencyStatusServ.n().saveAutoId(currencyStatus);
        

        if(r>0){
        redirect("/boot/currencyStatus/currencyStatuss");
        }else {
        System.out.println("新增失败");
        }
        }
        }


        public void currencyStatusPartAdd(){
        String method = getRequest().getMethod();
        if(method.equalsIgnoreCase("GET")) {
        //List<Group> groups = GroupServ.n().findAll();
            //  setAttr("groups",groups);
            //List<Manufacturer> manus = ManufacturerServ.n().findAll();
                //System.out.println("manus size:"+manus.size());
                //setAttr("manus",manus);
                //render("currencyStatusnew.html");
                }else if(method.equalsIgnoreCase("POST")){
                //User user = getUserFromRequest();
                CurrencyStatus currencyStatus= getCurrencyStatusFromRequest();
                //int r = UserServ.n().saveAutoId(user);

                                    int r=CurrencyStatusServ.n().saveAutoId(currencyStatus);
                

                if(r>0){
                redirect("/boot/currencyStatus/currencyStatuss");
                }else {
                System.out.println("新增失败");
                }
                }
                }


        public void currencyStatusedit(){
        String method = getRequest().getMethod();
        if(method.equalsIgnoreCase("GET")) {
        //List<Manufacturer> manus = ManufacturerServ.n().findAll();
            //System.out.println("manus size:"+users.size());
            //List<Group> groups = GroupServ.n().findAll();
                //System.out.println("group size:"+groups.size());
                //int userID= getIntPara("userID", 1);
                                    int currencyStatusId = getIntPara("currencyStatusId",1);
                    if(currencyStatusId==0) {
                    System.out.println("出错");
                    return;
                    }
                                CurrencyStatus currencyStatus = CurrencyStatusServ.n().get(currencyStatusId);
                //setAttr("groups",groups);
                setAttr("currencyStatus",currencyStatus);
                //render("currencyStatusedit.html");
                }else if(method.equalsIgnoreCase("POST")){
                CurrencyStatus currencyStatus = getCurrencyStatusFromRequestEdit();
                if(currencyStatus==null) {
                System.out.println("id不存在");
                return;
                }
                CurrencyStatusServ currencyStatusServ = CurrencyStatusServ.n();
                int r=0;
                r=currencyStatusServ.update(currencyStatus);
                if(r>0) redirect("/boot/currencyStatus/currencyStatuss");
                else {
                System.out.println("出错");
                }
                }
                }



                public void currencyStatusPartUpdate(){
                String method = getRequest().getMethod();
                if(method.equalsIgnoreCase("GET")) {
                                                    int currencyStatusId = getIntPara("currencyStatusId",1);
                            if(currencyStatusId==0) {
                            System.out.println("出错");
                            return;
                            }
                                                CurrencyStatus currencyStatus = CurrencyStatusServ.n().get(currencyStatusId);
                        setAttr("currencyStatus",currencyStatus);
                        }else if(method.equalsIgnoreCase("POST")){
                        CurrencyStatus currencyStatus = getCurrencyStatusFromRequestEdit();
                        if(currencyStatus==null) {
                        System.out.println("id不存在");
                        return;
                        }
                        CurrencyStatusServ currencyStatusServ = CurrencyStatusServ.n();
                        int r=0;
                        r=currencyStatusServ.update(currencyStatus);
                        if(r>0) redirect("/boot/currencyStatus/currencyStatuss");
                        else {
                        System.out.println("出错");
                        }
                        }
                        }


                //controller list方法，放在controller里面
                public void currencyStatuslist(){
                int pageNo = getIntPara("pageNo",1);
                PageList<CurrencyStatus> currencyStatuslist = CurrencyStatusServ.n().findByPage(pageNo,21);
                setAttr("currencyStatuslist", currencyStatuslist);
                System.out.println("list size:" + currencyStatuslist.size());
                String actionUrl = "currencyStatuslist?1=1";
                setPageInfo(currencyStatuslist, actionUrl);
                //render("currencyStatuslist.html");
                }


                //controller list方法，放在controller里面
                public void currencyStatusPartPage(){
                int pageNo = getIntPara("pageNo",1);
                PageList<CurrencyStatus> currencyStatuslist = CurrencyStatusServ.n().findByPage(pageNo,21);
                setAttr("currencyStatuslist", currencyStatuslist);
                System.out.println("list size:"+currencyStatuslist.size());
                String actionUrl = "currencyStatusPartPage?1=1";
                setPageInfo(currencyStatuslist, actionUrl);
                //render("currencyStatuss.html");
                }

                //放在controller delete方法
                public void currencyStatusdel(){
                //int departID = getIntPara("departID",0);

                                    int currencyStatusId = getIntPara("currencyStatusId",1);
                    if(currencyStatusId==0) {
                    System.out.println("出错");
                    return;
                    }
                

                int r = CurrencyStatusServ.n().delete(currencyStatusId);
                if(r>0) redirect("/boot/currencyStatus/currencyStatuslist");
                }

                public CurrencyStatus getCurrencyStatusFromRequest(){
                CurrencyStatus currencyStatus = new CurrencyStatus();
                                                                                                                                                                                                                int posPanelNum=getIntPara("posPanelNum",0);
                                                currencyStatus.setPosPanelNum(posPanelNum);
                                                                                                                                            int pricePanelNum=getIntPara("pricePanelNum",0);
                                                currencyStatus.setPricePanelNum(pricePanelNum);
                                                                                                                                            long posLastBatchTime=getLongPara("posLastBatchTime",0);
                                                currencyStatus.setPosLastBatchTime(posLastBatchTime);
                                                                                                                                            long priceLastBatchTime=getLongPara("priceLastBatchTime",0);
                                                currencyStatus.setPriceLastBatchTime(priceLastBatchTime);
                                                                                                                                            long createTime=getLongPara("createTime",0);
                                                currencyStatus.setCreateTime(createTime);
                                                                                                                                            long updateTime=getLongPara("updateTime",0);
                                                currencyStatus.setUpdateTime(updateTime);
                                                    return currencyStatus;
                }


                public CurrencyStatus getCurrencyStatusFromRequestEdit(){
                CurrencyStatus currencyStatus = new CurrencyStatus();
                                                                            int currencyStatusId=getIntPara("currencyStatusId",0);
                                        currencyStatus.setCurrencyStatusId(currencyStatusId);
                                                                            int posPanelNum=getIntPara("posPanelNum",0);
                                        currencyStatus.setPosPanelNum(posPanelNum);
                                                                            int pricePanelNum=getIntPara("pricePanelNum",0);
                                        currencyStatus.setPricePanelNum(pricePanelNum);
                                                                            long posLastBatchTime=getLongPara("posLastBatchTime",0);
                                        currencyStatus.setPosLastBatchTime(posLastBatchTime);
                                                                            long priceLastBatchTime=getLongPara("priceLastBatchTime",0);
                                        currencyStatus.setPriceLastBatchTime(priceLastBatchTime);
                                                                            long createTime=getLongPara("createTime",0);
                                        currencyStatus.setCreateTime(createTime);
                                                                            long updateTime=getLongPara("updateTime",0);
                                        currencyStatus.setUpdateTime(updateTime);
                                return currencyStatus;
                }

                }

