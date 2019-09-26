package com.lcl.service.impl;


import com.lcl.dao.AdminDao;
import com.lcl.dao.impl.AdminDaoImpl;
import com.lcl.entity.System_Parameter;
import com.lcl.service.AdminService;

public class AdminServiceImpl implements AdminService{
	AdminDao ad =new AdminDaoImpl();
	@Override
	public boolean adminLogin(System_Parameter admin) {
		return ad.AdminLogin(admin); 
	}
	@Override
	public boolean setTimeStartEnd(System_Parameter admin) {
		// TODO Auto-generated method stub
		return ad.setTimeStartEnd(admin);
	}
	@Override
	public System_Parameter querryDate(String uname) {
		if(ad.querryDate(uname)==null){
			System.out.println("查询失败");
		}
		return ad.querryDate(uname);
	}

}
