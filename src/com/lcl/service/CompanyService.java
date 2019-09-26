package com.lcl.service;


import com.lcl.entity.Company;
import com.lcl.entity.Mailbox_Verification;

public interface CompanyService {
	//增加验证码 邮箱
	public boolean addMailtoDB(Mailbox_Verification mv);
	//删除邮箱
	public boolean deleteMailfromDB(Mailbox_Verification mv);
	
	//查询邀请码
	public String selectInviteCode();
	//增加公司
	public boolean addCompony(Company com);
	
	//查询公司登录
	public boolean companyLogin(Company com);
	//查询公司是否存在邮箱
	public boolean isMailExist(Company com);
	//通过邮箱改密码
	public boolean changePwdByMail(String pwd,String mail);
	//判断两次密码是否相同
	public boolean checkIsPwdSame(String username,String pwd);
	//根据用户名修改密码
	public boolean updatePwd(Company company);
	//判断Mailbox_Verification是否已经有邮箱
	public boolean isMailExistInMailbox_Verification(String mail);
}
