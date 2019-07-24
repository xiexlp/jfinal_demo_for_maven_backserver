package com.js.isearch.index;


import java.util.ArrayList;
import java.util.List;

public class FastLex {

    String sourcecode;
    String info;
    
    int index;
    Character lookahead=null;
    String word=null;
    int col=0;
    List<String> wordList=new ArrayList<>();

    public String getSourcecode() {
        return sourcecode;
    }

    public void setSourcecode(String sourcecode) {
        this.sourcecode = sourcecode;
    }

    public List<String> getWordList() {
        return wordList;
    }

    public void setWordList(List<String> wordList) {
        this.wordList = wordList;
    }

    public static void main(String[] args) {

        FastLex fastLex = new FastLex();
        String sourcecode = "中国 人民 redis";
        fastLex.setSourcecode(sourcecode);
        fastLex.lex();
        List<String> list =fastLex.getWordList();
        for(String w:list){
            System.out.println("分析出来的:"+w);
        }
    }
    
    public boolean isalpha(char ch){
        return Character.isAlphabetic(ch);
    }

    public boolean isdigit(char ch){
        return Character.isDigit(ch);
    }
    
    public void alpha(){
        int i=1,flag;
        Character ch;
        if(lookahead==null) return;
        ch= lookahead;
        //word[0]=ch;
        word+=ch;
        ch=getchar();
        if(ch==null) return;
        //如果是字母还是数字的话，继续读取
        while ((ch!=null)&&(isalpha(ch)||isdigit(ch))){
            if(ch==' '||ch=='\t'||Character.isWhitespace(ch)){
                System.out.println("空字符");
                continue;
            }
            else{
                word += ch;
                ch = getchar();
            }
        }
        //ungetc(ch,stdin);
        ungetc();
        //是否是关键字
        flag=0;
        System.out.println("word:"+word);
        wordList.add(word);
    }
    
    public  void initialize(){
        word ="";
    }

    public void digit(){
        int i=1,flag;
        Character ch;
        ch=lookahead;
        word+=ch;
        System.out.println("digit word:"+word);
        ch= getchar();
        if(ch==null){
            return;
        }
        while (isalpha(ch)||isdigit(ch)){
            word+=ch;
            ch= getchar();
        }
        ungetc();
        flag=0;
        System.out.println("word:"+word+" len:"+word.length());
        int l=word.length();
        for(i=0;i<l;i++){
            //说明不是数字
            if(word.charAt(i)<'0'||word.charAt(i)>'9')
                flag=1;
        }

        System.out.println("number:"+word);
        wordList.add(word);
    }
	
	 /***
     * 词法分析过程
     */
    public void lex(){
        int len = sourcecode.length();
        System.out.println("源文总长度:"+len);
        info= sourcecode;
        //appendInfo();
        while (true){
            lookahead=getchar();
            if(lookahead==null) {
                System.out.println("已经分析结束");
                break;
            }
            if(isalpha(lookahead)){
                alpha();
                initialize();
            } else if(isdigit(lookahead)){
                digit();
                initialize();
            } else if(lookahead=='\t'||lookahead==' '){
                continue;
            } else if(lookahead=='\n')
                continue;
            //进入注释
            else if(lookahead=='/') {
                lookahead = getchar();
                //多行注释
                if (lookahead == '*') {
                    initialize();
                }//单行注释
                else {
                    ungetc();
   
                    initialize();
                }
            }else if(lookahead=='"'){
            	String double_quota="\"";
            } else if(lookahead=='.'){
                String dot=".";
                initialize();
            }else{
                initialize();
            }
        }
    }
    
    
    /**
     * 如果是空格就跳过去，继续读，不计入终结符
     * @return
     */
    public Character getchar(){
        int len = sourcecode.length();
        
        if(index>=len){
            System.out.println("已经扫描到尾部,返回为空");
            //state = TextState.STATE_END;
            return null;
        }
        char c = sourcecode.charAt(index);
        System.out.println("当前index:"+index+" char:"+c);

        if(c=='\t'||c==' '){
        	System.out.println("空字符11");
            index++;
            col++;
            return c;
            //index++;
        }else if(c=='\n'){
            index++;
            //列号复位
            col =0;
            //col++;
            return c;
            //return getchar();
        }else if(c=='\r'){
            //linenum++;
            index++;
            col++;
            return c;
            //return getchar();
        }else {
            index++;
            col++;
            return c;
        }


        //index++;
        //return c;
    }

    public void ungetc(){
        index--;
        col--;
    }
	

}
