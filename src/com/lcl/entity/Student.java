package com.lcl.entity;

public class Student {
	
	private String no;	//学号
	private String name;	//姓名
	private Integer grade;	//年纪
	private String arrangement;	//层次
	private String professional;	//专业名称
	private String gender;	//性别
	private String classNo;	//班级
	private String password;	//密码
	private String mailbox;		//邮箱
	private String subject_background;	//学科背景
	private String learningExperience;	//学习经历
	private String researchDirection;	//研究方向
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getArrangement() {
		return arrangement;
	}
	public void setArrangement(String arrangement) {
		this.arrangement = arrangement;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getclassNo() {
		return classNo;
	}
	public void setclassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	public String getSubject_background() {
		return subject_background;
	}
	public void setSubject_background(String subject_background) {
		this.subject_background = subject_background;
	}
	public String getLearningExperience() {
		return learningExperience;
	}
	public void setLearningExperience(String learningExperience) {
		this.learningExperience = learningExperience;
	}
	public String getResearchDirection() {
		return researchDirection;
	}
	public void setResearchDirection(String researchDirection) {
		this.researchDirection = researchDirection;
	}
	public Student(String no, String name, int grade, String arrangement, String professional, String gender,
			String classNo, String password, String mailbox, String subject_background, String learningExperience,
			String researchDirection) {
		super();
		this.no = no;
		this.name = name;
		this.grade = grade;
		this.arrangement = arrangement;
		this.professional = professional;
		this.gender = gender;
		this.classNo = classNo;
		this.password = password;
		this.mailbox = mailbox;
		this.subject_background = subject_background;
		this.learningExperience = learningExperience;
		this.researchDirection = researchDirection;
	}
	public Student() {
	}
	public Student(String mailbox) {
		this.mailbox=mailbox;
	}
	public Student(String no, String name, Integer grade, String professional, String gender, String classNo) {
		super();
		this.no = no;
		this.name = name;
		this.grade = grade;
		this.professional = professional;
		this.gender = gender;
		this.classNo = classNo;
	}
	public Student(String no, String password) {
		super();
		this.no = no;
		this.password = password;
	}
	
}
