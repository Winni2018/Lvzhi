package com.login.Lz.dao;

import java.util.List;

import com.login.Lz.Bean.Cart;



public interface ICart {
	public List<Cart> selectcart(int customerId);
}
