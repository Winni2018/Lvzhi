package com.login.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.Lz.Bean.NewsSort;
import com.login.Lz.Util.SQLUtil;
import com.login.Lz.dao.INewsSort;

public class NewsSortDaoImpl implements INewsSort {

	@Override
	public List<NewsSort> SetlectAllNewsSort() {
		// TODO Auto-generated method stub
				String sql="SELECT * FROM newssort ORDER BY newsSortId DESC";
				ResultSet rst=SQLUtil.executeQuery(sql);
				List<NewsSort> newsSort=new ArrayList<>();
				try {
					while(rst.next()) {
						NewsSort newssort=new NewsSort();
						newssort.setNewsSortId(rst.getInt(1));
						newssort.setNewsSortName(rst.getString(2));
						newsSort.add(newssort);
					}
					return newsSort;
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
