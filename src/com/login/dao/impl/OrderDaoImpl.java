package com.login.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.Lz.Bean.Customer;
import com.login.Lz.Bean.Order;
import com.login.Lz.Bean.Proclass;
import com.login.Lz.Bean.Product;
import com.login.Lz.Util.SQLUtil;
import com.login.Lz.dao.IOrder;

public class OrderDaoImpl implements IOrder {

	@Override
	public List<Order> findAllOrder() {
		String sql="SELECT `order`.orderId,`order`.orderTime,customer.cusAccount,product.proName,`order`.orderPrice,`order`.orderStatus,`order`.proId,`order`.customerId FROM `order` INNER JOIN product ON `order`.proId = product.proId INNER JOIN customer "
				+ "ON `order`.customerId = customer.customerId ORDER BY orderId desc";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<Order> orders=new ArrayList<>();
		try {
			while(rst.next()) {
			Order order=new Order();
			Customer customer=new Customer();
			Product product=new Product();

			order.setOrderId(rst.getInt(1));
			order.setOrderTime(rst.getDate(2));
			customer.setCusAccount(rst.getInt(3));
			product.setProName(rst.getString(4));
			order.setOrderPrice(rst.getFloat(5));
			order.setOrderStatus(rst.getString(6));
			product.setProId(rst.getInt(7));
			customer.setCustomerId(rst.getInt(8));
			order.setCustomer(customer);
			order.setProduct(product);
			orders.add(order);
			
			}
			return orders;
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
	public Order findOneOrderById(int orderId) {
		// TODO Auto-generated method stub
		String sql="SELECT `order`.orderId,`order`.orderTime,`order`.customerId,`order`.proId,`order`.orderPrice,`order`.orderStatus,\r\n" + 
				"customer.cusName,customer.cusTel,customer.addDetails,product.proName,product.proPic,product.proPrice\r\n" + 
				"FROM `order` INNER JOIN product ON `order`.proId = product.proId INNER JOIN customer ON `order`.customerId = customer.customerId WHERE `order`.orderId=?";
		
		ResultSet rst=SQLUtil.executeQuery(sql,orderId);
		try {
			if(rst.next()) {
				Order order=new Order();
				Customer customer=new Customer();
				Product product=new Product();

				order.setOrderId(rst.getInt(1));
				order.setOrderTime(rst.getDate(2));
				order.setCustomerId(rst.getInt(3));
				order.setProId(rst.getInt(4));
				order.setOrderPrice(rst.getFloat(5));
				order.setOrderStatus(rst.getString(6));
				customer.setCusName(rst.getString(7));
				customer.setCusTel(rst.getString(8));
				customer.setAddDetails(rst.getString(9));
				product.setProName(rst.getString(10));
				product.setProPic(rst.getString(11));
				product.setProPrice(rst.getFloat(12));
				
				order.setCustomer(customer);
				order.setProduct(product);
			return order;
			
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


	@Override
	public Order findOneOrder(int customerId) {
		String sql="SELECT `order`.orderId,`order`.orderStatus,`order`.orderTime,`order`.orderPrice,`order`.proId,`order`.customerId,\r\n" + 
				"product.proName FROM `order` INNER JOIN customer ON `order`.customerId = customer.customerId INNER JOIN product ON `order`.proId = product.proId WHERE `order`.customerId = ?";
		
		ResultSet rst=SQLUtil.executeQuery(sql,customerId);
		try {
			if(rst.next()) {
			Order order=new Order();
			Customer customer=new Customer();
			Product product=new Product();

			order.setOrderId(rst.getInt(1));
			order.setOrderStatus(rst.getString(2));
			order.setOrderTime(rst.getDate(3));
			order.setOrderPrice(rst.getFloat(4));
			product.setProId(rst.getInt(5));
			product.setProName(rst.getString(7));
			customer.setCustomerId(rst.getInt(6));
			
			order.setCustomer(customer);
			order.setProduct(product);
			return order;
			
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

	@Override
	public List<Order> selectallOrderBycusId(int customerId) {
		String sql="SELECT `order`.orderId,`order`.orderStatus,`order`.orderTime,`order`.orderPrice,`order`.proId,`order`.customerId,\r\n" + 
				"product.proName FROM `order` INNER JOIN customer ON `order`.customerId = customer.customerId INNER JOIN product ON `order`.proId = product.proId WHERE `order`.customerId = ?";
	
		ResultSet rst=SQLUtil.executeQuery(sql,customerId);
		List<Order> orders=new ArrayList<>();
		try {
			while(rst.next()) {
			Order order=new Order();
			Customer customer=new Customer();
			Product product=new Product();

			order.setOrderId(rst.getInt(1));
			order.setOrderStatus(rst.getString(2));
			order.setOrderTime(rst.getDate(3));
			order.setOrderPrice(rst.getFloat(4));
			product.setProId(rst.getInt(5));
			customer.setCustomerId(rst.getInt(6));
			product.setProName(rst.getString(7));
			order.setCustomer(customer);
			order.setProduct(product);
			orders.add(order);
			
			}
			return orders;
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
	public void selectOneOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOneOrder(int orderId) {
		String sql="delete from `order` where orderId=?";
		SQLUtil.executeUpdate(sql, orderId);
		
	}

}
