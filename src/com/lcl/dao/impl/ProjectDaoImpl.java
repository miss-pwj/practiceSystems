package com.lcl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lcl.dao.ProjectDao;
import com.lcl.entity.Project;
import com.lcl.entity.Project_select;
import com.lcl.util.DBUtil;


public class ProjectDaoImpl implements ProjectDao{

	@Override
	public boolean addProject(Project pro) {
		String sql="insert into project(No,name,introduction,students_num,company_username,"
				+ "company_teacher,company_teacher_title,release_date,"
				+ "grade,category,major) values(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {pro.getNo(),pro.getName(),pro.getIntroduction(),pro.getStudentsNum(),pro.getCompanyUsername(),pro.getCompanyTeacher(),pro.getCompanyTeacherTitle(),pro.getReleaseDate(),pro.getGrade(),pro.getCategory(),pro.getMajor()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public List<Project> querryProject() {
		List<Project> list = new ArrayList<>();
		String sql="select * from project";
		ResultSet rs=null;
		try {
			rs=DBUtil.executeQuerry(sql, null);
			while(rs.next()){
				String No = rs.getString(1);
				String name =rs.getString(2);
				String introduction = rs.getString(3);
				int students_num = rs.getInt(4);
				String company_username=rs.getString(5);
				String company_teacher = rs.getString(6);
				String company_teacher_title = rs.getString(7);
				Date release_date = rs.getDate(8);
				Date audit_date=rs.getDate(9);
				Date end_date=rs.getDate(10);
				String summary = rs.getString(11);
				int grade = rs.getInt(12);
				String category = rs.getString(13);
				String major = rs.getString(14);
				Project pro = new Project(No,name,introduction,students_num,company_username,company_teacher,company_teacher_title,release_date,audit_date,end_date,summary,grade,category,major);
				list.add(pro);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public boolean choosePlan(Project_select ps) {
		String sql="insert into project_select(studentNo,projectNo,sel_reason,company_name) values(?,?,?,?)";
		Object[] params={ps.getStudentNo(),ps.getProjectNo(),ps.getSelReason(),ps.getCompanyName()};
		boolean b=DBUtil.executeUpdate(sql, params);
		String sql2="update project set students_num=students_num-1 where No=?";
		Object[] params2={ps.getProjectNo()};
		boolean a=DBUtil.executeUpdate(sql2, params2);
		return a&&b;
	}

	@Override
	public boolean querryStuAndPro(Project_select ps) {
		String sql="select * from project_select where studentNo=?";
		Object[] params={ps.getStudentNo()};
		try {
			ResultSet rs = DBUtil.executeQuerry(sql, params);
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
	public boolean chooseStudent(Project_select ps) {
		String sql="update project_select set company_sel_date =?,company_name=? where studentNo=?";
		Object[] params={ps.getCompanySelDate(),ps.getCompanyName(),ps.getStudentNo()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public Project querryPlanByNo(String no) {
		String sql="select * from project where No=?";
		Object[] params={no};
		ResultSet rs=null;
		Project project=null;
		try {
			rs=DBUtil.executeQuerry(sql, params);
			if(rs.next()){
				String No = rs.getString(1);
				String name=rs.getString(2);
				String introduction = rs.getString(3);
				int studentNum = rs.getInt(4);
				String companyUserName = rs.getString(5);
				String companyTeacher = rs.getString(6);
				String companyTeacherTitle = rs.getString(7);
				Date releaseDate = rs.getDate(8);
				int grade = rs.getInt(12);
				String category = rs.getString(13);
				String major = rs.getString(14);
				 project = new Project(No,name,introduction,studentNum,companyUserName,companyTeacher,companyTeacherTitle,releaseDate,grade,category,major);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("数据库这里"+project.getName());
		return project;
	}

	//审核方案
	@Override
	public boolean auditDateByNo(Project project) {
		String sql="update project set audit_date=? where No=?";
		Object[] params={project.getAuditDate(),project.getNo()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public boolean giveUpPlan(Project_select ps) {
		String sql="delete from project_select where studentNo =? and projectNo=?";
		Object[] params={ps.getStudentNo(),ps.getProjectNo()};
		boolean b=DBUtil.executeUpdate(sql, params);
		String sql2="update project set students_num=students_num+1 where No=?";
		Object[] params2={ps.getProjectNo()};
		boolean a=DBUtil.executeUpdate(sql2, params2);
		return a&&b;
	}

	@Override
	public int maxNum(String no) {
		String sql="select students_num from project where No=?";
		Object[] params={no};
		ResultSet rs=null;
		int num=-1;
		try {
			rs=DBUtil.executeQuerry(sql, params);
			if(rs.next()){
				 num = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<Project_select> studentWithPlan() {
		String sql="select * from project_select";
		Object[] params={};
		ResultSet rs = null;
		List<Project_select> list = new ArrayList<>();
		try {
			rs = DBUtil.executeQuerry(sql, params);
			while(rs.next()){
				String studentNo = rs.getString(1);
				String projectNo = rs.getString(2);
				String reason = rs.getString(3);
				Project_select ps = new Project_select(studentNo,projectNo,reason);
				list.add(ps);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean chooseStudentByNo(Project_select ps) {
		String sql="update project_select set company_sel_date=?,company_name=? where studentNo=? and projectNo =?";
		Object[] params={ps.getCompanySelDate(),ps.getCompanyName(),ps.getStudentNo(),ps.getProjectNo()};
		
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public boolean companyGiveUp(String stuNo, String proNo) {
		String sql="update project_select set company_sel_date=null where studentNo=? and projectNo =?";
		Object[] params={stuNo,proNo};
		
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public boolean IsStudentChoose(String stuNo, String proNo) {
		boolean b=false;
		String sql = "select company_sel_date from project_select where studentNo = ? and projectNo=?";
		Object[] params={stuNo,proNo};
		ResultSet rs;
		try {
			rs = DBUtil.executeQuerry(sql, params);
			if(rs.next()){
				Date date = rs.getDate(1);
				if(date!=null){
					b = true;
				}
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
	public List<Project_select> studentWithPlan(int currentPage, int pageSize) {
		String sql="select * from project_select limit ?,?";
		Object[] params = {(currentPage-1)*pageSize,pageSize}; 
		List<Project_select> list = new ArrayList<>();
		
		ResultSet rs;
		try {
			rs = DBUtil.executeQuerry(sql, params);
			while(rs.next()) {
				String studentNo = rs.getString(1);
				String projectNo = rs.getString(2);
				String reason = rs.getString(3);
				Date date = rs.getDate(4);
				Project_select ps = new Project_select(studentNo,projectNo,reason,date);
				list.add(ps);
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}

	@Override
	public int totalSizeOfProject_select() {
		String sql="select count(*) from project_select";
		return DBUtil.getTotalCount(sql);
	}

	@Override
	public String querryCompanyUserName(String proNo) {
		String sql="select company_username from project where No=?";
		Object[] params={proNo};
		ResultSet rs =null;
		String companyUserName = null;
		try {
			rs=DBUtil.executeQuerry(sql, params);
			if(rs.next()){
				companyUserName=rs.getString(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return companyUserName;
	}

	@Override
	public boolean querryIsBeChoose(String proNo) {
		String sql="select studentNo from project_select where projectNo=?";
		Object[] params={proNo};
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
	public boolean isAudit(String no) {
		String sql="select audit_date from project where No=?";
		Object[] params={no};
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
	public boolean isChoose(String no) {
		String sql="select projectNo from project_select where studentNo=?";
		Object[] params={no};
		ResultSet rs = null;
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
}
