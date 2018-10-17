package com.login.Lz.Service;

import java.util.List;

import com.login.Lz.Bean.NewsSort;
import com.login.Lz.dao.INewsSort;
import com.login.dao.impl.NewsSortDaoImpl;


public class NewsSortservice {
	private INewsSort NewsSortDao=new NewsSortDaoImpl();
	public List<NewsSort> SetlectAllNewsSort(){
		return NewsSortDao.SetlectAllNewsSort();
	}
}
