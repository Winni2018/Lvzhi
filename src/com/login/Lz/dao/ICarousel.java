package com.login.Lz.dao;

import java.util.List;

import com.login.Lz.Bean.Carousel;
import com.login.Lz.Bean.Product;

public interface ICarousel {
	public List<Carousel > findAllCarousel();
	public List<Carousel > findHomeCarousel();
	public List<Carousel > findHomeCarousel1();
	public List<Carousel > findHomeCarousel2();
	public List<Carousel > findNewsCarousel();
	public List<Carousel > findNewsCarousel1();
	void deleteOneCarousel(int imgId);
	Carousel findOneCarouselById(int imgId);
	void updateOneCarousel(Carousel carousel);
}
