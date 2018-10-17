package com.login.Lz.dao;

import java.util.List;

import com.login.Lz.Bean.AboutUs;
import com.login.Lz.Bean.Product;

public interface IAboutUs {
	public List<AboutUs> FindAllAboutInfo();
	public List<AboutUs> selectAboutInfo();
	public List<AboutUs> selectAboutInfo1();
	public List<AboutUs> selectAboutInfo2();
	public List<AboutUs> selectAboutInfo3();
	void deleteOneAboutUs(int aboutId);
	AboutUs findOneAboutUsById(int aboutId);
	void updateOneAboutUs(AboutUs aboutInfo);
}
