package com.login.Lz.Bean;

import java.util.Date;

public class NewsInfo {
	private int newsId;
	private String newsTitle;
	private String newsInfo;
	private Date newsDate;
	private String newsPic;
	private String newsDetails;
	private int newsSortId;
	private NewsSort newsSort;
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsInfo() {
		return newsInfo;
	}
	public void setNewsInfo(String newsInfo) {
		this.newsInfo = newsInfo;
	}
	
	public String getNewsPic() {
		return newsPic;
	}
	public void setNewsPic(String newsPic) {
		this.newsPic = newsPic;
	}
	public String getNewsDetails() {
		return newsDetails;
	}
	public void setNewsDetails(String newsDetails) {
		this.newsDetails = newsDetails;
	}
	public int getNewsSortId() {
		return newsSortId;
	}
	public void setNewsSortId(int newsSortId) {
		this.newsSortId = newsSortId;
	}
	public NewsSort getNewsSort() {
		return newsSort;
	}
	public void setNewsSort(NewsSort newsSort) {
		this.newsSort = newsSort;
	}
	public Date getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}
	
}
