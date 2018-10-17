package com.login.Lz.Service;

import java.util.List;

import com.login.Lz.Bean.Cart;
import com.login.Lz.dao.ICart;
import com.login.dao.impl.CartDaoImpl;

public class CartService {
	private ICart cartDao=new CartDaoImpl();
	public List<Cart> selectcart(int customerId){
		return cartDao.selectcart(customerId);
	}
}
