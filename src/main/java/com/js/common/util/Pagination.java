package com.js.common.util;
import java.util.List;


/**
 * 分页工具
 * 
 * @author Jasper
 * 
 */
public class Pagination {
 private int nowPage;// 当前页
 private int startPage;// 起始页
 private int endPage;// 结束页
 private int totalRecord;// 总记录数
 private int totalPage;// 总页数
 private List objects;// 根据条件查出的对象集合
 public static final int PAGESIZE = 5;// 每页显示的条数
 public static final int SHOWPAGES = 10;// 每页显示的页数
 
 
 
 public static void main(String[] args) {
	
	 Pagination pagination =new Pagination();
	 pagination.paginationTool(38, 42);
	 
	 System.out.println("start:"+pagination.getStartPage()+" end:"+pagination.getEndPage());
	 
}

 public Pagination() {

 }

 /**
  * 分页方法
  * 通过这个方法,得到两个数据——startPage和endPage
  * 页面上的页码就是根据这两个数据处理后显示
  * @param nowPage当前页
  * @param totalPage总页数
  */
 public void paginationTool(int nowPage, int totalPage) {
  this.nowPage = nowPage;
  this.totalPage = totalPage;
  /**
   * 计算startPage与endPage的值
   * 
   */
  if (this.totalPage < SHOWPAGES) {
   /** if中是总页数小于SHOWPAGES的情况 */
   this.startPage = 1;
   this.endPage = totalPage;
  } else {
   /** else中是总页数大于SHOWPAGES的情况 */
   if (this.nowPage <= SHOWPAGES / 2 + 1) {
    this.startPage = 1;
    this.endPage = SHOWPAGES;
   } else {
    this.startPage = this.nowPage - (SHOWPAGES / 2);
    this.endPage = this.nowPage + (SHOWPAGES / 2 - 1);
    if (this.endPage >= this.totalPage) {
     this.endPage = this.totalPage;
     this.startPage = this.totalPage - SHOWPAGES + 1;
    }
   }
  }
 }



 public int getNowPage() {
  return nowPage;
 }

 public void setNowPage(int nowPage) {
  this.nowPage = nowPage;
 }

 public int getTotalRecord() {
  return totalRecord;
 }

 public void setTotalRecord(int totalRecord) {
  this.totalRecord = totalRecord;
 }

 public int getTotalPage() {
  return totalPage;
 }

 public void setTotalPage(int totalPage) {
  this.totalPage = totalPage;
 }

 public List getObjects() {
  return objects;
 }

 public void setObjects(List objects) {
  this.objects = objects;
 }

 public static int getShowpages() {
  return SHOWPAGES;
 }

 public int getStartPage() {
  return startPage;
 }

 public void setStartPage(int startPage) {
  this.startPage = startPage;
 }

 public int getEndPage() {
  return endPage;
 }

 public void setEndPage(int endPage) {
  this.endPage = endPage;
 }

}