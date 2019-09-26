package com.lcl.entity;

import java.io.Serializable;

public class Mailbox_Verification implements Serializable{	//邮箱验证
	private static final long serialVersionUID = 1L;
	private String mailbox;
	private Integer type;
	private String verificationCode;
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Mailbox_Verification() {
		super();
	}
	public Mailbox_Verification(String mailbox, Integer type, String verificationCode) {
		super();
		this.mailbox = mailbox;
		this.type = type;
		this.verificationCode = verificationCode;
	}
}
