package com.js.cluster.nginx.backserver.controller;

import com.jfinal.core.Controller;
import com.js.cluster.nginx.backserver.orm.WordPos;
import com.js.common.util.ControllerAdaper;
import com.js.isearch.index.IndexAnalyzer;
import com.js.isearch.index.SearchDemo;
import org.lionsoul.jcseg.Word;


import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class AnalyzerController extends ControllerAdaper {

    //测试网页的热部署
    public void index(){
        setAttr("hello","123");
    }

    public void seperate(){
        SearchDemo searchDemo = new SearchDemo();
        String query = getStrPara("query","");
        List<String> wordPosList = searchDemo.seperator(query);
        setAttr("wordPosList",wordPosList);
    }


    public void analyzeByJcreg(){
        String query = getStrPara("query","");
        List<Word> wordList = IndexAnalyzer.jcregAnalyzer(query);
        setAttr("wordList",wordList);
    }

    public void analyzeByIk(){
        SearchDemo searchDemo = new SearchDemo();
        String query = getStrPara("query","");
        List<Word> wordList = IndexAnalyzer.ikAnalyzer(query);
        setAttr("wordList",wordList);
    }

    public void ikseperate(){
        SearchDemo searchDemo = new SearchDemo();
        String query = getStrPara("query","");
        List<WordPos> wordPosList = searchDemo.ikseperate(query);
        setAttr("wordPosList",wordPosList);
    }

}
