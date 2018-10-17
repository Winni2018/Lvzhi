package com.login.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.Lz.Bean.Cart;
import com.login.Lz.Bean.Customer;
import com.login.Lz.Bean.Proclass;
import com.login.Lz.Bean.Product;
import com.login.Lz.Util.SQLUtil;
import com.login.Lz.dao.ICart;

public class CartDaoImpl implements ICart {

	@Override
	public List<Cart> selectcart(int customerId) {
		String sql="SELECT cart.cartId,cart.proId,product.proName,product.proPic,product.proPrice,cart.cartNo,\r\n" + 
				"cart.customerId FROM cart INNER JOIN product ON cart.proId = product.proId INNER JOIN customer ON cart.customerId = customer.customerId WHERE cart.customerId = ?";
		ResultSet rst=SQLUtil.executeQuery(sql,customerId);
		List<Cart> carts=new ArrayList<>();
		try {
			while(rst.next()) {
			Cart cart=new Cart();
			Product product=new Product();
			Customer customer=new Customer();
			cart.setCartId(rst.getInt(1));
			cart.setProId(rst.getInt(2));
			cart.setProduct(product);
			product.setProPic(rst.getString(4));
			product.setProName(rst.getString(3));
			product.setProPrice(rst.getFloat(5));
			cart.setCartNo(rst.getInt(6));
			cart.setCustomerId(rst.getInt(7));
			cart.setCustomer(customer);
			
		
			carts.add(cart);
			
			}
			return carts;
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
