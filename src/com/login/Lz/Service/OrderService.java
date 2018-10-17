package com.login.Lz.Service;

import java.util.List;
import com.login.Lz.Bean.Order;
import com.login.Lz.Bean.Product;
import com.login.Lz.dao.IOrder;
import com.login.dao.impl.OrderDaoImpl;

public class OrderService {
	private IOrder orderDao=new OrderDaoImpl();
	public List<Order> findAllOrder(){
		return orderDao.findAllOrder();
		
	}
	public Order findOneOrderById(int orderId) {
		return orderDao.findOneOrderById(orderId);
	}
	public Order findOneOrder(int customerId) {
		return orderDao.findOneOrder(customerId);
	}
	public  List<Order> selectallOrderBycusId(int customerId) {
		return orderDao.selectallOrderBycusId(customerId);
	}
	public void deleteOneOrder(int orderId) {
		orderDao.deleteOneOrder(orderId);
		
	}

}
