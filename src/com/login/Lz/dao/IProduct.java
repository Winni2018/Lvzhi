package com.login.Lz.dao;

import java.util.List;


import com.login.Lz.Bean.Product;

public interface IProduct {
	public List<Product> findAllProduct();
	void deleteOneProduct(int proId);
	void insertOneProduct(Product product);
	Product findOneProductById(int proId);
	void updateOneProduct(Product product);
	//public Product findoneproductbyproId(int proId);
	public List<Product> selectProduct();
	public List<Product> selectProduct1();
	public List<Product> ProductDuorou();
	public List<Product> ProductZuhe();
	public List<Product> ProductDetails();
	public List<Product> Productlist();
}
