package com.lcl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.lcl.dao.CompanyDao;
import com.lcl.entity.Company;
import com.lcl.entity.Mailbox_Verification;
import com.lcl.util.DBUtil;


public class CompanyDaoImpl implements CompanyDao{

	@Override
	public boolean addMail(Mailbox_Verification mv) {	//增加邮箱
		String sql ="insert into mailbox_verification(mailbox,type,verification_code) values(?,?,?)";
		Object[] params={mv.getMailbox(),mv.getType(),mv.getVerificationCode()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public boolean deleteMail(Mailbox_Verification mv) {
		String sql="delete mailbox_verification where mailbox = ?";
		Object[] params={mv.getMailbox()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public String selectInviteCode() throws ClassNotFoundException, SQLException {
		String sql ="select invitation_code from  system_parameter";
		ResultSet rs =DBUtil.executeQuerry(sql, null);
		String str="";
		if(rs.next()){
			str=rs.getString(1);
		}
		rs.close();
		return str;
	}

	@Override
	public boolean addCompony(Company com) {
		String sql="insert into company(username,company_name,mailbox,password) values(?,?,?,?)";
		Object[] params={com.getUsername(),com.getCompany_name(),com.getMailbox(),com.getPassword()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public boolean companyLogin(Company com) {
		String sql="select * from  company where username=? and password=?";
		Object[] params={com.getUsername(),com.getPassword()};
		ResultSet rs=null;
		try {
			rs=DBUtil.executeQuerry(sql, params);
			if(rs.next()){
				return true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isMailExist(Company com) {
		String sql="select *from company where mailbox=?";
		Object[] params = {com.getMailbox()};
		ResultSet rs = null;
		try {
			rs = DBUtil.executeQuerry(sql, params);
			if(rs.next()){
				return true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changePwdByMail(String pwd,String mail) {
		String sql="update company set password =? where mailbox=? ";
		Object[] params = {pwd,mail};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public String querryPwd(String username) {
		String sql="select password from company where username=?";
		Object[] params={username};
		ResultSet rs = null;
		String pwd="";
		try {
			rs = DBUtil.executeQuerry(sql, params);
			if(rs.next()){
				pwd = rs.getString(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pwd;
	}

	@Override
	public boolean updatePwd(Company company) {
		String sql="update company set password=? where username=?";
		Object[] params={company.getPassword(),company.getUsername()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public boolean isMailExistInMailbox_Verification(String mail) {
		String sql="select * from mailbox_verification where mailbox=?";
		Object[] params={mail};
		ResultSet rs = null;
			try {
				rs=DBUtil.executeQuerry(sql, params);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return rs!=null;
	}

}
