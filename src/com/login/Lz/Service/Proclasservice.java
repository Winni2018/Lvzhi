package com.login.Lz.Service;

import java.util.List;

import com.login.Lz.Bean.Proclass;
import com.login.Lz.Bean.Product;
import com.login.Lz.dao.IProClass;
import com.login.dao.impl.ProclassDaoImpl;

public class Proclasservice {
	private IProClass ProclassDao=new ProclassDaoImpl();
	public List<Proclass> selectAllProclass(){
		return ProclassDao.selectAllProclass();
	}
	public List<Product> selectsort(int proclassId){
		return ProclassDao.selectsort(proclassId);
	}
	
	
	
}
