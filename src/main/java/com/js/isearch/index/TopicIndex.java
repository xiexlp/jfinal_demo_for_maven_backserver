package com.js.isearch.index;

/**
 * IK 中文分词  版本 5.0.1
 * IK AnalyzerController release 5.0.1
 * <p>
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * 源代码由林良益(linliangyi2005@gmail.com)提供
 * 版权声明 2012，乌龙茶工作室
 * provided by Linliangyi and copyright 2012 by Oolong studio
 */


import com.js.isearch.orm.Postings;
import com.js.isearch.orm.Token;
import com.js.isearch.serv.PostingsServ;
import com.js.isearch.serv.TokenServ;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

/**
 * 使用IKAnalyzer进行分词的演示
 * 2012-10-22
 *
 */
public class TopicIndex {


    public static void indexCreate(String content,long topicId,String tablename,String dbname) {
        //构建IK分词器，使用smart分词模式
        Analyzer analyzer = new IKAnalyzer(true, true, true);

        //获取Lucene的TokenStream对象
        TokenStream ts = null;
        try {
            //ts = analyzer.tokenStream("myfield", new StringReader("123456 我是中国人 IK Analyzer是一个结合词典分词和文法分词的中文分词开源工具包。它使用了全新的正向迭代最细粒度切分算法。"));
            ts = analyzer.tokenStream("myfield", new StringReader(content));

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

                String token = term.toString();

                //查询是否存在
                List<Long> tokenIdList = TokenServ.n().findTokenIdByToken(token);
                int size = tokenIdList.size();
                //已经存在
                if(size>=1){
                    long tokenId = tokenIdList.get(0);
                    //多一个文档引用
                    TokenServ.n().incDocCount(tokenId,1);
                    //首先应该查询是否存在topicID,和tokenId，是否已经存在；如果存在则

                    List<Long> postingIdList = PostingsServ.n().findPostingIdByTokenIdDocId(tokenId,topicId);
                    int size1= postingIdList.size();
                    //已经存在，则更新
                    if(size1>=1){

                    }//不存在，则新建
                    else{
                        Postings postings = new Postings();
                        postings.setCreateTime(System.currentTimeMillis());
                        postings.setDbname(dbname);
                        postings.setTablename(tablename);
                        postings.setToken(term.toString());
                        postings.setTokenId(tokenId);
                        postings.setDocId(topicId);
                    }
                }
                //不存在
                else {

                }
                //String dbname = "iforum";
                Token token1 = new Token();
                token1.setToken(token);
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


    public static void main(String[] args) {
        //构建IK分词器，使用smart分词模式
        Analyzer analyzer = new IKAnalyzer(true, true, true);

        //获取Lucene的TokenStream对象
        TokenStream ts = null;
        try {
            //ts = analyzer.tokenStream("myfield", new StringReader("123456 我是中国人 IK Analyzer是一个结合词典分词和文法分词的中文分词开源工具包。它使用了全新的正向迭代最细粒度切分算法。"));
            ts = analyzer.tokenStream("myfield", new StringReader("123456 我是中国人,hold住, hello , weewew ,IK Analyzer是一个结合词典分词和文法分词的中文分词开源工具包。它使用了全新的正向迭代最细粒度切分算法。"));

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
