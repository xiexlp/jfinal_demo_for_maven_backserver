package com.js.cluster.nginx.backserver.controller;

import com.js.common.util.ControllerAdaper;
import com.js.common.util.PageList;
import com.js.isearch.orm.CurrencyPosScrawLog;
import com.js.isearch.serv.CurrencyPosScrawLogServ;
import com.js.cluster.nginx.backserver.controllerex.CurrencyPosScrawLogControllerEx;
import java.util.List;
import com.js.common.util.PageList;
import java.sql.Timestamp;


public class CurrencyPosScrawLogController extends CurrencyPosScrawLogControllerEx {

public void currencyPosScrawLogadd(){
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


        public void currencyPosScrawLogupdate(){
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
                //render("currencyPosScrawLogupdate.html");
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
public void currencyPosScrawLogs(){
int pageNo = getIntPara("pageNo",1);
PageList<CurrencyPosScrawLog> currencyPosScrawLoglist = CurrencyPosScrawLogServ.n().findByPage(pageNo,21);
setAttr("currencyPosScrawLoglist", currencyPosScrawLoglist);
System.out.println("list size:"+currencyPosScrawLoglist.size());
String actionUrl = "currencyPosScrawLogs?1=1";
setPageInfo(currencyPosScrawLoglist, actionUrl);
//render("currencyPosScrawLogs.html");
}




}