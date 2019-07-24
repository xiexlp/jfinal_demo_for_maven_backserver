package com.js.cluster.nginx.backserver.controller;

import com.js.common.util.ControllerAdaper;
import com.js.common.util.PageList;
import com.js.isearch.orm.CurrencyStatus;
import com.js.isearch.serv.CurrencyStatusServ;
import com.js.cluster.nginx.backserver.controllerex.CurrencyStatusControllerEx;
import java.util.List;
import com.js.common.util.PageList;
import java.sql.Timestamp;


public class CurrencyStatusController extends CurrencyStatusControllerEx {

public void currencyStatusadd(){
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


        public void currencyStatusupdate(){
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
                //render("currencyStatusupdate.html");
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
public void currencyStatuss(){
int pageNo = getIntPara("pageNo",1);
PageList<CurrencyStatus> currencyStatuslist = CurrencyStatusServ.n().findByPage(pageNo,21);
setAttr("currencyStatuslist", currencyStatuslist);
System.out.println("list size:"+currencyStatuslist.size());
String actionUrl = "currencyStatuss?1=1";
setPageInfo(currencyStatuslist, actionUrl);
//render("currencyStatuss.html");
}




}