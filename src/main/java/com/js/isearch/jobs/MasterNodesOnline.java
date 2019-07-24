package com.js.isearch.jobs;

import com.js.isearch.orm.CurrencyInfo;
import com.js.isearch.orm.CurrencyPos;
import com.js.isearch.orm.CurrencyPosScrawLog;
import com.js.isearch.orm.CurrencyStatus;
import com.js.isearch.serv.CurrencyInfoServ;
import com.js.isearch.serv.CurrencyPosScrawLogServ;
import com.js.isearch.serv.CurrencyPosServ;
import com.js.isearch.serv.CurrencyStatusServ;
import com.js.isearch.servread.CurrencyInfoServRead;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MasterNodesOnline {


    public static void getDataFromMasterNodesOnline(){
        String url = "https://masternodes.online";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()
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
                //System.out.println("response:"+response.body().string());

                String htmlContent = response.body().string();
                int index = htmlContent.lastIndexOf("</html>");
                htmlContent = htmlContent.substring(0,index+7);

                System.out.println("--------------1111111111111111111111");
                System.out.println(htmlContent);

                Document doc = Jsoup.parse(htmlContent);
                System.out.println("--------------2222222222222222222222");
                System.out.println(doc.body().toString());
                System.out.println("--------------3333333333333333333333");
                Element table = doc.select("table").get(1);
                System.out.println(table.toString());

                Elements trElements = table.select("tr");
                int size = trElements.size();
                List<CurrencyPos> currencyPosList = new ArrayList<>();
                List<CurrencyInfo> currencyInfoList = new ArrayList<>();
                //从1开始，0个是表头，不需要
                for(int i=1;i<size;i++){
                    Element trElement = trElements.get(i);
                    Elements tdElements = trElement.select("td");
                    int size2 = tdElements.size();
                    System.out.println("属性列数:"+size2);
                    CurrencyPos currencyPos=new CurrencyPos();
                    CurrencyInfo currencyInfo = new CurrencyInfo();
                    for(int j=0;j<size2;j++){
                       // currencyPos = new CurrencyPos();
                        Element tdElement = tdElements.get(j);
                        if(j==2){
                            String currencyName = tdElement.text();
                            System.out.println("名称:"+currencyName);
                            Element ahrefElement = tdElement.select("a").first();
                            System.out.println("链接herf:"+ahrefElement.attr("href"));
                            String href = ahrefElement.attr("href");
                            currencyPos.setDetailLink("https://masternodes.online"+href);
                            if(!StringUtils.isEmpty(currencyName)) {
                                int indexLeftParren= currencyName.indexOf("(");
                                if(indexLeftParren>0){
                                    String nn= currencyName.substring(0,indexLeftParren-1);
                                    String sym = currencyName.substring(indexLeftParren+1,currencyName.length()-1);
                                    currencyPos.setCurrencyName(currencyName);
                                    currencyPos.setSymbol(sym);

                                }else {
                                    currencyPos.setCurrencyName(currencyName);
                                    currencyPos.setSymbol(currencyName);
                                }
                            }else{
                            	currencyPos.setCurrencyName(currencyName+" "+i);
                                currencyPos.setSymbol(currencyName+" "+i);
                            }
                        }else if(j==3){
                            String priceStr =tdElement.text();
                            System.out.println("价格str:"+priceStr);
                            if(!StringUtils.isEmpty(priceStr)){
                                String trimStr = priceStr.substring(1,priceStr.length()).replace(",", "");
                                if(!StringUtils.isEmpty(trimStr)) {
                                    Double price = Double.parseDouble(trimStr);
                                    currencyPos.setCurrentPrice(price);
                                    System.out.println("price:" + price);
                                }
                            }
                        }else if(j==4){
                            String priceChangeStr = tdElement.text();
                            System.out.println("价格变化:"+priceChangeStr);
                            if(!StringUtils.isEmpty(priceChangeStr)) {
                                int percentIndex = priceChangeStr.indexOf("%");
                                String trimStr = priceChangeStr.substring(0, percentIndex - 1).replace(",", "");
                                if(!StringUtils.isEmpty(trimStr)) {
                                    Double priceChange = Double.parseDouble(trimStr);
                                    currencyPos.setPriceChange(priceChange);
                                    System.out.println("priceChange:" + priceChange);
                                }
                            }
                        }else if(j==5){
                            String volumeStr = tdElement.text();
                            System.out.println("交易量volume:"+volumeStr);
                            if(!StringUtils.isEmpty(volumeStr)){
                                String trimStr = volumeStr.substring(1,volumeStr.length()).replace(",", "");
                                if(!StringUtils.isEmpty(trimStr)){
                                    Long volume = Long.parseLong(trimStr);
                                    currencyPos.setVolume(volume);
                                    System.out.println("volume:"+volume);
                                }
                            }
                        }else if(j==6){
                            String marketCapStr = tdElement.text();
                            System.out.println("marketcap市值:"+marketCapStr);
                            if(!StringUtils.isEmpty(marketCapStr)) {
                            	String trimStr = marketCapStr.substring(1,marketCapStr.length()).replace(",", "");
                            	if(!StringUtils.isEmpty(trimStr)){
                                    Double marketCap = Double.parseDouble(trimStr);
                                    currencyPos.setMarketCap(marketCap);
                                    System.out.println("marketCap:"+marketCap);
                            	}
                            }
                        }else if(j==7){
                            String roiStr = tdElement.text();
                            System.out.println("ROI汇报率:"+roiStr);
                            if(!StringUtils.isEmpty(roiStr)){
                                int percentIndex = roiStr.indexOf("%");
                                String trimStr = roiStr.substring(0,percentIndex-1).replace(",", "");
                                if(!StringUtils.isEmpty(trimStr)) {
                                    Double roi = Double.parseDouble(trimStr);
                                    System.out.println("roi:" + roi);
                                    currencyPos.setRoi(roi);
                                }
                            }
                        }else if(j==8){
                            String nodeNumStr = tdElement.text();
                            System.out.println("Nodes节点数目:"+nodeNumStr);
                            if(!StringUtils.isEmpty(nodeNumStr)) {
                                String trimStr = nodeNumStr.replace(",", "");
                                if(!StringUtils.isEmpty(trimStr)) {
                                    int nodeNum = Integer.parseInt(trimStr);
                                    System.out.println("nodeNum:" + nodeNum);
                                    currencyPos.setNodeNum(nodeNum);
                                }
                            }
                        }else if(j==9){
                            String requiredNumStr = tdElement.text();
                            System.out.println("需要的币的数目required:"+requiredNumStr);
                            if(!StringUtils.isEmpty(requiredNumStr)){
                                String trimStr = requiredNumStr.replace(",", "");
                                if(!StringUtils.isEmpty(trimStr)) {
                                    int requiredNum = Integer.parseInt(trimStr);
                                    System.out.println("requiredNum:" + requiredNum);
                                    currencyPos.setRequiredNum(requiredNum);
                                }
                            }
                        }else if(j==10){
                            String mnWorthStr = tdElement.text();
                            System.out.println("Mn worth:"+mnWorthStr);
                            if(!StringUtils.isEmpty(mnWorthStr)) {
                                String trimStr = mnWorthStr.substring(1,mnWorthStr.length()).replace(",", "");
                                if(!StringUtils.isEmpty(trimStr)) {
                                    int mnWorth = Integer.parseInt(trimStr);
                                    System.out.println("mnWorth:" + mnWorth);
                                    currencyPos.setMnWorth(mnWorth);
                                }
                            }
                        }
                    }
                    currencyPos.setCreateTime(System.currentTimeMillis());
                    currencyPos.setUpdateTime(System.currentTimeMillis());
                    currencyPos.setInfoUrl("https://masternodes.online");
                    currencyPosList.add(currencyPos);
                    
                    System.out.println("currency name:"+currencyPos.getCurrencyName());
                    
                    System.out.println("总个数:"+size+" 当前数:"+i);
                }

                CurrencyInfoServ currencyInfoServ = CurrencyInfoServ.n();

                System.out.println("总的信息个数:"+currencyPosList.size());
                int ii=0;

                long batchTime =System.currentTimeMillis();
                int panelNum = currencyPosList.size();

                CurrencyPosScrawLog currencyPosScrawLog = new CurrencyPosScrawLog();
                currencyPosScrawLog.setPosBatchNum(panelNum);
                currencyPosScrawLog.setPosBatchTime(batchTime);
                int saveCurrencyPosScrawLogResult=CurrencyPosScrawLogServ.n().saveAutoId(currencyPosScrawLog);
                if(saveCurrencyPosScrawLogResult>0){
                    System.out.println("日志CurrencyPosScrawLog成功");
                }

                doInsertCurrencyPos(currencyPosList,batchTime);

                CurrencyStatus currencyStatus = CurrencyStatusServ.n().get(1);
                //currencyStatus.setCreateTime(System.currentTimeMillis());
                currencyStatus.setUpdateTime(System.currentTimeMillis());
                currencyStatus.setPosPanelNum(panelNum);
                if(currencyStatus.getCreateTime()==0){
                    currencyStatus.setCreateTime(System.currentTimeMillis());
                }
                currencyStatus.setPosLastBatchTime(batchTime);
                int updateResult=CurrencyStatusServ.n().update(currencyStatus);
                if(updateResult>0){
                    System.out.println("更新currency status成功");
                }
            }
        });
    }

    public static void doInsertCurrencyPos(List<CurrencyPos> currencyPosList,long batchTime){
        int ii=0;
        for(CurrencyPos currencyPos:currencyPosList){
            System.out.println("currency name:"+currencyPos.getCurrencyName());
            System.out.println("currency symbol:"+currencyPos.getSymbol());

            CurrencyInfo currencyInfo = new CurrencyInfo();
            currencyInfo.setName(currencyPos.getCurrencyName());
            currencyInfo.setSymbol(currencyPos.getSymbol());
            currencyInfo.setInitPrice(0);
            currencyInfo.setUrl("");
            currencyInfo.setVolume(currencyPos.getVolume());
            currencyInfo.setCurrencyDesc(currencyPos.getCurrencyName());
            currencyInfo.setInitDate(0);
            currencyInfo.setCirculatingVolume(0);
            currencyInfo.setMasterLink(currencyPos.getDetailLink());
            currencyInfo.setCurrencyIdName("");


            //先查询有没有已经插入记录，如果有才能插入记录
            List<CurrencyInfo> currencyInfos = CurrencyInfoServRead.n().find_OrderBy_BySymbolEq(currencyPos.getSymbol().trim());
            int returnCurrencyInfoId = 0;
            if(currencyInfos.size()>0){
                returnCurrencyInfoId = currencyInfos.get(0).getCurrencyId();
                CurrencyInfo currencyInfo1 = currencyInfos.get(0);
                currencyInfo1.setMasterLink(currencyPos.getDetailLink());
                currencyInfo1.setCurrencyIdName("");
                currencyInfo1.setDetailLink(currencyPos.getDetailLink());
                //int result = CurrencyInfoServ.n().update(currencyInfo1);
                //if(result>0){
                //    System.out.println("修改 master link成功");
                //}

                //System.out.println("已经存在,id为:"+returnCurrencyInfoId);
            }else {
                returnCurrencyInfoId = CurrencyInfoServ.n().saveAutoReturnId(currencyInfo);
            }

            if(StringUtils.isEmpty(currencyPos.getCurrencyName())){
                currencyPos.setCurrencyName("currencyName"+ii);
            }
            if(StringUtils.isEmpty(currencyPos.getSymbol())){
                currencyPos.setSymbol("symbol"+ii);
            }
            if(StringUtils.isEmpty(currencyPos.getLogoUrl())){
                currencyPos.setLogoUrl("logoUrl"+ii);
            }
            currencyPos.setCurrencyId(returnCurrencyInfoId);
            currencyPos.setBatchTime(batchTime);
            int result=CurrencyPosServ.n().saveAutoId(currencyPos);
            if(result>0) ii++;
        }
    }


    public static void main(String[] args) {

        getDataFromMasterNodesOnline();


    }

}
