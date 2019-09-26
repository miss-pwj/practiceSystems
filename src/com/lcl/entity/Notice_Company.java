package com.lcl.entity;

import java.util.Date;

public class Notice_Company {
	private String title;	//标题
	private Integer id;	//ID
	private String companyUsername;//企业用户名
	private Date releaseDate;	//发布日期
	private Date auditDate;		//审核日期
	private String content;		//内容
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompanyUsername() {
		return companyUsername;
	}
	public void setCompanyUsername(String companyUsername) {
		this.companyUsername = companyUsername;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Notice_Company(String title, Integer id, String companyUsername, Date releaseDate, Date auditDate,
			String content) {
		super();
		this.title = title;
		this.id = id;
		this.companyUsername = companyUsername;
		this.releaseDate = releaseDate;
		this.auditDate = auditDate;
		this.content = content;
	}
	public Notice_Company() {
		super();
	}
	
}
