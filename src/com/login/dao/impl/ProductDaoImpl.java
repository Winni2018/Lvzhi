package com.login.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.Lz.Bean.Proclass;
import com.login.Lz.Bean.Product;
import com.login.Lz.Util.SQLUtil;
import com.login.Lz.dao.IProduct;


public class ProductDaoImpl implements IProduct {

	
	@Override
	public List<Product> findAllProduct() {
		String sql="SELECT product.proId,product.proName,product.proPrice,product.proInfo,product.proPic,product.proDetails,proclass.proClassname "
				+ "FROM product INNER JOIN proclass ON product.proClassId = proclass.proClassId ORDER BY proId DESC";
		ResultSet rst=SQLUtil.executeQuery(sql);
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
			proclass.setProClassname(rst.getString(7));
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
	@Override
	public List<Product> selectProduct() {
		
		String sql="SELECT * from product ORDER BY proId desc limit 12,4";
		ResultSet rst=SQLUtil.executeQuery(sql);
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
				proclass.setProClassname(rst.getString(7));
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
	@Override
	public void deleteOneProduct(int proId) {
		// TODO Auto-generated method stub
		String sql="delete from product where proId=?";
			SQLUtil.executeUpdate(sql, proId);
	}

	@Override
	public Product findOneProductById(int proId) {
		//声明SQL
		String sql = "SELECT product.proId,product.proName,product.proPrice,product.proInfo,product.proPic,product.proDetails,product.proClassId, proclass.proClassname FROM proclass INNER JOIN product ON product.proClassId = proclass.proClassId WHERE proId=?";
		//执行SQL命令，把结果存入rst
		ResultSet rst=SQLUtil.executeQuery(sql,proId);
	
		//Proclass proclass=null;

		//把结果集中的所有记录转存到集合中
		try {
			if(rst.next()) {
				//把当前记录转到一个product
				Product product=new Product();
				Proclass proclass=new Proclass();
				product.setProId(rst.getInt(1));
				product.setProName(rst.getString(2));
				product.setProPrice(rst.getFloat(3));
				product.setProInfo(rst.getString(4));
				product.setProClassId(rst.getInt(7));
				product.setProPic(rst.getString(5));
				product.setProDetails(rst.getString(6));
				proclass.setProClassId(rst.getInt(7));
				proclass.setProClassname(rst.getString(8));
				product.setProclass(proclass);
				
				return product;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void insertOneProduct(Product product) {
		// TODO Auto-generated method stub
		String sql="insert into product(proName,proPrice,proInfo,proPic,proDetails,proClassId)values(?,?,?,?,?,?)";
		SQLUtil.executeUpdate(sql,product.getProName(),product.getProPrice(),product.getProInfo(),product.getProPic(),product.getProDetails(),product.getProClassId());
	}
	@Override
	public void updateOneProduct(Product product) {
		String sql ="update product set proName=?,proPrice=?,proInfo=?,proPic=?,proDetails=?,proClassId=? where proId=?";
		SQLUtil.executeUpdate(sql,product.getProName(),product.getProPrice(),product.getProInfo(),product.getProPic(),product.getProDetails(),product.getProClassId(),product.getProId());
	}
	@Override
	public List<Product> selectProduct1() {
		String sql="SELECT * from product ORDER BY proId  limit 4,4";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<Product> products1=new ArrayList<>();
		try {
			while(rst.next()) {
				Product product1=new Product();
				Proclass proclass=new Proclass();
				product1.setProId(rst.getInt(1));
				product1.setProName(rst.getString(2));
				product1.setProPrice(rst.getFloat(3));
				product1.setProInfo(rst.getString(4));
				product1.setProPic(rst.getString(5));
				product1.setProDetails(rst.getString(6));
				proclass.setProClassname(rst.getString(7));
				product1.setProclass(proclass);
				products1.add(product1);
			
			}
			return products1;
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
	public List<Product> ProductDuorou() {
		String sql="SELECT * from product ORDER BY proId DESC limit 4,4";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<Product> products2=new ArrayList<>();
		try {
			while(rst.next()) {
				Product product2=new Product();
				Proclass proclass=new Proclass();
				product2.setProId(rst.getInt(1));
				product2.setProName(rst.getString(2));
				product2.setProPrice(rst.getFloat(3));
				product2.setProInfo(rst.getString(4));
				product2.setProPic(rst.getString(5));
				product2.setProDetails(rst.getString(6));
				proclass.setProClassname(rst.getString(7));
				product2.setProclass(proclass);
				products2.add(product2);
			
			}
			return products2;
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
	public List<Product> ProductZuhe() {
		String sql="SELECT * from product ORDER BY  proId DESC limit 0,4";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<Product> products3=new ArrayList<>();
		try {
			while(rst.next()) {
			Product product3=new Product();
			Proclass proclass=new Proclass();
			product3.setProId(rst.getInt(1));
			product3.setProName(rst.getString(2));
			product3.setProPrice(rst.getFloat(3));
			product3.setProInfo(rst.getString(4));
			product3.setProPic(rst.getString(5));
			product3.setProDetails(rst.getString(6));
			proclass.setProClassname(rst.getString(7));
			product3.setProclass(proclass);
			products3.add(product3);
			
			}
			return products3;
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
	public List<Product> ProductDetails() {
		String sql="SELECT * from product ORDER BY  proId  limit 2,1";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<Product> products4=new ArrayList<>();
		try {
			while(rst.next()) {
			Product product4=new Product();
			Proclass proclass=new Proclass();
			product4.setProId(rst.getInt(1));
			product4.setProName(rst.getString(2));
			product4.setProPrice(rst.getFloat(3));
			product4.setProInfo(rst.getString(4));
//			product2.setProClassId(rst.getInt(6));
			product4.setProPic(rst.getString(5));
//			proclass.setProClassId(rst.getInt(6));
			proclass.setProClassname(rst.getString(6));
			product4.setProDetails(rst.getString(7));
			product4.setProclass(proclass);
			products4.add(product4);
			
			}
			return products4;
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
	public List<Product> Productlist() {
		String sql="SELECT * from product ORDER BY proId limit 0,12";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<Product> products5=new ArrayList<>();
		try {
			while(rst.next()) {
			Product product5=new Product();
			Proclass proclass=new Proclass();
			product5.setProId(rst.getInt(1));
			product5.setProName(rst.getString(2));
			product5.setProPrice(rst.getFloat(3));
			product5.setProInfo(rst.getString(4));
//			product5.setProClassId(rst.getInt(6));
			product5.setProPic(rst.getString(5));
//			proclass.setProClassId(rst.getInt(6));
			proclass.setProClassname(rst.getString(6));
			product5.setProDetails(rst.getString(7));
			product5.setProclass(proclass);
			products5.add(product5);
			
			}
			return products5;
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
