package com.lcl.util;

//防止SQL注入
public class ValidateUtils {
	public static boolean validate(String pageParameter) {
		boolean flag = false ;
		String inj_str = "|insert|select|delete|update|drop|alter|count|"
				+ "declare|or";
		String pageParameter2 = pageParameter.toLowerCase();
		String inj_stra[] = inj_str.split("\\|"); 
		for(String i : inj_stra) {
			if (pageParameter2.indexOf(i) > 0) {
				flag = true ;
			} 
		}
		return flag ;
	}
}
