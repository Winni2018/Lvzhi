package com.login.Lz.Service;

import java.util.List;

import com.login.Lz.Bean.NewsInfo;
import com.login.Lz.Bean.Product;
import com.login.Lz.dao.INewsInfo;
import com.login.dao.impl.NewsInfoDaoImpl;

public class NewsInfoservice {
	private INewsInfo newsInfoDao=new NewsInfoDaoImpl();
	public List<NewsInfo> selectNewsInfo(){
		return newsInfoDao.selectNewsInfo();
		
	}
	public void addOneNewsInfo(NewsInfo newsInfo) {
		newsInfoDao.addOneNewsInfo(newsInfo);
	}
	public void deleteOneNewsInfo(int newsId) {
		newsInfoDao.deleteOneNewsInfo(newsId);
	}
	public NewsInfo findOneNewsInfoById(int newsId) {
		return newsInfoDao.findOneNewsInfoById(newsId);
	}
	public void updateOneNewsInfo(NewsInfo newsInfo) {
		newsInfoDao.updateOneNewsInfo(newsInfo);
	}
	public List<NewsInfo> selectNewsInfo1(){
		return newsInfoDao.selectNewsInfo1();
		
	}
	public List<NewsInfo> selectNewsInfo2(){
		return newsInfoDao.selectNewsInfo2();
		
	}
	public List<NewsInfo> selectNewsInfo3(){
		return newsInfoDao.selectNewsInfo3();
		
	}
	public List<NewsInfo> selectNewsSort(){
		return newsInfoDao.selectNewsSort();
		
	}
	public List<NewsInfo> findOneNews() {
		return newsInfoDao.findOneNews();
	}
	public List<NewsInfo> findOneNews1() {
		return newsInfoDao.findOneNews1();
	}
	public List<NewsInfo> findOneNews2() {
		return newsInfoDao.findOneNews2();
	}
	public List<NewsInfo> getAllnewsInfo() {
		return newsInfoDao.getAllnewsInfo();
	}
	public List<NewsInfo> Newsapplication(){
		return newsInfoDao.Newsapplication();
	}
}
