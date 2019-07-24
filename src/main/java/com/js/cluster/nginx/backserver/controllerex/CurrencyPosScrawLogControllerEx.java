package com.js.cluster.nginx.backserver.controllerex;

import com.js.common.util.ControllerAdaper;
import com.js.common.util.PageList;
import com.js.isearch.orm.CurrencyPosScrawLog;
import com.js.isearch.serv.CurrencyPosScrawLogServ;
import java.util.List;
import java.sql.Timestamp;
import java.sql.Date;

public class CurrencyPosScrawLogControllerEx extends ControllerAdaper {


public void currencyPosScrawLognew(){
String method = getRequest().getMethod();
if(method.equalsIgnoreCase("GET")) {
//List<Group> groups = GroupServ.n().findAll();
    //  setAttr("groups",groups);
    //List<Manufacturer> manus = ManufacturerServ.n().findAll();
        //System.out.println("manus size:"+manus.size());
        //setAttr("manus",manus);
        //render("currencyPosScrawLognew.html");
        }else if(method.equalsIgnoreCase("POST")){
        //User user = getUserFromRequest();
        CurrencyPosScrawLog currencyPosScrawLog= getCurrencyPosScrawLogFromRequest();
        //int r = UserServ.n().saveAutoId(user);

                    int r=CurrencyPosScrawLogServ.n().saveAutoId(currencyPosScrawLog);
        

        if(r>0){
        redirect("/boot/currencyPosScrawLog/currencyPosScrawLogs");
        }else {
        System.out.println("新增失败");
        }
        }
        }


        public void currencyPosScrawLogPartAdd(){
        String method = getRequest().getMethod();
        if(method.equalsIgnoreCase("GET")) {
        //List<Group> groups = GroupServ.n().findAll();
            //  setAttr("groups",groups);
            //List<Manufacturer> manus = ManufacturerServ.n().findAll();
                //System.out.println("manus size:"+manus.size());
                //setAttr("manus",manus);
                //render("currencyPosScrawLognew.html");
                }else if(method.equalsIgnoreCase("POST")){
                //User user = getUserFromRequest();
                CurrencyPosScrawLog currencyPosScrawLog= getCurrencyPosScrawLogFromRequest();
                //int r = UserServ.n().saveAutoId(user);

                                    int r=CurrencyPosScrawLogServ.n().saveAutoId(currencyPosScrawLog);
                

                if(r>0){
                redirect("/boot/currencyPosScrawLog/currencyPosScrawLogs");
                }else {
                System.out.println("新增失败");
                }
                }
                }


        public void currencyPosScrawLogedit(){
        String method = getRequest().getMethod();
        if(method.equalsIgnoreCase("GET")) {
        //List<Manufacturer> manus = ManufacturerServ.n().findAll();
            //System.out.println("manus size:"+users.size());
            //List<Group> groups = GroupServ.n().findAll();
                //System.out.println("group size:"+groups.size());
                //int userID= getIntPara("userID", 1);
                                    int currencyPosScrawLogId = getIntPara("currencyPosScrawLogId",1);
                    if(currencyPosScrawLogId==0) {
                    System.out.println("出错");
                    return;
                    }
                                CurrencyPosScrawLog currencyPosScrawLog = CurrencyPosScrawLogServ.n().get(currencyPosScrawLogId);
                //setAttr("groups",groups);
                setAttr("currencyPosScrawLog",currencyPosScrawLog);
                //render("currencyPosScrawLogedit.html");
                }else if(method.equalsIgnoreCase("POST")){
                CurrencyPosScrawLog currencyPosScrawLog = getCurrencyPosScrawLogFromRequestEdit();
                if(currencyPosScrawLog==null) {
                System.out.println("id不存在");
                return;
                }
                CurrencyPosScrawLogServ currencyPosScrawLogServ = CurrencyPosScrawLogServ.n();
                int r=0;
                r=currencyPosScrawLogServ.update(currencyPosScrawLog);
                if(r>0) redirect("/boot/currencyPosScrawLog/currencyPosScrawLogs");
                else {
                System.out.println("出错");
                }
                }
                }



