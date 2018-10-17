package com.login.Lz.Service;

import java.util.List;

import com.login.Lz.Bean.Address;
import com.login.Lz.dao.IAddress;
import com.login.dao.impl.AddressDaoImpl;


public class AddressService {
	private IAddress AddressDao=new AddressDaoImpl();
	public List<Address> selectAllAddress() {
		return AddressDao.selectAllAddress();
	}
	
}
