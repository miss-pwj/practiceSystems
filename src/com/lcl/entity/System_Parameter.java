package com.lcl.entity;

import java.sql.Date;

public class System_Parameter {	//系统参数表
	private String adminUsername;	//管理员用户名
	private String adminPassword;	//管理密码
	private String invitationCode;	//邀请码
	private Date releaseProjectStartDate;//企业发布方案开始日期
	private Date releaseProjectEndDate;//企业发布方案截止日期
	private Date studentSelStartDate;	//学生选择方案开始日期
	private Date studentSelEndDate;		//学生选择方案截止日期
	private Integer studentSelMaxnum;		//学生最多待选方案数量
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getInvitationCode() {
		return invitationCode;
	}
	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
	public Date getReleaseProjectStartDate() {
		return releaseProjectStartDate;
	}
	public void setReleaseProjectStartDate(Date releaseProjectStartDate) {
		this.releaseProjectStartDate = releaseProjectStartDate;
	}
	public Date getReleaseProjectEndDate() {
		return releaseProjectEndDate;
	}
	public void setReleaseProjectEndDate(Date releaseProjectEndDate) {
		this.releaseProjectEndDate = releaseProjectEndDate;
	}
	public Date getStudentSelStartDate() {
		return studentSelStartDate;
	}
	public void setStudentSelStartDate(Date studentSelStartDate) {
		this.studentSelStartDate = studentSelStartDate;
	}
	public Date getStudentSelEndDate() {
		return studentSelEndDate;
	}
	public void setStudentSelEndDate(Date studentSelEndDate) {
		this.studentSelEndDate = studentSelEndDate;
	}
	public int getStudentSelMaxnum() {
		return studentSelMaxnum;
	}
	public void setStudentSelMaxnum(int studentSelMaxnum) {
		this.studentSelMaxnum = studentSelMaxnum;
	}
	public System_Parameter(String adminUsername, String adminPassword, String invitationCode,
			Date releaseProjectStartDate, Date releaseProjectEndDate, Date studentSelStartDate, Date studentSelEndDate,
			int studentSelMaxnum) {
		super();
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
		this.invitationCode = invitationCode;
		this.releaseProjectStartDate = releaseProjectStartDate;
		this.releaseProjectEndDate = releaseProjectEndDate;
		this.studentSelStartDate = studentSelStartDate;
		this.studentSelEndDate = studentSelEndDate;
		this.studentSelMaxnum = studentSelMaxnum;
	}
	public System_Parameter() {
		super();
	}
	public System_Parameter(String adminUsername, Date releaseProjectStartDate, Date releaseProjectEndDate,
			Date studentSelStartDate, Date studentSelEndDate) {
		super();
		this.adminUsername = adminUsername;
		this.releaseProjectStartDate = releaseProjectStartDate;
		this.releaseProjectEndDate = releaseProjectEndDate;
		this.studentSelStartDate = studentSelStartDate;
		this.studentSelEndDate = studentSelEndDate;
	}
	public System_Parameter(Date releaseProjectStartDate, Date releaseProjectEndDate, Date studentSelStartDate,
			Date studentSelEndDate) {
		super();
		this.releaseProjectStartDate = releaseProjectStartDate;
		this.releaseProjectEndDate = releaseProjectEndDate;
		this.studentSelStartDate = studentSelStartDate;
		this.studentSelEndDate = studentSelEndDate;
	}
	public System_Parameter(String adminUsername, String adminPassword) {
		super();
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}
	
}
