package com.login.Lz.Service;

import java.util.List;

import com.login.Lz.Bean.AboutUs;
import com.login.Lz.Bean.Product;
import com.login.Lz.dao.IAboutUs;
import com.login.dao.impl.AboutUsDaoImpl;

public class AboutUsService {
	private IAboutUs aboutUsDao=new AboutUsDaoImpl();
	public List<AboutUs> FindAllAboutInfo(){
		return aboutUsDao.FindAllAboutInfo();
		
	}
	public List<AboutUs> selectAboutInfo(){
		return aboutUsDao.selectAboutInfo();
		
	}
	public List<AboutUs> selectAboutInfo1(){
		return aboutUsDao.selectAboutInfo1();
		
	}
	public List<AboutUs> selectAboutInfo2(){
		return aboutUsDao.selectAboutInfo2();
		
	}
	public List<AboutUs> selectAboutInfo3(){
		return aboutUsDao.selectAboutInfo3();
		
	}
	public void deleteOneAboutUs(int aboutId) {
		aboutUsDao.deleteOneAboutUs(aboutId);
	}
	public AboutUs findOneAboutUsById(int aboutId) {
		return aboutUsDao.findOneAboutUsById(aboutId);
	}
	public void updateOneAboutUs(AboutUs aboutInfo) {
		aboutUsDao.updateOneAboutUs(aboutInfo);
	}
}
