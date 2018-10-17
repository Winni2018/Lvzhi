package com.login.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.Lz.Bean.Address;
import com.login.Lz.Bean.Addsmall;
import com.login.Lz.Bean.Customer;
import com.login.Lz.Util.SQLUtil;
import com.login.Lz.dao.IAddSmall;

public class AddSmallDaoImpl implements IAddSmall {

	@Override
	public List<Addsmall> selectAlladdSmall() {
		String sql="SELECT * FROM addsmall ORDER BY addSmallId DESC";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<Addsmall> addsmallList=new ArrayList<>();
		try {
			while(rst.next()) {
				Addsmall addsmall=new Addsmall();
				addsmall.setAddSmallId(rst.getInt(1));
				addsmall.setAddSmallCont(rst.getString(2));
				addsmall.setAddressId(rst.getInt(3));
				addsmallList.add(addsmall);
			}
			return addsmallList;
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

	@Override
	public List<Addsmall> selectAlladdsmallByaddressId(int addressId) {
		// TODO Auto-generated method stub
		List<Addsmall> addsmallList=new ArrayList<>();
		String sql="SELECT * from addsmall WHERE addressId=?";
		ResultSet rst=SQLUtil.executeQuery(sql,addressId);
		try {
			while(rst.next()) {
				Addsmall addsmall=new Addsmall();
				addsmall.setAddSmallId(rst.getInt(1));
				addsmall.setAddSmallCont(rst.getString(2));
				addsmall.setAddressId(rst.getInt(3));
				addsmallList.add(addsmall);
			}
			return addsmallList;
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


