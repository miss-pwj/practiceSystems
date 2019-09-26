package com.lcl.util;

import java.util.Random;

public class MakeCode {
	//生成邮箱验证码
	public static String getCode() {
		String codes = "ABCDEFGHIJKLMNPQRSTUVWXYZ123456789";
		char[] codeChar = codes.toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for(int i = 0 ; i < 4 ; i++) {
			char c = codeChar[random.nextInt(codeChar.length)];
			sb.append(c);
		}
		System.err.println("邮箱验证码"+sb.toString());
		return sb.toString();
	}
}
