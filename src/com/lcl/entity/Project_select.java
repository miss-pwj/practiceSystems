package com.lcl.entity;

import java.util.Date;

public class Project_select {		//方案选择
	private String studentNo; //学号
	private String projectNo;	//方案号
	private String selReason;	//选题理由
	private Date companySelDate;//企业选择日
	private String score;	//成绩
	private String companyName;	//企业名称
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getSelReason() {
		return selReason;
	}
	public void setSelReason(String selReason) {
		this.selReason = selReason;
	}
	public Date getCompanySelDate() {
		return companySelDate;
	}
	public void setCompanySelDate(Date companySelDate) {
		this.companySelDate = companySelDate;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Project_select(String studentNo, String projectNo, String selReason, Date companySelDate, String score,
			String companyName) {
		super();
		this.studentNo = studentNo;
		this.projectNo = projectNo;
		this.selReason = selReason;
		this.companySelDate = companySelDate;
		this.score = score;
		this.companyName = companyName;
	}
	public Project_select() {
		super();
	}
	public Project_select(String studentNo, String projectNo, String selReason,String companyName) {
		super();
		this.studentNo = studentNo;
		this.projectNo = projectNo;
		this.selReason = selReason;
		this.companyName=companyName;
	}
	public Project_select(String studentNo, String projectNo) {
		this.studentNo = studentNo;
		this.projectNo = projectNo;
	}
	public Project_select(String studentNo) {
		this.studentNo = studentNo;
	}
	public Project_select(String studentNo, String projectNo, String selReason) {
		super();
		this.studentNo = studentNo;
		this.projectNo = projectNo;
		this.selReason = selReason;
	}
	public Project_select(String studentNo, String projectNo, Date companySelDate, String companyName) {
		super();
		this.studentNo = studentNo;
		this.projectNo = projectNo;
		this.companySelDate = companySelDate;
		this.companyName = companyName;
	}
	public Project_select(String studentNo, String projectNo, String selReason, Date companySelDate) {
		super();
		this.studentNo = studentNo;
		this.projectNo = projectNo;
		this.selReason = selReason;
		this.companySelDate = companySelDate;
	}
	
}