package com.lcl.service;

import java.util.List;

import com.lcl.entity.Project;
import com.lcl.entity.Project_select;

public interface ProjectService {
	//增加方案
	public boolean addProject(Project pro);
	//查看方案
	public List<Project> querryProject();
	//学生方案选择
	public boolean choosePlan(Project_select ps);
	//根据学号和方案号查询
	public boolean querryStuAndPro(Project_select ps) ;
	//根据学号选择学生
	public boolean chooseStudent(Project_select ps) ;
	//根据方案号 查询方案
	public Project querryPlanByNo(String no);
	//管理员审核方案
	public boolean auditDateByNo(Project project);
	//学生退出选择方案
	public boolean giveUpPlan(Project_select ps);
	//根据方案号查询可报最大人数
	public int maxNum(String no);
	//查询所有选择了方案的学生
	public List<Project_select> studentWithPlan();
	//公司选择选了方案的学生
	public boolean chooseStudentByNo(Project_select ps);
	//公司放弃已选择了的学生
	public boolean companyGiveUp(String stuNo,String proNo);
	//公司判断学生是否已经被选择
	public boolean IsStudentChoose(String stuNo, String proNo);
	//分页查询选择了方案的学生和方案
	public List<Project_select> studentWithPlan(int currentPage, int pageSize);
	//查询选择方案和学生的总条数
	public int totalSizeOfProject_select();
	//根据账号查找公司名称
	public String querryCompanyUserName(String proNo);
	//通过方案号查找学号是否存在
	public boolean querryIsBeChoose(String proNo);
	//通过方案号判断是否已经审核
	public boolean isAudit(String no);
	//通过学号查询学生是否选择了方案
	public boolean isStudentChoose(String no);
}
