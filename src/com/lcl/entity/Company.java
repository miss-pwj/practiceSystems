package com.lcl.entity;

public class Company {
	private String username;	//用户名
	private String company_name;//企业名称
	private String mailbox;    //邮箱
	private String password;	//密码
	private String contacts;	//联系人
	private String phone;	//电话
	private String address; //公司地址
	private String profile;	//公司简介
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public Company() {
		super();
	}
	public Company(String username, String company_name, String mailbox, String password, String contacts, String phone,
			String address, String profile) {
		this.username = username;
		this.company_name = company_name;
		this.mailbox = mailbox;
		this.password = password;
		this.contacts = contacts;
		this.phone = phone;
		this.address = address;
		this.profile = profile;
	}
	public Company(String username,String password) {
		this.username = username;
		this.password = password;
	}
	
	public Company(String mailbox) {
		this.mailbox = mailbox;
	}
	public Company(String username, String company_name, String mailbox, String password) {
		this.username = username;
		this.company_name = company_name;
		this.mailbox = mailbox;
		this.password = password;
	}
	
}
