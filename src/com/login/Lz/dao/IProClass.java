package com.login.Lz.dao;

import java.util.List;

import com.login.Lz.Bean.Proclass;
import com.login.Lz.Bean.Product;

public interface IProClass {
	public List<Proclass> selectAllProclass();
	List<Product> selectsort(int proclassId);
}
