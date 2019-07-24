package com.js.isearch.index;

import com.js.cluster.nginx.backserver.orm.Hit;
import com.js.cluster.nginx.backserver.orm.Position;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HighLighter {

    static String highStylePre="<span style=\"color:red;\">";
    static String highStyleSuffix ="</span>";

    //这块的速度可能比较慢，是潜在的性能影响因素之一，是否可以考虑在前端显示的时候搞定,如使用javascript搞定
    public static void highLighter(Hit hit){
        List<Position> positionList = hit.getPostionList();
        StringBuffer sb = new StringBuffer();
        for(Position p:positionList){
            String query = p.getQuery();
            String fieldname = p.getFieldname();
            String content=null;
            if(fieldname.equalsIgnoreCase("title")){
                content = hit.getTitle();
                sb.setLength(0);
                content=replaceAll3(content,query,sb.append(highStylePre).append(query).append(highStyleSuffix).toString());
                //System.out.println("title highlighter:"+content);
                hit.setTitle(content);
            }else if(fieldname.equalsIgnoreCase("content")){
                content = hit.getBody();
                sb.setLength(0);
                content=replaceAll3(content,query,sb.append(highStylePre).append(query).append(highStyleSuffix).toString());
                //System.out.println("content highlighter:"+content);
                hit.setBody(content);
            }
        }
    }

    /***
     * replaceAll,忽略大小写
     *
     * @param input
     * @param regex
     * @param replacement
     * @return
     */
    public static String replaceAll3(String input, String regex, String replacement) {
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        String result = m.replaceAll(replacement);
        return result;
    }


    public static void test_replaceAll3() {
        String input = "I like Java,jAva is very easy and jaVa is so popular.";
        String regex = "java";
        String replacement = "cccc";

        String sb = replaceAll3(input, regex, replacement);
        System.out.println(input);
        System.out.println(sb);

    }

}
