package com.login.Lz.Service;

import java.util.List;

import com.login.Lz.Bean.Addsmall;
import com.login.Lz.dao.IAddSmall;
import com.login.dao.impl.AddSmallDaoImpl;

public class AddSmallService {
	private IAddSmall AddSmallDao=new AddSmallDaoImpl();
	public List<Addsmall> selectAlladdSmall() {
		return AddSmallDao.selectAlladdSmall();
	}
	public List<Addsmall> selectAlladdsmallByaddressId(int addressId) {
		return AddSmallDao.selectAlladdsmallByaddressId(addressId);
	}
}
