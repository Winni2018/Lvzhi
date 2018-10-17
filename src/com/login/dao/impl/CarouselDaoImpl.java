package com.login.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.Lz.Bean.Carousel;
import com.login.Lz.Bean.Proclass;
import com.login.Lz.Bean.Product;
import com.login.Lz.Util.SQLUtil;
import com.login.Lz.dao.ICarousel;

public class CarouselDaoImpl implements ICarousel {

	@Override
	public List<Carousel> findAllCarousel() {
		String sql="SELECT * FROM carousel ORDER BY imgId DESC";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<Carousel> carousels=new ArrayList<>();
		try {
			while(rst.next()) {
			Carousel carousel=new Carousel();
			carousel.setImgId(rst.getInt(1));
			carousel.setImgName(rst.getString(2));
			carousel.setImgPic(rst.getString(3));
			carousel.setImgTitle(rst.getString(4));
			carousel.setImgDetails(rst.getString(5));
			carousels.add(carousel);
			
			}
			return carousels;
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

	@Override
	public List<Carousel> findHomeCarousel() {
		String sql="SELECT * FROM carousel ORDER BY imgId  LIMIT 0,1";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<Carousel> carousels=new ArrayList<>();
		try {
			while(rst.next()) {
			Carousel carousel=new Carousel();
			carousel.setImgId(rst.getInt(1));
			carousel.setImgName(rst.getString(2));
			carousel.setImgPic(rst.getString(3));
			carousel.setImgTitle(rst.getString(4));
			carousel.setImgDetails(rst.getString(5));
			carousels.add(carousel);
			
			}
			return carousels;
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

	@Override
	public List<Carousel> findNewsCarousel() {
		String sql="SELECT * FROM carousel ORDER BY imgId DESC LIMIT 1,1";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<Carousel> carousels=new ArrayList<>();
		try {
			while(rst.next()) {
			Carousel carousel=new Carousel();
			carousel.setImgId(rst.getInt(1));
			carousel.setImgName(rst.getString(2));
			carousel.setImgPic(rst.getString(3));
			carousel.setImgTitle(rst.getString(4));
			carousel.setImgDetails(rst.getString(5));
			carousels.add(carousel);
			
			}
			return carousels;
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

	@Override
	public List<Carousel> findHomeCarousel1() {
		String sql="SELECT * FROM carousel ORDER BY imgId  LIMIT 1,1";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<Carousel> carousels=new ArrayList<>();
		try {
			while(rst.next()) {
			Carousel carousel=new Carousel();
			carousel.setImgId(rst.getInt(1));
			carousel.setImgName(rst.getString(2));
			carousel.setImgPic(rst.getString(3));
			carousel.setImgTitle(rst.getString(4));
			carousel.setImgDetails(rst.getString(5));
			carousels.add(carousel);
			
			}
			return carousels;
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

	@Override
	public List<Carousel> findHomeCarousel2() {
		String sql="SELECT * FROM carousel ORDER BY imgId  LIMIT 2,1";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<Carousel> carousels=new ArrayList<>();
		try {
			while(rst.next()) {
			Carousel carousel=new Carousel();
			carousel.setImgId(rst.getInt(1));
			carousel.setImgName(rst.getString(2));
			carousel.setImgPic(rst.getString(3));
			carousel.setImgTitle(rst.getString(4));
			carousel.setImgDetails(rst.getString(5));
			carousels.add(carousel);
			
			}
			return carousels;
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

	@Override
	public List<Carousel> findNewsCarousel1() {
		String sql="SELECT * FROM carousel ORDER BY imgId DESC LIMIT 2,2";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<Carousel> carousels=new ArrayList<>();
		try {
			while(rst.next()) {
			Carousel carousel=new Carousel();
			carousel.setImgId(rst.getInt(1));
			carousel.setImgName(rst.getString(2));
			carousel.setImgPic(rst.getString(3));
			carousel.setImgTitle(rst.getString(4));
			carousel.setImgDetails(rst.getString(5));
			carousels.add(carousel);
			
			}
			return carousels;
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

	@Override
	public void deleteOneCarousel(int imgId) {
		String sql="delete from carousel where imgId=?";
		SQLUtil.executeUpdate(sql, imgId);
		
	}

	@Override
	public Carousel findOneCarouselById(int imgId) {
		String sql = "SELECT * FROM carousel  WHERE imgId=?";
		//执行SQL命令，把结果存入rst
		ResultSet rst=SQLUtil.executeQuery(sql,imgId);
	
		//Proclass proclass=null;

		//把结果集中的所有记录转存到集合中
		try {
			if(rst.next()) {
				//把当前记录转到一个product
				Carousel carousel=new Carousel();
				carousel.setImgId(rst.getInt(1));
				carousel.setImgName(rst.getString(2));
				carousel.setImgPic(rst.getString(3));
				carousel.setImgTitle(rst.getString(4));
				carousel.setImgDetails(rst.getString(5));
				
				
				return carousel;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void updateOneCarousel(Carousel carousel) {
		String sql ="update carousel set imgName=?,imgPic=?,imgDetails=?,imgTitle=? WHERE imgId=?";
		SQLUtil.executeUpdate(sql,carousel.getImgName(),carousel.getImgPic(),carousel.getImgDetails(),carousel.getImgTitle(),carousel.getImgId());
	}
	

}
