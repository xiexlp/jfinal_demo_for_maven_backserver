package com.js.isearch.index;

import com.js.isearch.orm.Doc;
import com.js.isearch.serv.DocServ;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;

/***
 * 文档分词
 */
public class DocAnalyzer {

    public static void main(String[] args) {
        Doc doc = DocServ.n().get(2);
        
        System.out.println("content:"+doc.getBody());
        
        indexAnalyzer(doc);
    }

    public static void indexAnalyzer(Doc doc) {
        //构建IK分词器，使用smart分词模式
        Analyzer analyzer = new IKAnalyzer(true, true, true);

        //获取Lucene的TokenStream对象
        TokenStream ts = null;
        try {
            //ts = analyzer.tokenStream("myfield", new StringReader("123456 我是中国人 IK Analyzer是一个结合词典分词和文法分词的中文分词开源工具包。它使用了全新的正向迭代最细粒度切分算法。"));
            ts = analyzer.tokenStream("myfield", new StringReader(doc.getBody()));

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

}
