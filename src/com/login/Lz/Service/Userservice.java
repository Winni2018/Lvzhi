package com.login.Lz.Service;

import com.login.Lz.Bean.User;
import com.login.Lz.dao.IUserdao;

import com.login.dao.impl.UserDaoImpl;

public class Userservice {
	//����DAO����
	private IUserdao userDao=new UserDaoImpl();
		//��¼����
		public User userLogin(String username,String password) {
			User user=userDao.findUserByInfo(username, password);
			return user;
		}
	
		

}
