package com.lcl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static java.sql.Date stringToDate(String dateString) {
		if (dateString == null && "".equals(dateString)) {
			throw new NullPointerException("传入参数为空");
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//利用字符串构建java.sql.Date对象
		java.util.Date date=null;
		try {
			date = format.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//格式化时间
		format.format(date);
		//将java.sql.Date专为java.util.Date
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		return sqlDate;
	}
	
	//传入参数类似于:2015-12-30
	public static Date splitStringToDate(String dateString) {
		String[] str = dateString.split("-");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR,Integer.parseInt(str[0]));
		calendar.set(Calendar.MONTH,(Integer.parseInt(str[1])-1));
		calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(str[2]));
		java.util.Date date1 = calendar.getTime();
		java.sql.Date sqlDate=new java.sql.Date(date1.getTime());
		return sqlDate;
	}
	public static String dateToString(java.sql.Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
	
	public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
		Calendar date = Calendar.getInstance();
		date.setTime(nowTime);
		Calendar begin = Calendar.getInstance();
		begin.setTime(beginTime);
		Calendar end = Calendar.getInstance();
		end.setTime(endTime);
		
		if (date.after(begin) && date.before(end)) {
			return true;
		} else if (nowTime.compareTo(beginTime) == 0 || nowTime.compareTo(endTime) == 0) {
			return true;
		} 
		return false;
	}
	public static void main(String[] args) throws ParseException {
//		Date date= stringToDate("2015-12-30 00:00:00");
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//	System.out.println(format.format(date));
		System.out.println(dateToString(stringToDate("2015-12-30")));
	}
}
