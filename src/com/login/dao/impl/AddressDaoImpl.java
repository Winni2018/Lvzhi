package com.login.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.Lz.Bean.Address;
import com.login.Lz.Util.SQLUtil;
import com.login.Lz.dao.IAddress;

public class AddressDaoImpl implements IAddress {

	@Override
	public List<Address> selectAllAddress() {
		String sql="SELECT * FROM address ORDER BY addressId DESC";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<Address> addresses=new ArrayList<>();
		try {
			while(rst.next()) {
				Address address=new Address();
				address.setAddressId(rst.getInt(1));
				address.setAddCont(rst.getString(2));;
				addresses.add(address);
			}
			return addresses;
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
