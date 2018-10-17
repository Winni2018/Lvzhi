package com.login.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.login.Lz.Bean.User;
import com.login.Lz.Util.SQLUtil;
import com.login.Lz.dao.IUserdao;

public class UserDaoImpl implements IUserdao {


	public User findUserByInfo(String username,String password) {
		// TODO Auto-generated method stub
		//SQL���
		String sql="select * from user where username=? and password=?";
		//SQLUtilִ��SQL���
		ResultSet rst=SQLUtil.executeQuery(sql,username,password);
		System.out.println(rst);
		//�жϽ����
		try {
			if(rst.next()) {
			//�ѵ�ǰ��¼��ȡ����
			User user=new User();
			user.setUserId(rst.getInt(1));
			user.setUsername(rst.getString(2));
			user.setPassword(rst.getString(3));
			user.setTele(rst.getInt(4));
			return user;
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