                public void currencyPosScrawLogPartUpdate(){
                String method = getRequest().getMethod();
                if(method.equalsIgnoreCase("GET")) {
                                                    int currencyPosScrawLogId = getIntPara("currencyPosScrawLogId",1);
                            if(currencyPosScrawLogId==0) {
                            System.out.println("出错");
                            return;
                            }
                                                CurrencyPosScrawLog currencyPosScrawLog = CurrencyPosScrawLogServ.n().get(currencyPosScrawLogId);
                        setAttr("currencyPosScrawLog",currencyPosScrawLog);
                        }else if(method.equalsIgnoreCase("POST")){
                        CurrencyPosScrawLog currencyPosScrawLog = getCurrencyPosScrawLogFromRequestEdit();
                        if(currencyPosScrawLog==null) {
                        System.out.println("id不存在");
                        return;
                        }
                        CurrencyPosScrawLogServ currencyPosScrawLogServ = CurrencyPosScrawLogServ.n();
                        int r=0;
                        r=currencyPosScrawLogServ.update(currencyPosScrawLog);
                        if(r>0) redirect("/boot/currencyPosScrawLog/currencyPosScrawLogs");
                        else {
                        System.out.println("出错");
                        }
                        }
                        }


                //controller list方法，放在controller里面
                public void currencyPosScrawLoglist(){
                int pageNo = getIntPara("pageNo",1);
                PageList<CurrencyPosScrawLog> currencyPosScrawLoglist = CurrencyPosScrawLogServ.n().findByPage(pageNo,21);
                setAttr("currencyPosScrawLoglist", currencyPosScrawLoglist);
                System.out.println("list size:" + currencyPosScrawLoglist.size());
                String actionUrl = "currencyPosScrawLoglist?1=1";
                setPageInfo(currencyPosScrawLoglist, actionUrl);
                //render("currencyPosScrawLoglist.html");
                }


                //controller list方法，放在controller里面
                public void currencyPosScrawLogPartPage(){
                int pageNo = getIntPara("pageNo",1);
                PageList<CurrencyPosScrawLog> currencyPosScrawLoglist = CurrencyPosScrawLogServ.n().findByPage(pageNo,21);
                setAttr("currencyPosScrawLoglist", currencyPosScrawLoglist);
                System.out.println("list size:"+currencyPosScrawLoglist.size());
                String actionUrl = "currencyPosScrawLogPartPage?1=1";
                setPageInfo(currencyPosScrawLoglist, actionUrl);
                //render("currencyPosScrawLogs.html");
                }

                //放在controller delete方法
                public void currencyPosScrawLogdel(){
                //int departID = getIntPara("departID",0);

                                    int currencyPosScrawLogId = getIntPara("currencyPosScrawLogId",1);
                    if(currencyPosScrawLogId==0) {
                    System.out.println("出错");
                    return;
                    }
                

                int r = CurrencyPosScrawLogServ.n().delete(currencyPosScrawLogId);
                if(r>0) redirect("/boot/currencyPosScrawLog/currencyPosScrawLoglist");
                }

                public CurrencyPosScrawLog getCurrencyPosScrawLogFromRequest(){
                CurrencyPosScrawLog currencyPosScrawLog = new CurrencyPosScrawLog();
                                                                                                                                                                                                                long posBatchTime=getLongPara("posBatchTime",0);
                                                currencyPosScrawLog.setPosBatchTime(posBatchTime);
                                                                                                                                            int posBatchNum=getIntPara("posBatchNum",0);
                                                currencyPosScrawLog.setPosBatchNum(posBatchNum);
                                                    return currencyPosScrawLog;
                }


                public CurrencyPosScrawLog getCurrencyPosScrawLogFromRequestEdit(){
                CurrencyPosScrawLog currencyPosScrawLog = new CurrencyPosScrawLog();
                                                                            int currencyPosScrawLogId=getIntPara("currencyPosScrawLogId",0);
                                        currencyPosScrawLog.setCurrencyPosScrawLogId(currencyPosScrawLogId);
                                                                            long posBatchTime=getLongPara("posBatchTime",0);
                                        currencyPosScrawLog.setPosBatchTime(posBatchTime);
                                                                            int posBatchNum=getIntPara("posBatchNum",0);
                                        currencyPosScrawLog.setPosBatchNum(posBatchNum);
                                return currencyPosScrawLog;
                }

                }

