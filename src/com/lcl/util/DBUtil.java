package com.lcl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static final String URL="jdbc:mysql://localhost:3306/java";
	private static final String USERNAME="root";
	private  static final String PWD="";
	public static PreparedStatement pstmt=null;
	public static Connection connection=null;
	public static ResultSet rs=null;
	
	//获取连接
	public static Connection createConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		return (Connection) DriverManager.getConnection(URL,USERNAME,PWD);
	}
	//增删改
		public static boolean executeUpdate(String sql,Object[] params){
			try{
			pstmt=createPrepareStatement(sql, params);
			int count=pstmt.executeUpdate();
			
			if(count>0){
				return true;
			}else{
				return false;
			}
			
			}catch(ClassNotFoundException e){
				e.printStackTrace();
				return false;
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			finally{
				closeAll(null, pstmt, connection);
			}
		}
		
		
		
		public static PreparedStatement createPrepareStatement(String sql,Object[] params) throws ClassNotFoundException, SQLException{
			pstmt = createConnection().prepareStatement(sql);//预编译
				if(params!=null){
					for(int i=0;i<params.length;i++){
						pstmt.setObject(i+1, params[i]);
					}
				}
				return pstmt;
		}
		
		//查
		public static ResultSet executeQuerry(String sql,Object[] params) throws ClassNotFoundException, SQLException{
			try{
				pstmt=createPrepareStatement(sql, params);
				rs=pstmt.executeQuery();
				
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
//			finally{
//				closeAll(rs, pstmt, connection);
//			}
			return rs;
		
		}
		
		//关闭连接
	public static void closeAll(ResultSet rs,PreparedStatement pstmt,Connection connection){
		try{
			 if(connection!=null) connection.close();
			 if(pstmt!=null)	pstmt.close();//对象.方法
			if(rs!=null) rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//查询总数
		public static int getTotalCount(String sql ) { //select count(1) from student
			int count = -1 ;
			try {
				 pstmt = createPrepareStatement(sql, null );
				 rs = pstmt.executeQuery()  ;//88
				if(rs.next()) {
					count = rs.getInt(1) ;
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				closeAll(rs, pstmt, connection);
			}
			return count;
		}
		
		
}
