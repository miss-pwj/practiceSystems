package com.lcl.entity;

public class Professional {
	private String professional;	//专业名称
	private Integer orderno;	//序号
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	public Integer getOrderno() {
		return orderno;
	}
	public void setOrderno(Integer orderno) {
		this.orderno = orderno;
	}
	public Professional(String professional, Integer orderno) {
		super();
		this.professional = professional;
		this.orderno = orderno;
	}
	public Professional() {
		super();
	}
	
}
