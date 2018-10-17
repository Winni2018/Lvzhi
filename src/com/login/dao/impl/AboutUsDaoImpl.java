package com.login.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.Lz.Bean.AboutUs;
import com.login.Lz.Bean.NewsInfo;
import com.login.Lz.Bean.Proclass;
import com.login.Lz.Bean.Product;
import com.login.Lz.Util.SQLUtil;
import com.login.Lz.dao.IAboutUs;

public class AboutUsDaoImpl implements IAboutUs {

	@Override
	public List<AboutUs> selectAboutInfo() {
		String sql="SELECT * from about ORDER BY aboutId limit 0,1";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<AboutUs> aboutInfos=new ArrayList<>();
		try {
			while(rst.next()) {
			
				AboutUs aboutInfo=new AboutUs();
				aboutInfo.setAboutId(rst.getInt(1));
				aboutInfo.setAboutTitle(rst.getString(2));
				aboutInfo.setAboutInfo(rst.getString(3));
				aboutInfo.setAboutPic(rst.getString(4));
				aboutInfos.add(aboutInfo);
			}
			return aboutInfos;
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
	public List<AboutUs> selectAboutInfo1() {
		String sql="SELECT * from about ORDER BY aboutId limit 0,4";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<AboutUs> aboutInfos1=new ArrayList<>();
		try {
			while(rst.next()) {
			
				AboutUs aboutInfo1=new AboutUs();
				aboutInfo1.setAboutId(rst.getInt(1));
				aboutInfo1.setAboutTitle(rst.getString(2));
				aboutInfo1.setAboutInfo(rst.getString(3));
				aboutInfo1.setAboutPic(rst.getString(4));
				aboutInfos1.add(aboutInfo1);
			}
			return aboutInfos1;
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
	public List<AboutUs> selectAboutInfo2() {
		String sql="SELECT * from about ORDER BY aboutId limit 4,4";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<AboutUs> aboutInfos=new ArrayList<>();
		try {
			while(rst.next()) {
			
				AboutUs aboutInfo=new AboutUs();
				aboutInfo.setAboutId(rst.getInt(1));
				aboutInfo.setAboutTitle(rst.getString(2));
				aboutInfo.setAboutInfo(rst.getString(3));
				aboutInfo.setAboutPic(rst.getString(4));
				aboutInfos.add(aboutInfo);
			}
			return aboutInfos;
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
	public List<AboutUs> selectAboutInfo3() {
		String sql="SELECT * from about ORDER BY aboutId desc limit 0,4";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<AboutUs> aboutInfos=new ArrayList<>();
		try {
			while(rst.next()) {
			
				AboutUs aboutInfo=new AboutUs();
				aboutInfo.setAboutId(rst.getInt(1));
				aboutInfo.setAboutTitle(rst.getString(2));
				aboutInfo.setAboutInfo(rst.getString(3));
				aboutInfo.setAboutPic(rst.getString(4));
				aboutInfos.add(aboutInfo);
			}
			return aboutInfos;
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
	public List<AboutUs> FindAllAboutInfo() {
		String sql="SELECT * from about ORDER BY aboutId desc";
		ResultSet rst=SQLUtil.executeQuery(sql);
		List<AboutUs> aboutInfos=new ArrayList<>();
		try {
			while(rst.next()) {
			
				AboutUs aboutInfo=new AboutUs();
				aboutInfo.setAboutId(rst.getInt(1));
				aboutInfo.setAboutTitle(rst.getString(2));
				aboutInfo.setAboutInfo(rst.getString(3));
				aboutInfo.setAboutPic(rst.getString(4));
				aboutInfos.add(aboutInfo);
			}
			return aboutInfos;
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
	public void deleteOneAboutUs(int aboutId) {
		// TODO Auto-generated method stub
		String sql="delete from about where aboutId=?";
		SQLUtil.executeUpdate(sql, aboutId);
	}

	@Override
	public AboutUs findOneAboutUsById(int aboutId) {
		//����SQL
				String sql = "SELECT * from about WHERE aboutId=?";
				//ִ��SQL����ѽ������rst
				ResultSet rst=SQLUtil.executeQuery(sql,aboutId);
				//�ѽ�����е����м�¼ת�浽������
				try {
					if(rst.next()) {
						//�ѵ�ǰ��¼ת��һ��product
						AboutUs aboutInfo=new AboutUs();
						aboutInfo.setAboutId(rst.getInt(1));
						aboutInfo.setAboutTitle(rst.getString(2));
						aboutInfo.setAboutInfo(rst.getString(3));
						aboutInfo.setAboutPic(rst.getString(4));
						return aboutInfo;		
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
	public void updateOneAboutUs(AboutUs aboutInfo) {
		// TODO Auto-generated method stub
		String sql ="update about set aboutTitle=?,aboutInfo=?,aboutPic=? where aboutId=?";
		SQLUtil.executeUpdate(sql,aboutInfo.getAboutTitle(),aboutInfo.getAboutInfo(),aboutInfo.getAboutPic(),aboutInfo.getAboutId());
	}

}
