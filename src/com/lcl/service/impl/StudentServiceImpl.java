package com.lcl.service.impl;

import java.util.List;

import com.lcl.dao.StudentDao;
import com.lcl.dao.impl.StudentDaoImpl;
import com.lcl.entity.Student;
import com.lcl.service.StudentService;

public class StudentServiceImpl implements StudentService{
	StudentDao std = new StudentDaoImpl();

	@Override
	public boolean studentLogin(Student student) {
		return std.studentLogin(student);
	}

	@Override
	public boolean isMailExist(Student student) {
		return std.isMailExist(student);
	}

	@Override
	public boolean changePwdByMail(String pwd,String mail) {
		// TODO Auto-generated method stub
		return std.changePwdByMail(pwd,mail);
	}

	@Override
	public boolean checkIsPwdSame(String No,String pwd) {
		String oldPwd = std.querryPwd(No);	//新旧密码相同
		if(pwd.equals(oldPwd)){
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePwd(Student student) {
		// TODO Auto-generated method stub
		return std.updatePwd(student);
	}

	@Override
	public Student querryStudentByNo(String no) {
		if(std.querryStudentByNo(no)==null){
			System.err.println("查询失败");
		}
		return std.querryStudentByNo(no);
	}

	@Override
	public List<String> querryPlan(String uname) {
		
		return std.querryPlan(uname);
	}

}
