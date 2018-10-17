package com.login.Lz.dao;

import java.util.List;

import com.login.Lz.Bean.Order;


public interface IOrder {
	public List<Order> findAllOrder();
	Order findOneOrderById(int orderId);
	void selectOneOrder(Order order);
	Order findOneOrder(int customerId);
	public List<Order> selectallOrderBycusId(int customerId);
	 void deleteOneOrder(int orderId);
	
}
