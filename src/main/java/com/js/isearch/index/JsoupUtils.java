package com.js.isearch.index;

import com.js.isearch.orm.Doc;
import com.js.isearch.serv.DocServ;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

/***
 * 本来主要处理文档中的html标签
 */
public class JsoupUtils {

    public static void main(String[] args) {
        //docHtml2Text();
        //docHtml2Text();
    	docAllHtml2Text();
    }

    /**
     * 将所有的doc带有html标签的转换为没有html标签的
     */
    public static void docAllHtml2Text(){
        List<Doc> docList = DocServ.n().findAll();
        for(Doc doc:docList){
            docHtml2Text(doc);
        }
    }


    public static void docHtml2Text(Doc doc){
        System.out.println("origin content:"+doc.getBody());
        Document document = Jsoup.parse(doc.getBody());
        System.out.println("plain text:"+document.text().toString());
        String newBody=document.text().toString();
        //doc.setBody(newBody);
        DocServ.n().updateBodyUpdateTimeByDocId(newBody,System.currentTimeMillis(),doc.getDocId());
    }

    public static void docHtml2Text(){
        Doc doc = DocServ.n().get(1);
        System.out.println("origin content:"+doc.getBody());
        Document document = Jsoup.parse(doc.getBody());
        System.out.println("plain text:"+document.text().toString());
        String newBody=document.text().toString();
        //doc.setBody(newBody);
        DocServ.n().updateBodyUpdateTimeByDocId(newBody,System.currentTimeMillis(),doc.getDocId());
    }

    public  static void test(){
        // 直接从字符串中输入 HTML 文档
        String html = "<html><head><title> 开源中国社区 </title></head>"
                + "<body><p> 这里是 jsoup 项目的相关文章 </p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc.text().toString());

    }
}
