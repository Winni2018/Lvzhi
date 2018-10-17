package com.login.Lz.dao;

import java.util.List;

import com.login.Lz.Bean.Customer;
import com.login.Lz.Bean.Order;
import com.login.Lz.Bean.User;

public interface ICustomer {
	public List<Customer> findAllCustomer();
	void updateOneCustomer(Customer customer);
	Customer findOneCustomerById(int customerId);
	void deleteOneCustomer(int customerId);
	Customer findCustomerByInfo(int cusAccount,int customerPwd);
	public List<Customer> selectfindCustomerByorderId(int orderId);

}
