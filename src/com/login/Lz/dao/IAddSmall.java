package com.login.Lz.dao;

import java.util.List;

import com.login.Lz.Bean.Addsmall;
public interface IAddSmall {
	public List<Addsmall> selectAlladdSmall();
	public List<Addsmall> selectAlladdsmallByaddressId(int addressId);
}
