package com.ibingbo.services.impl;

import java.util.List;

import com.ibingbo.dao.UserDao;
import com.ibingbo.dao.impl.UserDaoImpl;
import com.ibingbo.models.User;
import com.ibingbo.services.UserService;

public class UserServiceImpl implements UserService {

	
	private UserDao userDao;
	
	public UserServiceImpl() {
		this.userDao=new UserDaoImpl();
	}
	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return this.userDao.getUsers();
	}

}
