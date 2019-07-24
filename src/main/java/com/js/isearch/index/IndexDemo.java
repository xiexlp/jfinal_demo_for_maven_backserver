package com.js.isearch.index;

import com.alibaba.fastjson.JSON;
import com.js.common.util.StringTool;
import com.js.isearch.orm.Doc;
import com.js.isearch.orm.Postings;
import com.js.isearch.orm.Token;
import com.js.isearch.serv.DocServ;
import com.js.isearch.serv.PostingsServ;
import com.js.isearch.serv.TokenServ;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.apache.lucene.search.spans.SpanWeight;
import org.jsoup.Jsoup;
import org.lionsoul.jcseg.analyzer.JcsegAnalyzer4X;
import org.lionsoul.jcseg.core.JcsegTaskConfig;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 索引类，首先需要理解索引不需要太快，可以有一定的时延，因此，可以牺牲性能，增加可读性，增加程序的可扩展性，不需要
 * 把所有的东西写到一个函数里面去，以至于过度复杂
 */
public class IndexDemo {
    //分词供应商选择
    public static final int ANALYZER_MANU=2;

    public static void main1(String[] args) {
        //这个是对一个doc进行索引
    	indexADoc();
    }

    public static void main(String[] args) {
        indexAllDoc();
    }



    /**
     * 对一个Doc进行index
     */
    public static void indexADoc(){
        Doc doc = DocServ.n().get(1);
        indexCreate(doc,"content");
        //更新index状态为已经索引
        //DocServ.n().updateUpdateTimeIndexStatusByDocId(System.currentTimeMillis(),1,doc.getDocId());
    }

    /**
     * 索引一个文档
     * @param doc
     */
    public static int indexADoc(Doc doc,String fieldname){
        //Doc doc = DocServ.n().get(1);
        //使用这个分词，可以切换

        if(ANALYZER_MANU==IndexAnalyzerConfig.IK){
            indexCreateByIk(doc,fieldname);
            //or
            //indexCreate(doc,fieldname);
        }else if(ANALYZER_MANU==IndexAnalyzerConfig.JCSEG){
            indexCreateByJcseg(doc,fieldname);
        }

        //正常的,
        //indexCreate(doc,fieldname);

        //以下是更新索引状态
        DocServ docServ = DocServ.n();

        Doc doc1 = docServ.get(doc.getDocId());

        String currentStatus = doc1.getIndexStatus();
        System.out.println("current status:"+currentStatus);
        Map<String,Integer> indexStatusMap =null;
        if(currentStatus!=null&&!currentStatus.equalsIgnoreCase("0")){
            indexStatusMap = JSON.parseObject(currentStatus,Map.class);
            indexStatusMap.put(fieldname,1);
        }else {
            indexStatusMap = new HashMap<>();
        }
        indexStatusMap.put(fieldname,1);
        String indexStatusJson = JSON.toJSONString(indexStatusMap);

        //更新index状态为新的索引状态
        int r1=docServ.updateUpdateTimeIndexStatusByDocId(System.currentTimeMillis(),indexStatusJson,doc.getDocId());
        //多少个fieldname 被索引
        int r2 = docServ.updateIndexStageByDocId(indexStatusMap.size(), doc.getDocId());
        return r2;
    }

    /**
     * 对所有未索引的文档进行索引
     */
    public static int indexAllDoc(){
        List<Doc> noIndexDocList = DocServ.n().findByIndexStage(0);
        int sum=0;
        for(Doc doc:noIndexDocList){
            int r1=indexADoc(doc,"title");
            int r2=indexADoc(doc,"content");
            if(r2>0) sum++;
        }
        return sum;
    }


