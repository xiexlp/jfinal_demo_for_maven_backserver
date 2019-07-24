package com.js.isearch.jobs;

import com.js.isearch.orm.CurrencyInfo;
import com.js.isearch.orm.CurrencyPrice;
import com.js.isearch.orm.CurrencyStatus;
import com.js.isearch.serv.CurrencyInfoServ;
import com.js.isearch.serv.CurrencyPriceServ;
import com.js.isearch.serv.CurrencyStatusServ;
import com.js.isearch.servread.CurrencyInfoServRead;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.select.Elements;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * 分页得到数据
 */
public class CoinMarketCap {

    public static void getDataFromCoinMarketCap(){
        //String url = "https://coinmarketcap.com";
        //所有的币
        String url ="https://coinmarketcap.com/all/views/all/";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//榛樿灏辨槸GET璇锋眰锛屽彲浠ヤ笉鍐�
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            // @Override
            public void onFailure(Call call, IOException e) {
                //Log.d(TAG, "onFailure: ");
                System.out.println("failure");
            }

            //  @Override
            public void onResponse(Call call, Response response) throws IOException {
                //Log.d(TAG, "onResponse: " + response.body().string());
                String htmlContent=response.body().string();
                // System.out.println("response:"+);

                Document doc = Jsoup.parse(htmlContent);
                Element table = doc.select("table").get(0);
                System.out.println(table.toString());

                Elements trSelect = table.select("tr");
                System.out.println("数量:"+trSelect.size());
                System.out.println("--------------------数量--------------------");
                List<CurrencyPrice> currencyPriceList = new ArrayList<>();



                for(int i=1;i<trSelect.size();i++){
                    Element element=trSelect.get(i);
                    System.out.println("element:");
                    System.out.println(element.toString());

                    Elements tdSelects = element.select("td");
                    CurrencyPrice currencyPrice = new CurrencyPrice();
                    int tdSize= tdSelects.size();
                    for(int j=0;j<tdSize;j++){
                        Element tdElement = tdSelects.get(j);
                        if(j==0){
                            String rankStr = tdElement.text();
                            System.out.println("排名:"+rankStr);
                            if(!StringUtils.isEmpty(rankStr)){
                                int rank = Integer.parseInt(rankStr);
                            }
                        }else if(j==1){
                            String nameStr = tdElement.select("a").text();
                            System.out.println("名称:"+nameStr);
                            if(!StringUtils.isEmpty(nameStr)){
                                //int indexSpace = nameStr.indexOf(" ");
//                                String symbol = nameStr.substring(0,indexSpace);
//                                String name = nameStr.substring(indexSpace+1,nameStr.length());
                                //System.out.println("名称:"+name+" 标识:"+symbol);
                                currencyPrice.setName(nameStr);
                                //currencyPrice.setSymbol(symbol);
                            }else {
                                currencyPrice.setName("currencyName");
                            }
                        }else if(j==2){
                            String marketCapStr = tdElement.text();
                            System.out.println("market-cap市值:"+marketCapStr);
                            if(!StringUtils.isEmpty(marketCapStr)){
                                marketCapStr=marketCapStr.substring(1,marketCapStr.length()).replace(",","");
                                double marketCap = Double.parseDouble(marketCapStr);
                                System.out.println("market cap:"+marketCap);
                                currencyPrice.setMarketCap(marketCap);
                            }

                        }else if(j==3){
                            System.out.println("价格:"+tdElement.text());
                            String priceStr = tdElement.text();
                            System.out.println("市场价格:"+priceStr);
                            if(!StringUtils.isEmpty(priceStr)){
                                priceStr=priceStr.substring(1,priceStr.length()).replace(",","");
                                double price = Double.parseDouble(priceStr);
                                System.out.println("price:"+price);
                                currencyPrice.setCurrentPrice(price);
                            }
                        }else if(j==4){
                            //System.out.println("market-volume量:"+tdElement.text());
                            String volumeStr = tdElement.text();
                            System.out.println("market-交易量:"+volumeStr);
                            if(!StringUtils.isEmpty(volumeStr)){
                                volumeStr=volumeStr.substring(1,volumeStr.length()).replace(",","");
                                long volume = Long.parseLong(volumeStr);
                                System.out.println("market cap:"+volume);
                                currencyPrice.setVolume(volume);
                            }

                        }else if(j==5){
                            System.out.println("流通总量supply:"+tdElement.text());
                            //System.out.println("market-volume量:"+tdElement.text());
                            String circulationVolumeStr = tdElement.text();
                            System.out.println("流通总量supply:"+circulationVolumeStr);
                            if(!StringUtils.isEmpty(circulationVolumeStr)){
                                int indexSpace = circulationVolumeStr.indexOf(" ");
                                String circulationVolumeSt = circulationVolumeStr.substring(0,indexSpace);
                               String name = circulationVolumeStr.substring(indexSpace+1,circulationVolumeStr.length());
                                if(name.indexOf("*")>0){
                                    String symbol = name.replace("*","").trim();
                                    currencyPrice.setSymbol(symbol);
                                }else{
                                	 currencyPrice.setSymbol(name);
                                }
                                String aaa = circulationVolumeSt.replace(",","");
                                long circulationVolume = Long.parseLong(aaa);
                                currencyPrice.setCirculatingVolume(circulationVolume);
                            }
                        }else if(j==6){
                            String priceChangeStr = tdElement.text();
                            System.out.println("价格变化:"+priceChangeStr);
                            if(!StringUtils.isEmpty(priceChangeStr)) {
                                int percentIndex = priceChangeStr.indexOf("%");
                                String trimStr = priceChangeStr.substring(0, percentIndex - 1).replace(",", "");
                                if(!StringUtils.isEmpty(trimStr)) {
                                    Double priceChange = Double.parseDouble(trimStr);
                                    currencyPrice.setPriceChange(priceChange);
                                    System.out.println("priceChange:" + priceChange);
                                }
                            }
                        }
                    }
                    currencyPriceList.add(currencyPrice);
                }
                doInsertDatabase(currencyPriceList);
            }
        });
    }



    public static void doInsertDatabase(List<CurrencyPrice> currencyPriceList){
        long priceBatchTime = System.currentTimeMillis();
        int pricePanelNum = currencyPriceList.size();
        System.out.println("price panel num面板数量:"+pricePanelNum);
        CurrencyStatus currencyStatus = CurrencyStatusServ.n().get(1);
        currencyStatus.setPriceLastBatchTime(priceBatchTime);
        currencyStatus.setPricePanelNum(pricePanelNum);
        int updateResult= CurrencyStatusServ.n().update(currencyStatus);
        if(updateResult>0){
            System.out.println("更新状态成功");
        }

        int j=0;
        for(CurrencyPrice currencyPrice:currencyPriceList){
            currencyPrice.setUpdateTime(priceBatchTime);
            currencyPrice.setCreateTime(priceBatchTime);
            currencyPrice.setDexId(0);
            currencyPrice.setDexName("dexname");
            currencyPrice.setBatchTime(priceBatchTime);
            currencyPrice.setInfoUrl("https://coinmarketcap.com");
            //currencyPrice.setName();

            List<CurrencyInfo> currencyInfoList = CurrencyInfoServRead.n().find_OrderBy_BySymbolEq(currencyPrice.getSymbol().trim());

            int returnCurrencyId = 0;
            if(currencyInfoList.size()>0) {
                returnCurrencyId = currencyInfoList.get(0).getCurrencyId();
            }else {
                currencyPrice.setCurrencyId(0);
                CurrencyInfo currencyInfo= new CurrencyInfo();
                currencyInfo.setCirculatingVolume(currencyPrice.getCirculatingVolume());
                currencyInfo.buildInitDate(0).buildInitPrice(0).buildCurrencyDesc(currencyPrice.getName()).buildSymbol(currencyPrice.getSymbol())
                        .buildUrl("https://coinmarketcap.com").buildVolume(currencyPrice.getVolume()).buildName(currencyPrice.getName());
                returnCurrencyId = CurrencyInfoServ.n().saveAutoReturnId(currencyInfo);
            }
            currencyPrice.setCurrencyId(returnCurrencyId);
            // currencyPriceList.add(currencyPrice);
            currencyPrice.setRankMarketCap(j+1);
            int result = CurrencyPriceServ.n().saveAutoId(currencyPrice);
            if(result>0){
                System.out.println("价格数据入库成功:"+currencyPrice.getSymbol());
            }
            j++;
            
        }

    }

    public static void main(String[] args) {

        getDataFromCoinMarketCap();

    }
}
