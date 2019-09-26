package com.lcl.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lcl.dao.AdminDao;
import com.lcl.entity.System_Parameter;
import com.lcl.util.DBUtil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public boolean AdminLogin(System_Parameter admin) {
		boolean b=false;
		String sql="select * from system_parameter where admin_username=? and admin_password=?";
		Object[] params = {admin.getAdminUsername(),admin.getAdminPassword()};
		ResultSet rs = null;
		System.out.println(b+"1");
		try {
			rs = DBUtil.executeQuerry(sql, params);
			if(rs.next()){
				b= true;
				System.out.println(b+"2");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public boolean setTimeStartEnd(System_Parameter admin) {
		String sql="update system_parameter set release_project_start_date=?,release_project_end_date=?,student_sel_start_date=?,student_sel_end_date=? where admin_username=?";
		Object[] params={admin.getReleaseProjectStartDate(),admin.getReleaseProjectEndDate(),admin.getStudentSelStartDate(),admin.getStudentSelEndDate(),admin.getAdminUsername()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public System_Parameter querryDate(String uname) {
		String sql ="select release_project_start_date,release_project_end_date,student_sel_start_date,student_sel_end_date from system_parameter where admin_username=?";
		Object[] params={uname};
		ResultSet rs = null;
		System_Parameter sp=null;
		try {
			rs=DBUtil.executeQuerry(sql, params);
			if(rs.next()){
				Date release_project_start_date = rs.getDate(1);
				Date release_project_end_date = rs.getDate(2);
				Date student_sel_start_date = rs.getDate(3);
				Date student_sel_end_date = rs.getDate(4);
				 sp  = new System_Parameter(release_project_start_date,release_project_end_date,student_sel_start_date,student_sel_end_date);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sp;
	}
	

}
