package com.js.isearch.index;

import com.js.isearch.orm.Doc;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.lionsoul.jcseg.Word;
import org.lionsoul.jcseg.analyzer.JcsegAnalyzer4X;
import org.lionsoul.jcseg.core.JcsegTaskConfig;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class IndexAnalyzer {


    public static void main(String[] args) throws IOException{
        String cmd = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("jcseg>> ");
            cmd = reader.readLine();
            if ( cmd == null ) break;
            cmd = cmd.trim();
            if ( "".equals(cmd) ) continue;
            if ( cmd.equals("quit") || cmd.equals("exit")) {
                System.out.println("Thanks for trying jcseg, Bye!");
                System.exit(0);
            }
            //segment
            jcregAnalyzer(cmd);
        } while ( true );


    }

    public static void main1(String[] args) {
        jcregAnalyzer();
    }

    public static void ikAnalyzer() {
        //构建IK分词器，使用smart分词模式
        Analyzer analyzer = new IKAnalyzer(true, true, true);

        //获取Lucene的TokenStream对象
        TokenStream ts = null;
        try {
            ts = analyzer.tokenStream("myfield", new StringReader("123456 我是中国人 IK Analyzer是一个结合词典分词和文法分词的中文分词开源工具包。它使用了全新的正向迭代最细粒度切分算法。"));
            //ts = analyzer.tokenStream("myfield", new StringReader(doc.getBody()));

            //获取词元位置属性
            OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
            //获取词元文本属性
            CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
            //获取词元文本属性
            TypeAttribute type = ts.addAttribute(TypeAttribute.class);
            PositionIncrementAttribute pos = ts.addAttribute(PositionIncrementAttribute.class);

            //重置TokenStream（重置StringReader）
            ts.reset();
            //迭代获取分词结果
            while (ts.incrementToken()) {
                int len = term.toString().length();
                System.out.println("len:"+len);
                if(len==1) continue;
                System.out.println(offset.startOffset() + " - " + offset.endOffset() + " : " + pos.getPositionIncrement() + " | " + term.toString() + " | " + type.type());
            }
            //关闭TokenStream（关闭StringReader）
            ts.end();   // Perform end-of-stream operations, e.g. set the final offset.
        } catch (IOException e) {
            e.printStackTrace();
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

    public static List<Word> ikAnalyzer(String query) {
        List<Word> wordList =null;
        //构建IK分词器，使用smart分词模式
        Analyzer analyzer = new IKAnalyzer(true, true, true);

        //获取Lucene的TokenStream对象
        TokenStream ts = null;
        try {
            ts = analyzer.tokenStream("myfield", new StringReader(query));
            //ts = analyzer.tokenStream("myfield", new StringReader(doc.getBody()));

            //获取词元位置属性
            OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
            //获取词元文本属性
            CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
            //获取词元文本属性
            TypeAttribute type = ts.addAttribute(TypeAttribute.class);
            PositionIncrementAttribute pos = ts.addAttribute(PositionIncrementAttribute.class);

            //重置TokenStream（重置StringReader）
            ts.reset();
            //迭代获取分词结果
            wordList =new ArrayList<>();
            while (ts.incrementToken()) {
                int len = term.toString().length();
                System.out.println("len:"+len);
                if(len==1) continue;
                System.out.println(offset.startOffset() + " - " + offset.endOffset() + " : " + pos.getPositionIncrement() + " | " + term.toString() + " | " + type.type());
                Word word = new Word(term.toString(),typeStrToInt(type.type()));
                word.setPosition(offset.startOffset());
                wordList.add(word);
            }
            //关闭TokenStream（关闭StringReader）
            ts.end();   // Perform end-of-stream operations, e.g. set the final offset.
        } catch (IOException e) {
            e.printStackTrace();
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
        return wordList;
    }

    public static List<Word> jcregAnalyzer(String query) {

        long beginTime  = System.currentTimeMillis();
        System.out.println("开始时间:"+beginTime);


        List<Word> wordList = null;
        Analyzer analyzer = new JcsegAnalyzer4X(JcsegTaskConfig.SIMPLE_MODE);
        //非必须(用于修改默认配置): 获取分词任务配置实例
        JcsegAnalyzer4X jcseg = (JcsegAnalyzer4X) analyzer;
        JcsegTaskConfig config = jcseg.getTaskConfig();
        //追加同义词到分词结果中, 需要在jcseg.properties中配置jcseg.loadsyn=1
        config.setAppendCJKSyn(true);
        //追加拼音到分词结果中, 需要在jcseg.properties中配置jcseg.loadpinyin=1
        config.setAppendCJKPinyin(true);
        //更多配置, 请查看com.webssky.jcseg.core.JcsegTaskConfig类
        String words = query;
        TokenStream stream = null;
        try {
            stream = analyzer.tokenStream("myfield", words);
            stream.reset();
            //词元文本属性
            CharTermAttribute offsetAtt = stream.addAttribute(CharTermAttribute.class);
            //获取词元位置属性
            OffsetAttribute offset = stream.addAttribute(OffsetAttribute.class);
            //获取词元文本属性
            TypeAttribute type = stream.addAttribute(TypeAttribute.class);

            PositionIncrementAttribute pos = stream.addAttribute(PositionIncrementAttribute.class);
            wordList = new ArrayList<>();
            //stream.reset();
            while (stream.incrementToken()) {
                String value = offsetAtt.toString().trim();
                if(value.length()<=1) continue;
                Word word = new Word(offsetAtt.toString(),typeStrToInt(type.type()));
                word.setPosition(offset.startOffset());
                System.out.println("分词:" + offsetAtt.toString());
                System.out.println("位置开始:"+offset.startOffset()+" 位置结束:"+offset.endOffset());
                System.out.println("属性:"+type.type());
                System.out.println("位置增量:"+pos.getPositionIncrement());
                wordList.add(word);
            }
            stream.end();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (stream != null)
                    stream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("结束时间:"+endTime);
        System.out.println("用时:"+(endTime-beginTime));

        return wordList;
    }

    public static int typeStrToInt(String type){
        if(type.equalsIgnoreCase("word")){
            return Word.T_CJK_WORD;
        }else{
            return Word.T_CJK_WORD;
        }
    }


    public static void jcregAnalyzer() {
        long beginTime  = System.currentTimeMillis();
        System.out.println("开始时间:"+beginTime);

        Analyzer analyzer = new JcsegAnalyzer4X(JcsegTaskConfig.SIMPLE_MODE);
        //非必须(用于修改默认配置): 获取分词任务配置实例
        JcsegAnalyzer4X jcseg = (JcsegAnalyzer4X) analyzer;
        JcsegTaskConfig config = jcseg.getTaskConfig();
        //追加同义词到分词结果中, 需要在jcseg.properties中配置jcseg.loadsyn=1
        config.setAppendCJKSyn(true);
        //追加拼音到分词结果中, 需要在jcseg.properties中配置jcseg.loadpinyin=1
        config.setAppendCJKPinyin(true);
        //更多配置, 请查看com.webssky.jcseg.core.JcsegTaskConfig类
        String words = "智能合约";
        TokenStream stream = null;
        try {
            stream = analyzer.tokenStream("myfield", words);
            stream.reset();
            //词元文本属性
            CharTermAttribute offsetAtt = stream.addAttribute(CharTermAttribute.class);
            //获取词元位置属性
            OffsetAttribute offset = stream.addAttribute(OffsetAttribute.class);
            //获取词元文本属性
            TypeAttribute type = stream.addAttribute(TypeAttribute.class);

            PositionIncrementAttribute pos = stream.addAttribute(PositionIncrementAttribute.class);
//            stream.reset();
            while (stream.incrementToken()) {
                System.out.println("分词:" + offsetAtt.toString());
                System.out.println("位置开始:"+offset.startOffset()+" 位置结束:"+offset.endOffset());
                System.out.println("属性:"+type.type());
                System.out.println("位置增量:"+pos.getPositionIncrement());
            }
            stream.end();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (stream != null)
                    stream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("结束时间:"+endTime);
        System.out.println("用时:"+(endTime-beginTime));
    }
}
