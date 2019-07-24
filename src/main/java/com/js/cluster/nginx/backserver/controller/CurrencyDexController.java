package com.js.cluster.nginx.backserver.controller;

import com.js.common.util.ControllerAdaper;
import com.js.common.util.PageList;
import com.js.isearch.orm.CurrencyDex;
import com.js.isearch.serv.CurrencyDexServ;
import com.js.cluster.nginx.backserver.controllerex.CurrencyDexControllerEx;
import java.util.List;
import com.js.common.util.PageList;
import java.sql.Timestamp;


public class CurrencyDexController extends CurrencyDexControllerEx {

public void currencyDexadd(){
String method = getRequest().getMethod();
if(method.equalsIgnoreCase("GET")) {
//List<Group> groups = GroupServ.n().findAll();
    //  setAttr("groups",groups);
    //List<Manufacturer> manus = ManufacturerServ.n().findAll();
        //System.out.println("manus size:"+manus.size());
        //setAttr("manus",manus);
        //render("currencyDexnew.html");
        }else if(method.equalsIgnoreCase("POST")){
        //User user = getUserFromRequest();
        CurrencyDex currencyDex= getCurrencyDexFromRequest();
        //int r = UserServ.n().saveAutoId(user);

                    int r=CurrencyDexServ.n().saveAutoId(currencyDex);
        

        if(r>0){
        redirect("/boot/currencyDex/currencyDexs");
        }else {
        System.out.println("新增失败");
        }
        }
        }


        public void currencyDexupdate(){
        String method = getRequest().getMethod();
        if(method.equalsIgnoreCase("GET")) {
        //List<Manufacturer> manus = ManufacturerServ.n().findAll();
            //System.out.println("manus size:"+users.size());
            //List<Group> groups = GroupServ.n().findAll();
                //System.out.println("group size:"+groups.size());
                //int userID= getIntPara("userID", 1);

                                    int dexId = getIntPara("dexId",1);
                    if(dexId==0) {
                        System.out.println("出错");
                        return;
                    }
                                CurrencyDex currencyDex = CurrencyDexServ.n().get(dexId);
                //setAttr("groups",groups);
                setAttr("currencyDex",currencyDex);
                //render("currencyDexupdate.html");
                }else if(method.equalsIgnoreCase("POST")){
                CurrencyDex currencyDex = getCurrencyDexFromRequestEdit();
                if(currencyDex==null) {
                System.out.println("id不存在");
                return;
                }
                CurrencyDexServ currencyDexServ = CurrencyDexServ.n();
                int r=0;
                r=currencyDexServ.update(currencyDex);
                if(r>0) redirect("/boot/currencyDex/currencyDexs");
                else {
                System.out.println("出错");
                }
                }
                }


//controller list方法，放在controller里面
public void currencyDexs(){
int pageNo = getIntPara("pageNo",1);
PageList<CurrencyDex> currencyDexlist = CurrencyDexServ.n().findByPage(pageNo,21);
setAttr("currencyDexlist", currencyDexlist);
System.out.println("list size:"+currencyDexlist.size());
String actionUrl = "currencyDexs?1=1";
setPageInfo(currencyDexlist, actionUrl);
//render("currencyDexs.html");
}




}