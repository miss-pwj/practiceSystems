package com.lcl.service;

import java.util.List;

import com.lcl.entity.Student;

public interface StudentService {
	//学生登录
	public boolean studentLogin(Student student);
	//查询是否存在邮箱
	public boolean isMailExist(Student student);
	//通过邮箱改密码
	public boolean changePwdByMail(String pwd,String mail);
	//判断新密码和旧密码是否相同
	public boolean checkIsPwdSame(String No,String pwd);
	//通过用户名该密码
	public boolean updatePwd(Student student);
	//根据学号查询学生
	public Student querryStudentByNo(String no);
	//学生查询选择方案选择情况
	public List<String> querryPlan(String uname);
}
