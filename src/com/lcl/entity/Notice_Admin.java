package com.lcl.entity;

import java.util.Date;

public class Notice_Admin {//通知公告_管理员表
	private String title;	//标题
	private Integer id;		//ID
	private Date releaseDate;//发布日期
	private String content;//内容
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
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Notice_Admin(String title, Integer id, Date releaseDate, String content) {
		super();
		this.title = title;
		this.id = id;
		this.releaseDate = releaseDate;
		this.content = content;
	}
	public Notice_Admin() {
		super();
	}
	
}
