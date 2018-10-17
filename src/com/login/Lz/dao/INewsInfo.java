package com.login.Lz.dao;

import java.util.List;

import com.login.Lz.Bean.NewsInfo;

public interface INewsInfo {
	public List<NewsInfo> selectNewsInfo();
	public List<NewsInfo> selectNewsInfo1();
	public List<NewsInfo> selectNewsInfo2();
	public List<NewsInfo> selectNewsInfo3();
	public List<NewsInfo> selectNewsSort();
	public List<NewsInfo> findOneNews();
	public List<NewsInfo> findOneNews1();
	public List<NewsInfo> findOneNews2();
	public List<NewsInfo> getAllnewsInfo();
	public List<NewsInfo> Newsapplication();
	void addOneNewsInfo(NewsInfo newsInfo);
	void deleteOneNewsInfo(int newsId);
	void updateOneNewsInfo(NewsInfo newsInfo);
	NewsInfo findOneNewsInfoById(int newsId);
}
