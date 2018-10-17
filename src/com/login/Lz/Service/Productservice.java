package com.login.Lz.Service;

import java.util.List;


import com.login.Lz.Bean.Product;
import com.login.Lz.dao.IProduct;
import com.login.dao.impl.ProductDaoImpl;

public class Productservice {

	private IProduct productDao=new ProductDaoImpl();

	
	public List<Product> getAllProduct(){
		return productDao.findAllProduct();
	}
	
	public void deleteOneProduct(int proId) {
		productDao.deleteOneProduct(proId);
	}
	public void addOneProduct(Product product) {
		productDao.insertOneProduct(product);
	}
	public Product getOneProductById(int proId) {
		return productDao.findOneProductById(proId);
	}
	public void updateOneProduct(Product product) {
		productDao.updateOneProduct(product);
	}
	public List<Product> selectProduct(){
		return productDao.selectProduct();
		
	}

	public List<Product> selectProduct1() {
		return productDao.selectProduct1();
	}
	public List<Product> ProductDuorou(){
		return productDao.ProductDuorou();
	}
	public List<Product> ProductZuhe(){
		return productDao.ProductZuhe();
	}
	public List<Product> ProductDetails(){
		return productDao.ProductDetails();
	
	}
	public List<Product> Productlist(){
		return productDao.Productlist();
	
	}
}
