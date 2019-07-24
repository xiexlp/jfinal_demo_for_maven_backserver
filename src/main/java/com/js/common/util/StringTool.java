package com.js.common.util;

//import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

public class StringTool {

    public static void main(String[] args) {

        String name="group_desc";
        String hump = underLineToHump(name);
        System.out.println(hump);

    }

    public static void test1(String[] args) {
        String name="groupDesc";
        String underLineStr=humpToUnderLine(name);
        System.out.println("underline str:"+underLineStr);
    }

    public static String underLineToHump(String name){
        StringTokenizer st =new StringTokenizer(name, "_");
        StringBuffer sb = new StringBuffer();
        sb.append(st.nextToken());
        while (st.hasMoreTokens()){
            sb.append(StringUtils.capitalize(st.nextToken()));
        }
        return sb.toString();
    }


    /**
     * 变成hump to underline
     * @param name
     * @return
     */
    public static String  humpToUnderLine(String name) {
        //printUpperChar(name);
        List<String> strList =splitString(name);
        StringBuffer sb = new StringBuffer(strList.get(0));
        int size = strList.size();
        for(int i=1;i< size;i++){
            sb.append("_");
            sb.append(strList.get(i).toLowerCase());
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }

    public static List<String> splitString(String name){
        List<Integer> indexList=testUpperChar(name);
        List<String> indexStrList = new ArrayList();
        int l=indexList.size();
        for(int i=0;i<l-1;i++){
            int lastIndex = indexList.get(i);
            int currentIndex = indexList.get(i+1);
            String word = name.substring(lastIndex,currentIndex);
            System.out.println("word:"+word);
            indexStrList.add(word);
        }
        return indexStrList;
    }

    public static String capitalStr(String name){
        return  StringUtils.capitalize(name);
    }

    public static void printUpperChar(String name){
        List<Integer> indexList=testUpperChar(name);
        int l=indexList.size();
        for(int i=0;i<l;i++){
            int index = indexList.get(i);
            System.out.println(index+":"+name.charAt(index));
        }
    }

    public static List testUpperChar(String name) {
        char[] nameCharArray = name.toCharArray();
        int len = nameCharArray.length;
        List<Integer> indexList=new ArrayList();
        indexList.add(0);
        int j=0;
        for(int i=0;i<len;i++){
            char c = nameCharArray[i];
            if(Character.isUpperCase(c)){
                System.out.println("upper case i:"+i);
                indexList.add(i);
            }
        }
        indexList.add(len);
        return indexList;
    }

}
