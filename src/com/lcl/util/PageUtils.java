package com.lcl.util;

public class PageUtils {
	private int currentPage;//当前页数
	private int pageSize;//每页显示条数
	private int totalPage;//总页码
	private int totalSize;//记录条数
	@SuppressWarnings("unused")
	private boolean hasFirst;//是否有首页
	@SuppressWarnings("unused")
	private boolean hasPre;//是否有上一页
	@SuppressWarnings("unused")
	private boolean hasNext;//是否有下一页
	@SuppressWarnings("unused")
	private boolean hasLast;//是否有尾页
	
	//利用构造方法为变量赋值
	public PageUtils(int currentPage, int totalSize){
	this.currentPage=currentPage;
	this.totalSize=totalSize;
	}
	
	//当前页码
	public int getcurrentPage() {
		return currentPage;
	}
	public void setcurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	//一页最多显示记录数
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	//一共多少页
	public int getTotalPage() {
		if (getTotalSize() < getPageSize()) {
			return 1;
		}
		else {
			totalPage=getTotalSize()/getPageSize();
			 if(totalSize%pageSize!=0){
				 totalPage++;
			 }
			 return totalPage;
		}
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	

	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	
	//如果当前为第一页，就没有首页。
	public boolean isHasFirst() {
		if(this.currentPage==1)
			return false;
		else
			return true;
	}
	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}
	
	//如果有首页，就有前一页。
	public boolean isHasPre() {
		if(this.isHasFirst())
			return true;
		else 
			return false;
	}
	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}
	
	//如果有尾页，就有下一页。
	public boolean isHasNext() {
		if(this.isHasLast())
			return true;
		else
			return false;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	
	//如果不是最后一页，就有尾页。
	public boolean isHasLast() {
		 if(currentPage==this.getTotalPage())
			 return false;
		 else 
			 return true;
	}
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}

	public PageUtils(int currentPage, int pageSize, int totalSize) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
	}

}
