package com.lcl.entity;

public class Project_Category {
	private String category;	//类别
	private Integer orderno;	//序号
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(Integer orderno) {
		this.orderno = orderno;
	}
	public Project_Category(String category, Integer orderno) {
		super();
		this.category = category;
		this.orderno = orderno;
	}
	public Project_Category() {
	}
	
}
