package com.login.dao.impl;

import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.Lz.Bean.NewsInfo;
import com.login.Lz.Bean.NewsSort;
import com.login.Lz.Util.SQLUtil;
import com.login.Lz.dao.INewsInfo;

public class NewsInfoDaoImpl implements INewsInfo {

	@Override
	public List<NewsInfo> selectNewsInfo() {
		String sql="SELECT * from news ORDER BY newsId limit 7,3";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<NewsInfo> newsInfos=new ArrayList<>();
		try {
			while(rst.next()) {
				NewsInfo newsInfo=new NewsInfo();
				NewsSort newssort=new NewsSort();
				newsInfo.setNewsId(rst.getInt(1));
				newsInfo.setNewsTitle(rst.getString(2));
				newsInfo.setNewsInfo(rst.getString(3));
				newsInfo.setNewsDate(rst.getDate(4));
				newsInfo.setNewsPic(rst.getString(5));
				newsInfo.setNewsDetails(rst.getString(6));
				newsInfo.setNewsSortId(rst.getInt(7));
				newssort.setNewsSortId(rst.getInt(7));
				//newssort.setNewsSortName(rst.getString(8));
				newsInfo.setNewsSort(newssort);
				newsInfos.add(newsInfo);
			}
			return newsInfos;
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
	public List<NewsInfo> selectNewsInfo1() {
		String sql="SELECT * from news ORDER BY newsId  limit 4,4";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<NewsInfo> newsInfos1=new ArrayList<>();
		
		try {
			while(rst.next()) {
				NewsInfo newsInfo1=new NewsInfo();
				NewsSort newssort=new NewsSort();
				newsInfo1.setNewsId(rst.getInt(1));
				newsInfo1.setNewsTitle(rst.getString(2));
				newsInfo1.setNewsInfo(rst.getString(3));
				newsInfo1.setNewsDate(rst.getDate(4));
				newsInfo1.setNewsPic(rst.getString(5));
				newsInfo1.setNewsDetails(rst.getString(6));
				newsInfo1.setNewsSortId(rst.getInt(7));
				newssort.setNewsSortId(rst.getInt(7));
				//newssort.setNewsSortName(rst.getString(8));
				newsInfo1.setNewsSort(newssort);
				newsInfos1.add(newsInfo1);
			}
			return newsInfos1;
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
	public List<NewsInfo> selectNewsSort() {
		String sql="SELECT * from news ORDER BY newsId limit 7,5";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<NewsInfo> newsInfos2=new ArrayList<>();
		
		try {
			while(rst.next()) {
				NewsInfo newsInfo2=new NewsInfo();
				NewsSort newssort=new NewsSort();
				newsInfo2.setNewsId(rst.getInt(1));
				newsInfo2.setNewsTitle(rst.getString(2));
				newsInfo2.setNewsInfo(rst.getString(3));
				newsInfo2.setNewsDate(rst.getDate(4));
				newsInfo2.setNewsPic(rst.getString(5));
				newsInfo2.setNewsDetails(rst.getString(6));
				newsInfo2.setNewsSortId(rst.getInt(7));
				newssort.setNewsSortId(rst.getInt(7));
				//newssort.setNewsSortName(rst.getString(8));
				newsInfo2.setNewsSort(newssort);
				newsInfos2.add(newsInfo2);
			}
			return newsInfos2;
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
	public List<NewsInfo> findOneNews() {
		String sql="SELECT * from news ORDER BY newsId limit 10,1";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<NewsInfo> newsInfos3=new ArrayList<>();
		try {
		while(rst.next()) {
			NewsInfo newsInfo3=new NewsInfo();
			NewsSort newssort=new NewsSort();
			newsInfo3.setNewsId(rst.getInt(1));
			newsInfo3.setNewsTitle(rst.getString(2));
			newsInfo3.setNewsInfo(rst.getString(3));
			newsInfo3.setNewsDate(rst.getDate(4));
			newsInfo3.setNewsPic(rst.getString(5));
			newsInfo3.setNewsDetails(rst.getString(6));
			newsInfo3.setNewsSortId(rst.getInt(7));
			newssort.setNewsSortId(rst.getInt(7));
			//newssort.setNewsSortName(rst.getString(8));
			newsInfo3.setNewsSort(newssort);
			newsInfos3.add(newsInfo3);
		}
		return newsInfos3;
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
	public List<NewsInfo> findOneNews1() {
		String sql="SELECT * from news ORDER BY newsId limit 11,1";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<NewsInfo> newsInfos4=new ArrayList<>();
		try {
		while(rst.next()) {
			NewsInfo newsInfo4=new NewsInfo();
			NewsSort newssort=new NewsSort();
			newsInfo4.setNewsId(rst.getInt(1));
			newsInfo4.setNewsTitle(rst.getString(2));
			newsInfo4.setNewsInfo(rst.getString(3));
			newsInfo4.setNewsDate(rst.getDate(4));
			newsInfo4.setNewsPic(rst.getString(5));
			newsInfo4.setNewsDetails(rst.getString(6));
			newsInfo4.setNewsSortId(rst.getInt(7));
			newssort.setNewsSortId(rst.getInt(7));
			//newssort.setNewsSortName(rst.getString(8));
			newsInfo4.setNewsSort(newssort);
			newsInfos4.add(newsInfo4);
		}
		return newsInfos4;
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
	public List<NewsInfo> findOneNews2() {
		String sql="SELECT * from news ORDER BY newsId limit 12,1";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<NewsInfo> newsInfos5=new ArrayList<>();
		try {
		while(rst.next()) {
			NewsInfo newsInfo5=new NewsInfo();
			NewsSort newssort=new NewsSort();
			newsInfo5.setNewsId(rst.getInt(1));
			newsInfo5.setNewsTitle(rst.getString(2));
			newsInfo5.setNewsInfo(rst.getString(3));
			newsInfo5.setNewsDate(rst.getDate(4));
			newsInfo5.setNewsPic(rst.getString(5));
			newsInfo5.setNewsDetails(rst.getString(6));
			newsInfo5.setNewsSortId(rst.getInt(7));
			newssort.setNewsSortId(rst.getInt(7));
			//newssort.setNewsSortName(rst.getString(8));
			newsInfo5.setNewsSort(newssort);
			newsInfos5.add(newsInfo5);
		}
		return newsInfos5;
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
	public List<NewsInfo> selectNewsInfo2() {
		String sql="SELECT * from news ORDER BY newsId  limit 7,4";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<NewsInfo> newsInfos6=new ArrayList<>();
		
		try {
			while(rst.next()) {
				NewsInfo newsInfo6=new NewsInfo();
				NewsSort newssort=new NewsSort();
				newsInfo6.setNewsId(rst.getInt(1));
				newsInfo6.setNewsTitle(rst.getString(2));
				newsInfo6.setNewsInfo(rst.getString(3));
				newsInfo6.setNewsDate(rst.getDate(4));
				newsInfo6.setNewsPic(rst.getString(5));
				newsInfo6.setNewsDetails(rst.getString(6));
				newsInfo6.setNewsSortId(rst.getInt(7));
				newssort.setNewsSortId(rst.getInt(7));
				//newssort.setNewsSortName(rst.getString(8));
				newsInfo6.setNewsSort(newssort);
				newsInfos6.add(newsInfo6);
			}
			return newsInfos6;
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
	public List<NewsInfo> selectNewsInfo3() {
		String sql="SELECT * from news ORDER BY newsId  limit 9,4";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<NewsInfo> newsInfos7=new ArrayList<>();
		
		try {
			while(rst.next()) {
				NewsSort newssort=new NewsSort();
				NewsInfo newsInfo7=new NewsInfo();
				newsInfo7.setNewsId(rst.getInt(1));
				newsInfo7.setNewsTitle(rst.getString(2));
				newsInfo7.setNewsInfo(rst.getString(3));
				newsInfo7.setNewsDate(rst.getDate(4));
				newsInfo7.setNewsPic(rst.getString(5));
				newsInfo7.setNewsDetails(rst.getString(6));
				newsInfo7.setNewsSortId(rst.getInt(7));
				newssort.setNewsSortId(rst.getInt(7));
				//newssort.setNewsSortName(rst.getString(8));
				newsInfo7.setNewsSort(newssort);
				newsInfos7.add(newsInfo7);
			}
			return newsInfos7;
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
	public List<NewsInfo> getAllnewsInfo() {
		String sql="SELECT news.newsId,news.newsTitle,news.newsInfo,news.newsDate,news.newsPic,news.newsDetails,news.newsSortId,newssort.newsSortName FROM newssort "
				+ "INNER JOIN news ON news.newsSortId = newssort.newsSortId ORDER BY newsId DESC";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<NewsInfo> newsInfos=new ArrayList<>();
		try {
			while(rst.next()) {
				NewsInfo newsInfo=new NewsInfo();
				NewsSort newssort=new NewsSort();
				newsInfo.setNewsId(rst.getInt(1));
				newsInfo.setNewsTitle(rst.getString(2));
				newsInfo.setNewsInfo(rst.getString(3));
				newsInfo.setNewsDate(rst.getDate(4));
				newsInfo.setNewsPic(rst.getString(5));
				newsInfo.setNewsDetails(rst.getString(6));
				newsInfo.setNewsSortId(rst.getInt(7));
				newssort.setNewsSortId(rst.getInt(7));
				newssort.setNewsSortName(rst.getString(8));
				newsInfo.setNewsSort(newssort);
				newsInfos.add(newsInfo);
			}
			return newsInfos;
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
	public void addOneNewsInfo(NewsInfo newsInfo) {
		// TODO Auto-generated method stub
		String sql="insert into news (newsTitle,newsInfo,newsDate,newsPic,newsDetails,newsSortId)values (?,?,?,?,?,?)";
		SQLUtil.executeUpdate(sql,newsInfo.getNewsTitle(),newsInfo.getNewsInfo(),newsInfo.getNewsDate(),newsInfo.getNewsPic(),newsInfo.getNewsDetails(),newsInfo.getNewsSortId());
	}

	@Override
	public void deleteOneNewsInfo(int newsId) {
		String sql="delete from news WHERE newsId=?";
		SQLUtil.executeUpdate(sql, newsId);
		
	}

	@Override
	public void updateOneNewsInfo(NewsInfo newsInfo) {
		String sql ="update news set newsTitle=?,newsInfo=?,newsDate=?,newsPic=?,newsDetails=?,newsSortId=? where newsId=?";
		SQLUtil.executeUpdate(sql,newsInfo.getNewsTitle(),newsInfo.getNewsInfo(),newsInfo.getNewsDate(),newsInfo.getNewsPic(),newsInfo.getNewsDetails(),newsInfo.getNewsSortId(),newsInfo.getNewsId());
		
	}

	@Override
	public NewsInfo findOneNewsInfoById(int newsId) {
		String sql="SELECT news.newsId,news.newsTitle,news.newsInfo,news.newsDate,news.newsPic,news.newsDetails,news.newsSortId,newssort.newsSortName FROM newssort INNER JOIN news ON "
				+ "news.newsSortId = newssort.newsSortId WHERE newsId=?";
		ResultSet rst=SQLUtil.executeQuery(sql,newsId);

		try {
			if(rst.next()) {
				NewsInfo newsInfo=new NewsInfo();
				NewsSort newssort=new NewsSort();
				newsInfo.setNewsId(rst.getInt(1));
				newsInfo.setNewsTitle(rst.getString(2));
				newsInfo.setNewsInfo(rst.getString(3));
				newsInfo.setNewsDate(rst.getDate(4));
				newsInfo.setNewsPic(rst.getString(5));
				newsInfo.setNewsDetails(rst.getString(6));
				newsInfo.setNewsSortId(rst.getInt(7));
				newssort.setNewsSortId(rst.getInt(7));
				newssort.setNewsSortName(rst.getString(8));
				newsInfo.setNewsSort(newssort);
				return newsInfo;
			}
			
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
	public List<NewsInfo> Newsapplication() {
		String sql="SELECT * from news ORDER BY newsId DESC limit 0,5";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<NewsInfo> newsInfos=new ArrayList<>();
		
		try {
			while(rst.next()) {
				NewsSort newssort=new NewsSort();
				NewsInfo newsInfo=new NewsInfo();
				newsInfo.setNewsId(rst.getInt(1));
				newsInfo.setNewsTitle(rst.getString(2));
				newsInfo.setNewsInfo(rst.getString(3));
				newsInfo.setNewsDate(rst.getDate(4));
				newsInfo.setNewsPic(rst.getString(5));
				newsInfo.setNewsDetails(rst.getString(6));
				newsInfo.setNewsSortId(rst.getInt(7));
				newssort.setNewsSortId(rst.getInt(7));
				//newssort.setNewsSortName(rst.getString(8));
				newsInfo.setNewsSort(newssort);
				newsInfos.add(newsInfo);
			}
			return newsInfos;
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
}
