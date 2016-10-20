package com.ibingbo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibingbo.dao.UserDao;
import com.ibingbo.db.Conn;
import com.ibingbo.models.User;

public class UserDaoImpl implements UserDao{
	
	private Conn conn = null;
	
	public UserDaoImpl() {
		this.conn=Conn.getInstance();
	}

	@Override
	public List<User> getUsers() {
		List<User> users=new ArrayList<User>();
		try {
			ResultSet rs=this.conn.query("select * from user");
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				users.add(user);
				System.out.println(user.getName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

}
