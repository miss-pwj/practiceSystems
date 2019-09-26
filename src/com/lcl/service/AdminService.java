package com.lcl.service;

import com.lcl.entity.System_Parameter;

public interface AdminService {
	//管理员登录
	public boolean adminLogin(System_Parameter admin);
	//设置方案起止时间
	public boolean setTimeStartEnd(System_Parameter admin) ;
	//查询方案起止时间
	public System_Parameter querryDate(String uname);
}
