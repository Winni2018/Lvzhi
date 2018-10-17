package com.login.Lz.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class SQLUtil {
	private static Properties pro = new Properties();
    private static Connection conn= null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    
    private static String driver;
    private static String url;
    private static String pwd;
    private static String user;
    
    static
    {
        try {
        	pro.load(SQLUtil.class.getResourceAsStream("dbinfo.properties"));
			// 寤虹珛鍏湁鐨勫睘鎬�
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			pwd = pro.getProperty("pwd");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static Connection getConnection()
    {
        try {
            conn = DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(conn);
        return conn;
    }
    
    //缁熶竴鐨勬煡璇elect
    public static ResultSet executeQuery(String sql,Object... parameters)
    {
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            // 閫氳繃寰幆鏇挎崲SQL鍛戒护涓殑闂彿
            for (int i = 0; i < parameters.length; i++) {
                ps.setObject(i + 1, parameters[i]);
            }
            rs = ps.executeQuery();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //鍏抽棴璧勬簮 鍦ㄨ皟鐢ㄧ殑鏈�鍚庡叧闂�  鐜板湪鍏抽棴浜�   璋冪敤鑰呭彇涓嶅埌璧勬簮
            //close(conn, ps, rs);
        }
        
        return rs;
    }
    
    //鎵ц涓�娆＄殑澧炪�佸垹銆佹敼
    public static void executeUpdate(String sql,Object... parameters)
    {
        conn = getConnection();
        try {
            ps = conn.prepareStatement(sql);
            // 閫氳繃寰幆鏇挎崲SQL鍛戒护涓殑闂彿
            for (int i = 0; i < parameters.length; i++) {
                ps.setObject(i + 1, parameters[i]);
            }
             ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }finally{
            close(conn, ps, rs);
        }
    }
    
    //鎵ц澧炪�佸垹銆佹敼(鎵归噺)
    public static void executeUpdateBatch(String sql,Object[][] parameters)
    {
        conn = getConnection();
        try {
        	conn.setAutoCommit(false); // 鍙栨秷浜嬪姟鑷姩鎻愪氦
            ps = conn.prepareStatement(sql);
            // 閫氳繃寰幆鏇挎崲SQL鍛戒护涓殑闂彿
            for (int i = 0; i < parameters.length; i++) {
            	for(int j=0; j < parameters[i].length; j++)
            		ps.setObject(j + 1, parameters[i][j]);
            	ps.addBatch(); // 娣诲姞鍒版壒閲忔搷浣�
            }
             ps.executeBatch(); // 鎵ц鎵归噺鎿嶄綔
             conn.commit(); // 鎻愪氦浜嬪姟
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        	try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }finally{
            close(conn, ps, rs);
        }
    }
    
    public static void close(Connection conn,PreparedStatement ps,ResultSet rs)
    {
        if(null != rs)
        {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            rs = null;
        }
        
        if(null != ps)
        {
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ps = null;
        }
        
        if(null != conn)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            conn = null;
        }
    }
    
    public static Connection getConn()
    {
        return conn;
    }
    
    public static PreparedStatement getPs()
    {
        return ps;
    }
    
    public static ResultSet getRs()
    {
        return rs;
    }
}