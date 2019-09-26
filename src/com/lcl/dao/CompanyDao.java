package com.lcl.dao;

import java.sql.SQLException;

import com.lcl.entity.Company;
import com.lcl.entity.Mailbox_Verification;

public interface CompanyDao {
	//增加邮箱
	public boolean addMail(Mailbox_Verification mv);	
	//删除
	public boolean deleteMail(Mailbox_Verification mv);
	//查询邀请码
	public String selectInviteCode() throws ClassNotFoundException, SQLException;
	//增加注册的公司
	public boolean addCompony(Company com);
	
	//查询用户登录
	public boolean companyLogin(Company com);
	//查询邮箱是否存在
	public boolean isMailExist(Company com);
	//通过邮箱改密码
	public boolean changePwdByMail(String pwd,String mail);
	//通过用户名去查找密码
	public String querryPwd(String username);
	//通过用户名修改密码
	public boolean updatePwd(Company company);
	//查询Mailbox_Verification是否已经存在邮箱
	public boolean isMailExistInMailbox_Verification(String mail);
}
