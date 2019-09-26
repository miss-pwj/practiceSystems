package com.lcl.service.impl;
import java.sql.SQLException;

import com.lcl.dao.CompanyDao;
import com.lcl.dao.impl.CompanyDaoImpl;
import com.lcl.entity.Company;
import com.lcl.entity.Mailbox_Verification;
import com.lcl.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {
	CompanyDao mvd = new CompanyDaoImpl();

	@Override
	public boolean addMailtoDB(Mailbox_Verification mv) {
		return mvd.addMail(mv);
	}

	@Override
	public boolean deleteMailfromDB(Mailbox_Verification mv) {
		return mvd.deleteMail(mv);
	}

	@Override
	public String selectInviteCode() {
		String str="";
		try {
			 str=mvd.selectInviteCode();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	@Override
	public boolean addCompony(Company com) {
		
		return mvd.addCompony(com);
	}

	@Override
	public boolean companyLogin(Company com) {
		
		return mvd.companyLogin(com);
	}

	@Override
	public boolean isMailExist(Company com) {
		
		return mvd.isMailExist(com);
	}

	@Override
	public boolean changePwdByMail(String pwd,String mail) {
		// TODO Auto-generated method stub
		return mvd.changePwdByMail(pwd,mail);
	}

	@Override
	public boolean checkIsPwdSame(String username, String pwd) {
		// TODO Auto-generated method stub
		String oldPwd = mvd.querryPwd(username);
		if(oldPwd.equals(pwd)){
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePwd(Company company) {
		
		return mvd.updatePwd(company);
	}

	@Override
	public boolean isMailExistInMailbox_Verification(String mail) {
		// TODO Auto-generated method stub
		return mvd.isMailExistInMailbox_Verification(mail);
	}




}
