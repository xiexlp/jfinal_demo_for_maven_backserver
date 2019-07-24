package com.js.isearch.index;

import org.lionsoul.jcseg.core.IWord;
import org.lionsoul.jcseg.core.JcsegException;
import org.lionsoul.jcseg.test.JcsegUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JcsegService {

    List<JcsegUtil> jcsegUtilList=null;

    public static JcsegService jcsegServiceInstance;

    public static JcsegService getInstance(){
        if(jcsegServiceInstance==null){
            jcsegServiceInstance = new JcsegService();
        }
        return jcsegServiceInstance;
    }

    public JcsegService(){
        jcsegUtilList = new ArrayList<>();
        int i=0;
        try {
            for(i=0;i<10;i++) {
                JcsegUtil jcsegUtil = new JcsegUtil();
                jcsegUtilList.add(jcsegUtil);
            }
        } catch (JcsegException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<IWord> seperateByJcseg(String query){
        Random random = new Random();
        int i = random.nextInt(9);
        System.out.println("第几个分词器:"+i);
        JcsegUtil jcsegUtil = jcsegUtilList.get(i);
        try {
            return jcsegUtil.segmentToWord(query);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
