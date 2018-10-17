package com.login.Lz.Service;

import com.login.Lz.Bean.User;
import com.login.Lz.dao.IUserdao;

import com.login.dao.impl.UserDaoImpl;

public class Userservice {
	//声明DAO对象
	private IUserdao userDao=new UserDaoImpl();
		//登录方法
		public User userLogin(String username,String password) {
			User user=userDao.findUserByInfo(username, password);
			return user;
		}
	
		

}
