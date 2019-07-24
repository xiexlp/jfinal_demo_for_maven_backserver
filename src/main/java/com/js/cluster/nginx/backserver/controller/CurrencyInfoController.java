package com.js.cluster.nginx.backserver.controller;

import com.js.common.util.ControllerAdaper;
import com.js.common.util.PageList;
import com.js.isearch.orm.CurrencyInfo;
import com.js.isearch.serv.CurrencyInfoServ;
import com.js.cluster.nginx.backserver.controllerex.CurrencyInfoControllerEx;
import java.util.List;
import com.js.common.util.PageList;
import java.sql.Timestamp;


public class CurrencyInfoController extends CurrencyInfoControllerEx {

public void currencyInfoadd(){
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


        public void currencyInfoupdate(){
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
                //render("currencyInfoupdate.html");
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
public void currencyInfos(){
int pageNo = getIntPara("pageNo",1);
PageList<CurrencyInfo> currencyInfolist = CurrencyInfoServ.n().findByPage(pageNo,21);
setAttr("currencyInfolist", currencyInfolist);
System.out.println("list size:"+currencyInfolist.size());
String actionUrl = "currencyInfos?1=1";
setPageInfo(currencyInfolist, actionUrl);
//render("currencyInfos.html");
}




}