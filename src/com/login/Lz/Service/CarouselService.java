package com.login.Lz.Service;

import java.util.List;

import com.login.Lz.Bean.Carousel;
import com.login.Lz.Bean.Product;
import com.login.Lz.dao.ICarousel;
import com.login.dao.impl.CarouselDaoImpl;

public class CarouselService {
	private ICarousel carouselDao=new CarouselDaoImpl();
	public List<Carousel> findAllCarousel(){
		return carouselDao.findAllCarousel();
	}
	public List<Carousel> findHomeCarousel(){
		return carouselDao.findHomeCarousel();
	}
	public List<Carousel> findHomeCarousel1(){
		return carouselDao.findHomeCarousel1();
	}
	public List<Carousel> findHomeCarousel2(){
		return carouselDao.findHomeCarousel2();
	}
	public List<Carousel> findNewsCarousel(){
		return carouselDao.findNewsCarousel();
	}
	public List<Carousel> findNewsCarousel1(){
		return carouselDao.findNewsCarousel1();
	}
	public void deleteOneCarousel(int imgId) {
		carouselDao.deleteOneCarousel(imgId);
	}
	public Carousel findOneCarouselById(int imgId) {
		return carouselDao.findOneCarouselById(imgId);
	}
	public void updateOneCarousel(Carousel carousel) {
		carouselDao.updateOneCarousel(carousel);
	}
}
