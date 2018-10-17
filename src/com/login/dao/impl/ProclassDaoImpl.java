package com.login.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.Lz.Bean.Proclass;
import com.login.Lz.Bean.Product;
import com.login.Lz.Util.SQLUtil;
import com.login.Lz.dao.IProClass;

public class ProclassDaoImpl implements IProClass {

	@Override
	public List<Proclass> selectAllProclass() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM proclass ORDER BY proClassId DESC";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<Proclass> proClass=new ArrayList<>();
		try {
			while(rst.next()) {
				Proclass proclass=new Proclass();
				proclass.setProClassId(rst.getInt(1));
				proclass.setProClassname(rst.getString(2));
				proclass.setProClassdetail(rst.getString(3));
				proClass.add(proclass);
			}
			return proClass;
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
	public List<Product> selectsort(int proclassId) {
		String sql="SELECT product.proId,product.proName,product.proPrice,product.proInfo,product.proPic,product.proDetails,product.proClassId,proclass.proClassname FROM product INNER JOIN proclass ON "
				+ "product.proClassId = proclass.proClassId WHERE product.proClassId=?";
		ResultSet rst=SQLUtil.executeQuery(sql,proclassId);
		List<Product> products=new ArrayList<>();
		
		try {
			while(rst.next()) {
				Product product=new Product();
				Proclass proclass=new Proclass();
				product.setProId(rst.getInt(1));
				product.setProName(rst.getString(2));
				product.setProPrice(rst.getFloat(3));
				product.setProInfo(rst.getString(4));
				product.setProPic(rst.getString(5));
				product.setProDetails(rst.getString(6));
				proclass.setProClassname(rst.getString(8));
				product.setProclass(proclass);
				products.add(product);
				
			}
			return products;
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
