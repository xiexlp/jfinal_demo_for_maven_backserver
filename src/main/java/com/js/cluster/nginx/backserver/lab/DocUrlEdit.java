package com.js.cluster.nginx.backserver.lab;

import com.js.isearch.orm.Doc;
import com.js.isearch.serv.DocServ;
import com.js.isearch.servupdate.DocServUpdate;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class DocUrlEdit {

    public static void main(String[] args) {
        String oldUrl ="http://localhost/boot/topic/topicattach?topicId=1";
        int httpsIndex = oldUrl.indexOf("https");

        String newUrl =StringUtils.replace(oldUrl,"http","https");
        System.out.println(newUrl);

        DocServ docServ = DocServ.n();
        //docServ.u
        DocServUpdate docServUpdate = DocServUpdate.n();
        List<Doc> docList = docServ.findAll();
        for(Doc doc:docList){
            System.out.println(doc.getUrl());
            //System.out.println("new url:"+StringUtils.replace(doc.getUrl(),"http","https"));
            String url = doc.getUrl();
            httpsIndex = url.indexOf("https");
            if(httpsIndex<0) {
                System.out.println("https不存在");
                String newUrl1 = StringUtils.replace(doc.getUrl(), "http", "https");
                doc.setUrl(newUrl1);
                int r = docServUpdate.updateUrlByDocId(newUrl1, doc.getDocId());
                System.out.println("结果:" + r);
            }else {
                System.out.println("https存在");
            }
            //docServ.update(doc);
        }
    }
}
