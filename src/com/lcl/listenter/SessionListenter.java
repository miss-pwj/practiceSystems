package com.lcl.listenter;


import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListenter implements HttpSessionAttributeListener,HttpSessionListener {
	
	//监听session属性的变化
    public SessionListenter() {
        // TODO Auto-generated constructor stub
    }
    
    //监听session的创建和销毁
  	@Override
  	public void sessionCreated(HttpSessionEvent event) {
  		System.out.println("一个session被创建");
  	}

  	@Override
  	public void sessionDestroyed(HttpSessionEvent event) {
  	        System.out.println("一个session被销毁");
  	}

    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	System.out.println("创建的属性："+event.getName()+"属性的值："+event.getValue());
    	if(!event.getName().equals("uname")){
    		return;
    	}
    	 int num=0;  //定义初始在线人数为0
         ServletContext servletContext = event.getSession().getServletContext();//使用session来判断是否为注册用户
         Object object = servletContext.getAttribute("num");  //获取人数num
         if(object==null){
             num=1;  //object为null,说明是第一个登录的用户
         }else {
             num=(Integer)object+1;  //如果不为null,就在原人数上+1;
         }
         servletContext.setAttribute("num", num);
         System.out.println("当前在线人数："+num);
    }

    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	System.out.println("移除的属性："+event.getName()+"属性的值："+event.getValue());
    	if(!event.getName().equals("uname")){
    		return;
    	}
    	 ServletContext servletContext = event.getSession().getServletContext();
         Object object = servletContext.getAttribute("num"); //获取人数num
         int num=(Integer)object-1;  //退出登录后人数-1
         servletContext.setAttribute("num", num);  //变更人数后设置给num
         System.out.println("当前在线人数："+num);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  {
    	System.out.println("改变的属性："+event.getName()+"属性的值："+event.getValue());
    }

  
	
}
