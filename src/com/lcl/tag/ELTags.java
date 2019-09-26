package com.lcl.tag;

import javax.servlet.http.HttpSession;

import org.apache.catalina.SessionEvent;
import org.apache.catalina.SessionListener;

public class ELTags implements SessionListener{
	private HttpSession session;
	public static void invalidate(){
	}
	@Override
	public void sessionEvent(SessionEvent arg0) {
		// TODO Auto-generated method stub
		session=(HttpSession) arg0.getSession();
	}
}
