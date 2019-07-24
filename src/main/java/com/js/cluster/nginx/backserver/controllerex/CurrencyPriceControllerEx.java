package com.js.cluster.nginx.backserver.controllerex;

import com.js.common.util.ControllerAdaper;
import com.js.common.util.PageList;
import com.js.isearch.orm.CurrencyPrice;
import com.js.isearch.serv.CurrencyPriceServ;

import java.util.List;
import java.sql.Timestamp;
import java.sql.Date;

public class CurrencyPriceControllerEx extends ControllerAdaper {


    public void currencyPricenew() {
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


    public void currencyPricePartAdd() {
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


    public void currencyPriceedit() {
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
            //render("currencyPriceedit.html");
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


    public void currencyPricePartUpdate() {
        String method = getRequest().getMethod();
        if (method.equalsIgnoreCase("GET")) {
            int currencyPriceId = getIntPara("currencyPriceId", 1);
            if (currencyPriceId == 0) {
                System.out.println("出错");
                return;
            }
            CurrencyPrice currencyPrice = CurrencyPriceServ.n().get(currencyPriceId);
            setAttr("currencyPrice", currencyPrice);
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
    public void currencyPricelist() {
        int pageNo = getIntPara("pageNo", 1);
        PageList<CurrencyPrice> currencyPricelist = CurrencyPriceServ.n().findByPage(pageNo, 21);
        setAttr("currencyPricelist", currencyPricelist);
        System.out.println("list size:" + currencyPricelist.size());
        String actionUrl = "currencyPricelist?1=1";
        setPageInfo(currencyPricelist, actionUrl);
        //render("currencyPricelist.html");
    }


    //controller list方法，放在controller里面
    public void currencyPricePartPage() {
        int pageNo = getIntPara("pageNo", 1);
        PageList<CurrencyPrice> currencyPricelist = CurrencyPriceServ.n().findByPage(pageNo, 21);
        setAttr("currencyPricelist", currencyPricelist);
        System.out.println("list size:" + currencyPricelist.size());
        String actionUrl = "currencyPricePartPage?1=1";
        setPageInfo(currencyPricelist, actionUrl);
        //render("currencyPrices.html");
    }

    //放在controller delete方法
    public void currencyPricedel() {
        //int departID = getIntPara("departID",0);

        int currencyPriceId = getIntPara("currencyPriceId", 1);
        if (currencyPriceId == 0) {
            System.out.println("出错");
            return;
        }


        int r = CurrencyPriceServ.n().delete(currencyPriceId);
        if (r > 0) redirect("/boot/currencyPrice/currencyPricelist");
    }

    public CurrencyPrice getCurrencyPriceFromRequest() {
        CurrencyPrice currencyPrice = new CurrencyPrice();
        int currencyId = getIntPara("currencyId", 0);
        currencyPrice.setCurrencyId(currencyId);
        String name = getStrPara("name", "");
        currencyPrice.setName(name);
        String symbol = getStrPara("symbol", "");
        currencyPrice.setSymbol(symbol);
        double currentPrice = getDoublePara("currentPrice", 0);
        currencyPrice.setCurrentPrice(currentPrice);
        double priceChange = getDoublePara("priceChange", 0);
        currencyPrice.setPriceChange(priceChange);
        int dexId = getIntPara("dexId", 0);
        currencyPrice.setDexId(dexId);
        String dexName = getStrPara("dexName", "");
        currencyPrice.setDexName(dexName);
        long createTime = getLongPara("createTime", 0);
        currencyPrice.setCreateTime(createTime);
        long updateTime = getLongPara("updateTime", 0);
        currencyPrice.setUpdateTime(updateTime);
        long volume = getLongPara("volume", 0);
        currencyPrice.setVolume(volume);
        long circulatingVolume = getLongPara("circulatingVolume", 0);
        currencyPrice.setCirculatingVolume(circulatingVolume);
        double marketCap = getDoublePara("marketCap", 0);
        currencyPrice.setMarketCap(marketCap);
        int rankMarketCap = getIntPara("rankMarketCap", 0);
        currencyPrice.setRankMarketCap(rankMarketCap);
        long batchTime = getLongPara("batchTime", 0);
        currencyPrice.setBatchTime(batchTime);
        String infoUrl = getStrPara("infoUrl", "");
        currencyPrice.setInfoUrl(infoUrl);
        return currencyPrice;
    }


    public CurrencyPrice getCurrencyPriceFromRequestEdit() {
        CurrencyPrice currencyPrice = new CurrencyPrice();
        int currencyPriceId = getIntPara("currencyPriceId", 0);
        currencyPrice.setCurrencyPriceId(currencyPriceId);
        int currencyId = getIntPara("currencyId", 0);
        currencyPrice.setCurrencyId(currencyId);
        String name = getStrPara("name", "");
        currencyPrice.setName(name);
        String symbol = getStrPara("symbol", "");
        currencyPrice.setSymbol(symbol);
        double currentPrice = getDoublePara("currentPrice", 0);
        currencyPrice.setCurrentPrice(currentPrice);
        double priceChange = getDoublePara("priceChange", 0);
        currencyPrice.setPriceChange(priceChange);
        int dexId = getIntPara("dexId", 0);
        currencyPrice.setDexId(dexId);
        String dexName = getStrPara("dexName", "");
        currencyPrice.setDexName(dexName);
        long createTime = getLongPara("createTime", 0);
        currencyPrice.setCreateTime(createTime);
        long updateTime = getLongPara("updateTime", 0);
        currencyPrice.setUpdateTime(updateTime);
        long volume = getLongPara("volume", 0);
        currencyPrice.setVolume(volume);
        long circulatingVolume = getLongPara("circulatingVolume", 0);
        currencyPrice.setCirculatingVolume(circulatingVolume);
        double marketCap = getDoublePara("marketCap", 0);
        currencyPrice.setMarketCap(marketCap);
        int rankMarketCap = getIntPara("rankMarketCap", 0);
        currencyPrice.setRankMarketCap(rankMarketCap);
        long batchTime = getLongPara("batchTime", 0);
        currencyPrice.setBatchTime(batchTime);
        String infoUrl = getStrPara("infoUrl", "");
        currencyPrice.setInfoUrl(infoUrl);
        return currencyPrice;
    }

}

