package com.login.Lz.dao;

import com.login.Lz.Bean.User;

public interface IUserdao {
	User findUserByInfo(String username,String password);
}