    /**
     * 索引创建,需要创建的doc和字段名称,创建索引所用的函数
     * @param doc
     */
    public static void indexCreate(Doc doc,String fieldname) {
        //构建IK分词器，使用smart分词模式
        Analyzer analyzer = new IKAnalyzer(true, true, true);
        String fieldContentToIndex="";
        if(fieldname.equalsIgnoreCase("content")) {
            fieldContentToIndex = doc.getBody();
        }else {
            fieldContentToIndex = (String) doc.toMap().get(StringTool.humpToUnderLine(fieldname));
        }
        //获取Lucene的TokenStream对象
        TokenStream ts = null;
        try {
            System.out.println("content body:"+fieldContentToIndex);
            //ts = analyzer.tokenStream("myfield", new StringReader("123456 我是中国人 IK Analyzer是一个结合词典分词和文法分词的中文分词开源工具包。它使用了全新的正向迭代最细粒度切分算法。"));
            ts = analyzer.tokenStream("myfield", new StringReader(fieldContentToIndex));
            //获取词元位置属性
            OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
            //获取词元文本属性
            CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
            //获取词元文本属性
            TypeAttribute type = ts.addAttribute(TypeAttribute.class);
            PositionIncrementAttribute pos = ts.addAttribute(PositionIncrementAttribute.class);
            //重置TokenStream（重置StringReader）
            ts.reset();
            TokenServ tokenServ = TokenServ.n();
            //迭代获取分词结果
            while (ts.incrementToken()) {
                int len = term.toString().length();
                System.out.println("len:"+len);
                if(len<IndexConfig.TOKEN_MIN_LENGTH) continue;
                //也不能太长
                if(len>=IndexConfig.TOKEN_MAX_LENGTH) continue;
                System.out.println(offset.startOffset() + " - " + offset.endOffset() + " : " + pos.getPositionIncrement() + " | " + term.toString() + " | " + type.type());
                String token = term.toString();
                //查询是否存在
                List<Long> tokenIdList =tokenServ.findTokenIdByToken(token);
                int size = tokenIdList.size();
                PostingsServ postingsServ =PostingsServ.n();
                //已经存在
                if(size>=1){
                    long tokenId = tokenIdList.get(0);
                    Token token1 = tokenServ.get(tokenId);
                    //增加Docs字段
                    updateTokenDocs(token1,doc);
                    long docId = doc.getDocId();
                    //多一个文档引用
                    //tokenServ.n().incDocCount(tokenId,1);
                    //首先应该查询postings里面是否存在docId,和tokenId，是否已经存在；如果存在则更新位置信息，增加位置信息
                    List<Long> postingIdList = postingsServ.findPostingIdByTokenIdDocIdFieldname(tokenId,doc.getDocId(),fieldname);
                    int size1= postingIdList.size();
                    //已经存在，则更新位置信息
                    if(size1>=1){
                        long postingId = postingIdList.get(0);
                        Postings p = postingsServ.get(postingId);
                        StringBuffer positionsBuffer= new StringBuffer(p.getPositions());
                        positionsBuffer.append(",").append(offset.startOffset());
                        System.out.println("当前位置信息:"+positionsBuffer.toString());
                        //更新位置信息
                        int r=postingsServ.updatePositionsUpdateTimeByPostingId(positionsBuffer.toString(),System.currentTimeMillis(),postingId);
                        //增加频率
                        r=postingsServ.incFrequencyUpdateTimeByPostingId(1,System.currentTimeMillis(),postingId);
                        //增加频率1，增加位置信息
                        if(r>0){
                            System.out.println("更新位置信息成功");
                        }else {
                            System.out.println("更新位置信息失败");
                        }
                    }//不存在，则新建位置信息
                    else{
                        System.out.println("待入库位置信息:"+term.toString()+" offset:"+offset.startOffset());
                        Postings postings = getPostings(doc,token1,offset,fieldname);
                        //位置信息放进去
                        postingsServ.saveAutoId(postings);
                    }
                }
                //不存在
                else {
                	//新建立一个token
                    Token token1 = getToken(doc,token);
                    //保存token
                    int returnId=tokenServ.saveAutoReturnId(token1);
                    token1.setTokenId(returnId);
                    Postings postings = getPostings(doc,token1,offset,fieldname);
                    //再保存到posting表格中去,保存位置信息
                    postingsServ.saveAutoId(postings);
                }
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

    public static void indexCreateByIk(Doc doc,String fieldname){
        Analyzer analyzer = new IKAnalyzer(true, true, true);
        String fieldContentToIndex="";
        indexCreateByAnalyzer(analyzer,doc,fieldname);
    }

    public static void indexCreateByJcseg(Doc doc,String fieldname){
        Analyzer analyzer = new JcsegAnalyzer4X(JcsegTaskConfig.SIMPLE_MODE);
        //非必须(用于修改默认配置): 获取分词任务配置实例
        JcsegAnalyzer4X jcseg = (JcsegAnalyzer4X) analyzer;
        JcsegTaskConfig config = jcseg.getTaskConfig();
        //追加同义词到分词结果中, 需要在jcseg.properties中配置jcseg.loadsyn=1
        config.setAppendCJKSyn(true);
        //追加拼音到分词结果中, 需要在jcseg.properties中配置jcseg.loadpinyin=1
        config.setAppendCJKPinyin(true);
        indexCreateByAnalyzer(analyzer,doc,fieldname);
    }


    /**
     * 索引创建,需要创建的doc和字段名称,创建索引所用的函数
     * @param doc
     */
    public static void indexCreateByAnalyzer(Analyzer analyzer,Doc doc,String fieldname) {
        //构建IK分词器，使用smart分词模式
        //Analyzer analyzer = new IKAnalyzer(true, true, true);
        String fieldContentToIndex="";
        if(fieldname.equalsIgnoreCase("content")) {
            //fieldContentToIndex = doc.getBody();
            fieldContentToIndex = Jsoup.parse(doc.getBody()).text();
        }else {
            fieldContentToIndex = (String) doc.toMap().get(StringTool.humpToUnderLine(fieldname));
        }
        //获取Lucene的TokenStream对象
        TokenStream ts = null;
        try {
            System.out.println("content body:"+fieldContentToIndex);
            //ts = analyzer.tokenStream("myfield", new StringReader("123456 我是中国人 IK Analyzer是一个结合词典分词和文法分词的中文分词开源工具包。它使用了全新的正向迭代最细粒度切分算法。"));
            ts = analyzer.tokenStream("myfield", new StringReader(fieldContentToIndex));
            //获取词元位置属性
            OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
            //获取词元文本属性
            CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
            //获取词元文本属性
            TypeAttribute type = ts.addAttribute(TypeAttribute.class);
            PositionIncrementAttribute pos = ts.addAttribute(PositionIncrementAttribute.class);
            //重置TokenStream（重置StringReader）
            ts.reset();
            TokenServ tokenServ = TokenServ.n();
            //迭代获取分词结果
            while (ts.incrementToken()) {
                //还要去掉空格
                int len = term.toString().trim().length();
                System.out.println("len:"+len);
                if(len<IndexConfig.TOKEN_MIN_LENGTH) continue;
                //也不能太长
                if(len>=IndexConfig.TOKEN_MAX_LENGTH) continue;
                System.out.println(offset.startOffset() + " - " + offset.endOffset() + " : " + pos.getPositionIncrement() + " | " + term.toString() + " | " + type.type());
                String token = term.toString();
                //查询是否存在
                List<Long> tokenIdList =tokenServ.findTokenIdByToken(token);
                int size = tokenIdList.size();
                PostingsServ postingsServ =PostingsServ.n();
                //已经存在
                if(size>=1){
                    long tokenId = tokenIdList.get(0);
                    Token token1 = tokenServ.get(tokenId);
                    //增加Docs字段
                    updateTokenDocs(token1,doc);
                    long docId = doc.getDocId();
                    //多一个文档引用
                    //tokenServ.n().incDocCount(tokenId,1);
                    //首先应该查询postings里面是否存在docId,和tokenId，是否已经存在；如果存在则更新位置信息，增加位置信息
                    List<Long> postingIdList = postingsServ.findPostingIdByTokenIdDocIdFieldname(tokenId,doc.getDocId(),fieldname);
                    int size1= postingIdList.size();
                    //已经存在，则更新位置信息
                    if(size1>=1){
                        long postingId = postingIdList.get(0);
                        Postings p = postingsServ.get(postingId);
                        StringBuffer positionsBuffer= new StringBuffer(p.getPositions());
                        positionsBuffer.append(",").append(offset.startOffset());
                        System.out.println("当前位置信息:"+positionsBuffer.toString());
                        //更新位置信息
                        int r=postingsServ.updatePositionsUpdateTimeByPostingId(positionsBuffer.toString(),System.currentTimeMillis(),postingId);
                        //增加频率
                        r=postingsServ.incFrequencyUpdateTimeByPostingId(1,System.currentTimeMillis(),postingId);
                        //增加频率1，增加位置信息
                        if(r>0){
                            System.out.println("更新位置信息成功");
                        }else {
                            System.out.println("更新位置信息失败");
                        }
                    }//不存在，则新建位置信息
                    else{
                        System.out.println("待入库位置信息:"+term.toString()+" offset:"+offset.startOffset());
                        Postings postings = getPostings(doc,token1,offset,fieldname);
                        //位置信息放进去
                        postingsServ.saveAutoId(postings);
                    }
                }
                //不存在
                else {
                    //新建立一个token
                    Token token1 = getToken(doc,token);
                    //保存token
                    int returnId=tokenServ.saveAutoReturnId(token1);
                    token1.setTokenId(returnId);
                    Postings postings = getPostings(doc,token1,offset,fieldname);
                    //再保存到posting表格中去,保存位置信息
                    postingsServ.saveAutoId(postings);
                }
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

    public static void updateTokenDocs(Token token1,Doc doc){
        //查看 token表中是否包含了 docId
        String docs = token1.getDocs();
        if(docs==null||docs.length()==0){
            TokenServ.n().updateDocCountDocs(1,Long.toString(doc.getDocId()),token1.getTokenId());
            return;
        }
        System.out.println("文档集:"+docs);
        String[] docArray = docs.split("\\,");
        int arrayLen = docArray.length;
        boolean existDocId=false;
        int docCount = arrayLen;
        if(arrayLen>0) {
            for (int i = 0; i < arrayLen; i++) {
                String docIdStr = docArray[i];
                System.out.println("文档集 条目:"+docIdStr);
                if(!docIdStr.equalsIgnoreCase("")){
                    if (doc.getDocId() == Integer.parseInt(docIdStr)) existDocId = true;
                }
            }
        }
        if(!existDocId){
            docCount = arrayLen+1;
            //需要增加
            StringBuffer sb = new StringBuffer();
            if(docs.length()>0){
                sb.append(docs).append(",").append(doc.getDocId());
            }else {
                sb.append(doc.getDocId());
            }
            //更新token 条目的 docs，并且使docCount+1;
            int r=TokenServ.n().updateDocCountDocs(docCount,sb.toString(),token1.getTokenId());
            if(r>1) {
                System.out.println("更新关键词 token 文档集 成功");
            }
        }
    }

    public static Token getToken(Doc doc,String token){
        Token token1= new Token();
        token1.setToken(token);
        token1.setTokenSize(token.length());
        //第一次保存所以为0
        token1.setDocCount(1);
        String docs = Long.toString(doc.getDocId());
        token1.setDocs(docs);
        return  token1;
    }


    public static Postings getPostings(Doc doc,Token token,OffsetAttribute offset,String fieldname){
        Postings postings = new Postings();
        StringBuffer sb = new StringBuffer();
        sb.append(offset.startOffset());

        postings.setCreateTime(System.currentTimeMillis());
        postings.setUpdateTime(System.currentTimeMillis());
        postings.setDbname(doc.getDbname());
        postings.setTablename(doc.getTablename());
        postings.setToken(token.getToken());
        postings.setTokenId(token.getTokenId());
        postings.setDocId(doc.getDocId());
        postings.setFrequency(1);
        postings.setTokenSize(token.getToken().length());
        postings.setFieldname(fieldname);
        //位置信息放进去
        postings.setPositions(sb.toString());
        return postings;
    }


}
