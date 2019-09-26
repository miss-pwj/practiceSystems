package com.lcl.service.impl;

import java.util.List;

import com.lcl.dao.ProjectDao;
import com.lcl.dao.impl.ProjectDaoImpl;
import com.lcl.entity.Project;
import com.lcl.entity.Project_select;
import com.lcl.service.ProjectService;


public class ProjectServiceImpl implements ProjectService{
	ProjectDao pd = new ProjectDaoImpl();
	@Override
	public boolean addProject(Project pro) {
		// TODO Auto-generated method stub
		return pd.addProject(pro);
	}
	@Override
	public List<Project> querryProject() {
		// TODO Auto-generated method stub
		return pd.querryProject();
	}
	@Override
	public boolean choosePlan(Project_select ps) {
		
		return pd.choosePlan(ps);
	}
	@Override
	public boolean querryStuAndPro(Project_select ps) {
		
		return pd.querryStuAndPro(ps);
	}
	@Override
	public boolean chooseStudent(Project_select ps) {
		
		return pd.chooseStudent(ps);
	}
	@Override
	public Project querryPlanByNo(String no) {
		return pd.querryPlanByNo(no);
	}
	@Override
	public boolean auditDateByNo(Project project) {
		
		return pd.auditDateByNo(project);
	}
	@Override
	public boolean giveUpPlan(Project_select ps) {
		// TODO Auto-generated method stub
		return pd.giveUpPlan(ps);
	}
	@Override
	public int maxNum(String no) {
		return pd.maxNum(no);
	}
	@Override
	public List<Project_select> studentWithPlan() {
		return pd.studentWithPlan();
	}
	@Override
	public boolean chooseStudentByNo(Project_select ps) {
		return pd.chooseStudentByNo(ps);
	}
	@Override
	public boolean companyGiveUp(String stuNo, String proNo) {
		
		return pd.companyGiveUp(stuNo, proNo);
	}
	@Override
	public boolean IsStudentChoose(String stuNo, String proNo) {
		return pd.IsStudentChoose(stuNo, proNo);
	}
	@Override
	public List<Project_select> studentWithPlan(int currentPage, int pageSize) {
		
		return pd.studentWithPlan(currentPage, pageSize);
	}
	@Override
	public int totalSizeOfProject_select() {
		return pd.totalSizeOfProject_select();
	}
	@Override
	public String querryCompanyUserName(String proNo) {
		return pd.querryCompanyUserName(proNo);
	}
	@Override
	public boolean querryIsBeChoose(String proNo) {
		return pd.querryIsBeChoose(proNo);
	}
	@Override
	public boolean isAudit(String no) {
		
		return pd.isAudit(no);
	}
	@Override
	public boolean isStudentChoose(String no) {
		return pd.isChoose(no);
	}

}
