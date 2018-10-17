package com.login.Lz.Service;

import java.util.List;

import com.login.Lz.Bean.Customer;
import com.login.Lz.Bean.Product;
import com.login.Lz.Bean.User;
import com.login.Lz.dao.ICustomer;
import com.login.dao.impl.CustomerDaoImpl;


public class Customerservice {
	private ICustomer customerDao=new CustomerDaoImpl();
	public List<Customer> findAllCustomer(){
		return customerDao.findAllCustomer();
	}
	public void updateOneCustomer(Customer customer) {
		customerDao.updateOneCustomer(customer);
	}
	public Customer findOneCustomerById(int customerId) {
		return customerDao.findOneCustomerById(customerId);
	}
	public void deleteOneCustomer(int customerId) {
		customerDao.deleteOneCustomer(customerId);
	}
	public List<Customer> selectfindCustomerByorderId(int order) {
		return customerDao.selectfindCustomerByorderId(order);
	}
	//µÇÂ¼·½·¨
	public Customer customerLogin(int cusAccount,int customerPwd) {
		Customer customer=customerDao.findCustomerByInfo(cusAccount, customerPwd);
		return customer;
	}
}
