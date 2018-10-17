package com.login.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.Lz.Bean.Address;
import com.login.Lz.Bean.Addsmall;
import com.login.Lz.Bean.Customer;
import com.login.Lz.Bean.Order;
import com.login.Lz.Bean.Product;
import com.login.Lz.Bean.User;
import com.login.Lz.Util.SQLUtil;
import com.login.Lz.dao.ICustomer;

public class CustomerDaoImpl implements ICustomer {

	@Override
	public List<Customer> findAllCustomer() {
		String sql="SELECT customer.customerId, customer.cusAccount,customer.cusName,customer.cusTel,customer.cusEmail,address.addCont,\r\n" + 
				"addsmall.addSmallCont,customer.addDetails FROM customer INNER JOIN addsmall ON customer.addSmallId = addsmall.addSmallId INNER JOIN address ON "
				+ "addsmall.addressId = address.addressId ORDER BY customerId desc";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<Customer> customers=new ArrayList<>();
		try {
			while(rst.next()) {
				Customer customer=new Customer();
				Addsmall addsmall=new Addsmall();
				Address address=new Address();
				customer.setCustomerId(rst.getInt(1));
				customer.setCusAccount(rst.getInt(2));
				customer.setCusName(rst.getString(3));
				customer.setCusTel(rst.getString(4));
				customer.setCusEmail(rst.getString(5));
				address.setAddCont(rst.getString(6));
				addsmall.setAddSmallCont(rst.getString(7));
				customer.setAddDetails(rst.getString(8));
				customer.setAddsmall(addsmall);
				addsmall.setAddress(address);
				customers.add(customer);
			}
			
			return customers;
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
	public void updateOneCustomer(Customer customer) {
		String sql ="update customer set cusAccount=?,cusName=?,cusTel=?,cusEmail=?,addsmallId=?,addDetails=? where customerId=?";
		SQLUtil.executeUpdate(sql,customer.getCusAccount(),customer.getCusName(),customer.getCusTel(),customer.getCusEmail(),customer.getAddSmallId(),customer.getAddDetails(),customer.getCustomerId());
		System.out.println("sql="+customer.getCusAccount()+"\n"+customer.getCusName()+"\n"+customer.getCusTel()+"\n"+customer.getCusEmail()+"\n"+customer.getAddSmallId()+"\n"+customer.getAddDetails()+"\n"+customer.getCustomerId());
	}

	@Override
	public Customer findOneCustomerById(int customerId) {
		String sql="SELECT customer.customerId,customer.cusAccount,customer.cusName,customer.cusTel,customer.cusEmail,\r\n" + 
				"addsmall.addSmallCont,address.addCont,customer.addDetails FROM customer INNER JOIN addsmall ON customer.addSmallId = addsmall.addSmallId INNER JOIN address ON addsmall.addressId = address.addressId\r\n" + 
				"WHERE customerId=?";
		ResultSet rst=SQLUtil.executeQuery(sql,customerId);
		try {
			if(rst.next()) {
				Customer customer=new Customer();
				Addsmall addsmall=new Addsmall();
				Address address=new Address();
				customer.setCustomerId(rst.getInt(1));
				customer.setCusAccount(rst.getInt(2));
				customer.setCusName(rst.getString(3));
				customer.setCusTel(rst.getString(4));
				customer.setCusEmail(rst.getString(5));
				addsmall.setAddSmallCont(rst.getString(6));
				address.setAddCont(rst.getString(7));
				customer.setAddDetails(rst.getString(8));
				addsmall.setAddress(address);
				customer.setAddsmall(addsmall);
				return customer;
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
	public void deleteOneCustomer(int customerId) {
		// TODO Auto-generated method stub
		String sql="delete from customer where customerId=?";
		SQLUtil.executeUpdate(sql, customerId);
	}

	@Override
	public Customer findCustomerByInfo(int cusAccount, int customerPwd) {
		//SQL语句
		
				String sql="SELECT customer.customerId,customer.cusAccount,customer.cusName,customer.cusTel,customer.customerPwd,customer.customerPic,customer.cusEmail,\r\n" + 
						"address.addCont,addsmall.addSmallCont,customer.addDetails,customer.cuspost FROM customer INNER JOIN addsmall ON customer.addSmallId = addsmall.addSmallId\r\n" + 
						"INNER JOIN address ON addsmall.addressId = address.addressId WHERE cusAccount=? and customerPwd=?";
				//SQLUtil执行SQL语句
				ResultSet rst=SQLUtil.executeQuery(sql,cusAccount,customerPwd);
				System.out.println(rst);
				//判断结果集
				try {
					if(rst.next()) {
					
					//把当前记录提取出来
					Customer customer=new Customer();
					Addsmall addsmall=new Addsmall();
					Address address=new Address();
					customer.setCustomerId(rst.getInt(1));
					customer.setCusAccount(rst.getInt(2));
					customer.setCusName(rst.getString(3));
					customer.setCusTel(rst.getString(4));
					customer.setCustomerPwd(rst.getInt(5));
					customer.setCustomerPic(rst.getString(6));
					customer.setCusEmail(rst.getString(7));
					address.setAddCont(rst.getString(8));
					addsmall.setAddSmallCont(rst.getString(9));
					customer.setAddDetails(rst.getString(10));
					customer.setCuspost(rst.getString(11));
					addsmall.setAddress(address);
					customer.setAddsmall(addsmall);
					
					
			
				
					return customer;
					
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
	public List<Customer> selectfindCustomerByorderId(int orderId) {
		String sql="SELECT customer.cusName, customer.cusTel,customer.addDetails,customer.customerId,`order`.orderId FROM\r\n" + 
				"customer INNER JOIN `order` ON `order`.customerId = customer.customerId WHERE customer.customerId=?";
		ResultSet rst=SQLUtil.executeQuery(sql,orderId);
		List<Customer> customers=new ArrayList<>();
		try {
			while(rst.next()) {
				Order order=new Order();
				Customer customer=new Customer();
				customer.setCusName(rst.getString(1));
				customer.setCusTel(rst.getString(2));
				customer.setAddDetails(rst.getString(3));
				customer.setCustomerId(rst.getInt(4));
				order.setOrderId(rst.getInt(5));
				customers.add(customer);
				
			}
			return customers;
			
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


