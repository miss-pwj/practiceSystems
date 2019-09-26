package com.lcl.entity;

import java.util.Date;

public class Project {
	private String no;			//方案号
	private String name;		//方案名称
	private String introduction;//方案简介
	private Integer studentsNum;//学生人数
	private String companyUsername;//企业用户名
	private String companyTeacher;//校外指导老师
	private String companyTeacherTitle;//校外指导老师职称
	private Date releaseDate;//发布日期
	private Date auditDate;//审核日期
	private Date endDate;//结束日期
	private String summary;//方案总结
	private int grade;//年纪
	private String category;//类别
	private String major;	//使用专业
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Integer getStudentsNum() {
		return studentsNum;
	}
	public void setStudentsNum(Integer studentsNum) {
		this.studentsNum = studentsNum;
	}
	public String getCompanyUsername() {
		return companyUsername;
	}
	public void setCompanyUsername(String companyUsername) {
		this.companyUsername = companyUsername;
	}
	public String getCompanyTeacher() {
		return companyTeacher;
	}
	public void setCompanyTeacher(String companyTeacher) {
		this.companyTeacher = companyTeacher;
	}
	public String getCompanyTeacherTitle() {
		return companyTeacherTitle;
	}
	public void setCompanyTeacherTitle(String companyTeacherTitle) {
		this.companyTeacherTitle = companyTeacherTitle;
	}
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
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
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Project() {
		super();
	}
	public Project(String no, String name, String introduction, Integer studentsNum, String companyUsername,
			String companyTeacher, String companyTeacherTitle, Date releaseDate, Date auditDate, Date endDate,
			String summary, int grade, String category, String major) {
		super();
		this.no = no;
		this.name = name;
		this.introduction = introduction;
		this.studentsNum = studentsNum;
		this.companyUsername = companyUsername;
		this.companyTeacher = companyTeacher;
		this.companyTeacherTitle = companyTeacherTitle;
		this.releaseDate = releaseDate;
		this.auditDate = auditDate;
		this.endDate = endDate;
		this.summary = summary;
		this.grade = grade;
		this.category = category;
		this.major = major;
	}
	public Project(String no, String name, String introduction, Integer studentsNum, String companyUsername,
			String companyTeacher, String companyTeacherTitle, Date releaseDate, int grade, String category,
			String major) {
		super();
		this.no = no;
		this.name = name;
		this.introduction = introduction;
		this.studentsNum = studentsNum;
		this.companyUsername = companyUsername;
		this.companyTeacher = companyTeacher;
		this.companyTeacherTitle = companyTeacherTitle;
		this.releaseDate = releaseDate;
		this.grade = grade;
		this.category = category;
		this.major = major;
	}
	public Project(String no, Date auditDate) {
		super();
		this.no = no;
		this.auditDate = auditDate;
	}
	
}
