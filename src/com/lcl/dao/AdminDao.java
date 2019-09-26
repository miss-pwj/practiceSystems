package com.lcl.dao;

import com.lcl.entity.System_Parameter;

public interface AdminDao {
	//管理员登录
	public boolean AdminLogin(System_Parameter admin);
	//设置方案的具体开始结束时间
	public boolean setTimeStartEnd(System_Parameter admin);
	//查询方案起止时间
	public System_Parameter querryDate(String uname);
}
