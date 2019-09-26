package com.lcl.dao;

import java.util.List;

import com.lcl.entity.Student;

public interface StudentDao {
	//学生登录
	public boolean studentLogin(Student student);
	//查询邮箱是否存在
	public boolean isMailExist(Student student);
	//通过邮箱改密码
		public boolean changePwdByMail(String pwd,String mail);
	//通过用户名查密码
	public String querryPwd(String No);
	//根据用户名修改密码
	public boolean updatePwd(Student student);
	//根据学号查询学生信息
	public Student querryStudentByNo(String no);
	//学生查询选择的方案
	public List<String> querryPlan(String uname);
	
	
}
