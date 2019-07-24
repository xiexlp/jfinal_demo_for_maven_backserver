package com.js.common.util;

import java.util.ArrayList;
import java.util.List;


public class PageList<E> extends ArrayList<E>{
	//页面大小，默认为20
	int pageSize=20;
	//当前页
	int pageNo;
	//总条目数
	int total;
	//总页数
	int pageTotal;
	
	int offset;

	String actionUrl;
	List<Integer> pageNoList;

	public PageList(){
		this.pageNo= 1;
	}
	
	public PageList(int pageNo){
		this.pageNo= pageNo;
	}
	
	public PageList(int pageNo2, int total2) {
		this.pageNo = pageNo2;
		setTotal(total2);
		// TODO Auto-generated constructor stub
	}

	public PageList(int pageNo2,int total2,int pageSize2){
		this.pageNo = pageNo2;
		this.pageSize = pageSize2;
		setTotal(total2);
	}

	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPageNo() {
		return this.pageNo;
	}
	
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
		setTotalPage();
		setOffset();
	}
	
	public int getPageTotal() {
		return pageTotal;
	}
	
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	
	public int getOffset() {
		return offset;
	}

	public void setOffset() {
		this.offset = (pageNo-1)*pageSize;
	}
	
	/**
	 * 计算总的页数
	 * @return
	 */
	public Integer setTotalPage(){
		this.pageTotal =MathUtils.upperInteger(total,pageSize);
		return this.pageTotal;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	public List<Integer> getPageNoList() {
		return pageNoList;
	}

	public void setPageNoList(List<Integer> pageNoList) {
		this.pageNoList = pageNoList;
	}

	//setTotalPageNumber();
	
	
	
	

}
