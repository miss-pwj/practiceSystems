package com.lcl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lcl.dao.StudentDao;
import com.lcl.entity.Student;
import com.lcl.util.DBUtil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public boolean studentLogin(Student student) {
		String sql="select * from student where No=? and password=?";
		Object[] params = {student.getNo(),student.getPassword()}; 
		ResultSet rs =null;
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
	public boolean isMailExist(Student student) {
		String sql="select *from student where mailbox=?";
		Object[] params = {student.getMailbox()};
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
		String sql="update student set password =? where mailbox=? ";
		Object[] params = {pwd,mail};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public String querryPwd(String No) {
		String sql = "select password from student where No =?";
		Object[] params = {No};
		ResultSet rs =null;
		String pwd="";
		try {
			rs=DBUtil.executeQuerry(sql, params);
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
	public boolean updatePwd(Student student) {
		String sql ="update student set password=? where No=?";
		Object[] params={student.getNo(),student.getPassword()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public Student querryStudentByNo(String no) {
		String sql = "select * from student where No = ?";
		Object[] params={no};
		ResultSet rs = null;
		Student student=null;
		try {
			rs=DBUtil.executeQuerry(sql, params);
			if(rs.next()){
				String stuNo = rs.getString(1);
				String name = rs.getString(2);
				int grade = rs.getInt(3);
				String professional = rs.getString(5);
				String gender = rs.getString(6);
				String stuClass = rs.getString(7);
				 student = new Student(stuNo,name,grade,professional,gender,stuClass);
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<String> querryPlan(String uname) {
		String sql="select projectNo from project_select where studentNo=?";
		Object[] params={uname};
		ResultSet rs=null;
		List<String> list=new ArrayList<>();
		try {
			rs=DBUtil.executeQuerry(sql, params);
			while(rs.next()){
				String str = rs.getString(1);
				System.out.println("数据库："+str);
				list.add(str);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		/*ResultSet res = null;
		List<String> names =new ArrayList<>();
		for(String li:list){
			try {
			String sql2="select name from project where No=?";
			Object[] params2={li};
			res=DBUtil.executeQuerry(sql2, params2);
				if(res.next()){
					String name = res.getString(1);
					names.add(name);
				}
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return names;*/
	}


}
