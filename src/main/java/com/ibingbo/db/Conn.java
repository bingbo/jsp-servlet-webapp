package com.ibingbo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	
	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
	static final String PASS = "";
	
	private Connection conn = null;
	private Statement st = null;
	
	private static Conn instance = null;
	
	private Conn() throws ClassNotFoundException, SQLException{
			Class.forName("com.mysql.jdbc.Driver");
			this.conn=DriverManager.getConnection(DB_URL, USER, PASS);
			this.st=this.conn.createStatement();
	}
	
	public static Conn getInstance() {
		if(instance == null){
			try {
				instance=new Conn();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	public ResultSet query(String sql) throws SQLException{
		ResultSet rs = this.st.executeQuery(sql);
		return rs;
	}
	
}
