package com.js.isearch.index;

import com.js.cluster.nginx.backserver.orm.WordPos;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.lionsoul.jcseg.core.IWord;
import org.lionsoul.jcseg.core.JcsegException;
import org.lionsoul.jcseg.test.JcsegUtil;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 搜索类,客户端搜索分词，对用户的输入进行分词
 */
public class SearchDemo {

    public static final int STATE_OR=0;
    public static final int STATE_CN=1;
    public static final int STATE_EN=2;

    JcsegUtil jcsegUtil=null;

    public SearchDemo(){
        try {
            jcsegUtil=new JcsegUtil();
        } catch (JcsegException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Set<String> seperatorSet =new HashSet();
    public List<String> wordList =new ArrayList();

    public List<IWord> seperatorByJcreg(String query){
        try {
            return jcsegUtil.segmentToWord(query);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> seperator(String query){
        int lastState=0;
        int state = 0;
        //List<String> wordList = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        //StringBuffer sb2=new StringBuffer();
        // 这个分词器应该自己写，使用二分法最好
        int len = query.length();
        for (int i = 0; i < len; i++) {
            Character c = query.charAt(i);
            System.out.println(c.toString());
            if(c>0x0391&&c<0xFFE5){
                System.out.println("中文");
                if(lastState==STATE_CN){
                    sb.append(c);
                }//英文
                else if(lastState==STATE_EN){
                    wordList.add(sb.toString());
                    sb.setLength(0);
                    sb.append(c);
                    lastState =STATE_CN;
                }else if(lastState==STATE_OR){
                    sb.setLength(0);
                    sb.append(c);
                    lastState =STATE_CN;
                }
                //sb.append(c);
            }else if(c >= 0x0000 && c <= 0x00FF){
                System.out.println("英文字母"+c);
                if(c!=' '&&c!=','){
                    if(lastState==STATE_EN){
                        //System.out.println("英文字母");
                        sb.append(c);
                    }else if(lastState==STATE_CN){
                        lastState=STATE_EN;
                        wordList.add(sb.toString());
                        sb.setLength(0);
                        sb.append(c);
                    }else if(lastState==STATE_OR){
                        lastState =STATE_EN;
                        sb.setLength(0);
                        sb.append(c);
                    }
                }else{
                    System.out.println("进入分隔符 空格模式,当前字符串:"+sb.toString());
                    if(!sb.toString().equalsIgnoreCase("")){
                        wordList.add(sb.toString());
                    }
                    sb=new StringBuffer();
                    lastState =STATE_OR;
                    //continue;
                }
                //state=1;
            }else if(c=='\n'){
                //wordList.add(sb.toString());
            }else if(c=='\t'){
                wordList.add(sb.toString());
                sb=new StringBuffer();
            }else if(c==' '){
                System.out.println("到空格");
                wordList.add(sb.toString());
                sb.setLength(0);
            }
        }
        wordList.add(sb.toString());
        for(String w:wordList){
            System.out.println("分词结果:"+w.trim());
        }
        return wordList;
    }

//    public List<String> mmseperate(String query){
//
//    }

    public List<WordPos> ikseperate(String query){
        List<WordPos> wordPosList = new ArrayList<>();
        //构建IK分词器，使用smart分词模式
        Analyzer analyzer = new IKAnalyzer(true, true, true);
        //获取Lucene的TokenStream对象
        TokenStream ts = null;
        try {
            //ts = analyzer.tokenStream("myfield", new StringReader("123456 我是中国人 IK Analyzer是一个结合词典分词和文法分词的中文分词开源工具包。它使用了全新的正向迭代最细粒度切分算法。"));
            ts = analyzer.tokenStream("myfield", new StringReader(query));
            //获取词元位置属性
            OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
            //获取词元文本属性
            CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
            //获取词元文本属性
            TypeAttribute type = ts.addAttribute(TypeAttribute.class);
            PositionIncrementAttribute pos = ts.addAttribute(PositionIncrementAttribute.class);
            WordPos wordPos =null;
            //重置TokenStream（重置StringReader）
            ts.reset();
            //迭代获取分词结果
            while (ts.incrementToken()) {
                int len = term.toString().length();
                System.out.println("len:"+len);
                if(len==1) continue;
                System.out.println(offset.startOffset() + " - " + offset.endOffset() + " : " + pos.getPositionIncrement() + " | " + term.toString() + " | " + type.type());
                wordPos = new WordPos(term.toString(),offset.startOffset(),offset.endOffset(),pos.getPositionIncrement(),type.type());
                wordPosList.add(wordPos);
            }
            //关闭TokenStream（关闭StringReader）
            ts.end();   // Perform end-of-stream operations, e.g. set the final offset.
            return wordPosList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            //释放TokenStream的所有资源
            if (ts != null) {
                try {
                    ts.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


	public static void main(String[] args) {
        SearchDemo searchDemo =new SearchDemo();
        String query = "中国,人民  redis";
        searchDemo.seperator(query);
	}

	boolean isCnorEn(char c) {
		if ((c >= 0x0391 && c <= 0xFFE5) // 中文字符
				|| (c >= 0x0000 && c <= 0x00FF)) // 英文字符
			return true;
		return false;
	}

}
