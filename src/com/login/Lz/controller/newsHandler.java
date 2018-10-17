package com.login.Lz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.login.Lz.Bean.Carousel;
import com.login.Lz.Bean.NewsInfo;
import com.login.Lz.Bean.NewsSort;
import com.login.Lz.Bean.Proclass;
import com.login.Lz.Bean.Product;
import com.login.Lz.Service.CarouselService;
import com.login.Lz.Service.NewsInfoservice;
import com.login.Lz.Service.NewsSortservice;
import com.login.Lz.dao.INewsSort;
import com.login.dao.impl.NewsSortDaoImpl;


/**
 * Servlet implementation class newsHandler
 */
@MultipartConfig
@WebServlet("/news")
public class newsHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NewsInfoservice newsInfoservice=new NewsInfoservice();
    private NewsSortservice newsSortservice=new NewsSortservice();
    private CarouselService carouselService=new CarouselService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newsHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param newsId 
	 * @param newsort 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<NewsInfo> newsInfos=newsInfoservice.selectNewsInfo();
		List<NewsInfo> newsInfos1=newsInfoservice.selectNewsInfo1();
		List<NewsInfo> newsInfos2=newsInfoservice.selectNewsSort();
		List<NewsInfo> newsInfos3=newsInfoservice.findOneNews();
		List<NewsInfo> newsInfos4=newsInfoservice.findOneNews1();
		List<NewsInfo> newsInfos5=newsInfoservice.findOneNews2();
		List<Carousel> carousels=carouselService.findNewsCarousel();
		List<Carousel> carousels1=carouselService.findNewsCarousel1();
		request.setAttribute("newsInfos", newsInfos);
		request.setAttribute("newsInfos", newsInfos1);
		request.setAttribute("newsInfos", newsInfos2);
		request.setAttribute("newsInfos", newsInfos3);
		request.setAttribute("newsInfos", newsInfos4);
		request.setAttribute("newsInfos", newsInfos5);
		request.setAttribute("carousels", carousels);
		request.setAttribute("carousels", carousels1);
		String action=request.getParameter("action");
		if("getall".equals(action)) {
			System.out.println("getall........");
			List<NewsInfo> newsInfos11=newsInfoservice.getAllnewsInfo();
			
			request.setAttribute("newsInfos", newsInfos11);
			
			System.out.println("newsInfos"+newsInfos11);
			//System.out.println(123);
		
			request.getRequestDispatcher("Admin/news.jsp").forward(request, response);
		}
		if("delete".equals(action)) {
	
			int newsId=Integer.parseInt(request.getParameter("newsId"));
			newsInfoservice.deleteOneNewsInfo(newsId);
			response.sendRedirect("news?action=getall");
		}
		if("update".equals(action)) {
			System.out.println("news.......");
			int newsId=Integer.parseInt(request.getParameter("newsId"));
			List<NewsSort> newssort=newsSortservice.SetlectAllNewsSort();
			request.setAttribute("newssort",newssort);
			NewsInfo newsInfo=newsInfoservice.findOneNewsInfoById(newsId);
			request.setAttribute("newsInfo",newsInfo);
			request.getRequestDispatcher("Admin/newsedit.jsp").forward(request, response);
		}
		if("addnews".equals(action)) {
			
			List<NewsSort> newssort=newsSortservice.SetlectAllNewsSort();
			request.setAttribute("newssort",newssort);
			request.getRequestDispatcher("Admin/newsadd.jsp").forward(request, response);
			
		}
		if("select".equals(action)) {
			int newsId=Integer.parseInt(request.getParameter("newsId"));
			NewsInfo newsInfo=newsInfoservice.findOneNewsInfoById(newsId);
			request.setAttribute("newsInfo",newsInfo);
			request.getRequestDispatcher("News/newsDetails.jsp").forward(request, response);
		}
	}

	/**
	 * @param <SimpleDateFormat>
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action=request.getParameter("action");
		
		if("add".equals(action)) {
			String filename=null;
			String dburl=null;
			
			//获取上传文件
			try {
			Part part=request.getPart("newsPic");
			
			//获取请求信息
			String name=part.getHeader("content-disposition");
			System.out.println("name"+name);
			//获取文件上传真实路径
			String root=request.getServletContext().getRealPath("/upload");
			System.out.println("root="+root);
			//取出上传文件的后缀名
			String str=name.substring(name.lastIndexOf("."),name.length()-1);
			String ram=UUID.randomUUID().toString()+str;
			filename=root+"\\"+ram;
			dburl="upload/"+ram;
			//实现图片上传
			part.write(filename);
			System.out.println("上传文件成功");
			}catch(Exception e) {
				 e.printStackTrace();
				 request.setAttribute("info", "上传文件失败");
			}
			//提取表单数据
			NewsInfo newsInfo=new NewsInfo();
			
			String newstitle=request.getParameter("newsTitle");
			String newsinfo=request.getParameter("newsInfo");
			SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
			Date newsdate=null;
			try {
				newsdate = sdf.parse(request.getParameter("newsDate"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String newspic=dburl;
			String newsdetails=request.getParameter("newsDetails");
			int newsSortId=Integer.parseInt(request.getParameter("newsSortId"));

			//存到对象中
		
			newsInfo.setNewsTitle(newstitle);
			newsInfo.setNewsInfo(newsinfo);
			newsInfo.setNewsDate(newsdate);
			newsInfo.setNewsPic(newspic);
			newsInfo.setNewsDetails(newsdetails);
			newsInfo.setNewsSortId(newsSortId);
			//调用方法
			newsInfoservice.addOneNewsInfo(newsInfo);
			System.out.println("abc123.......");
			PrintWriter out=response.getWriter();
			out.println("<script>alert('添加成功！');location.href='news?action=getall';</script>");
			//response.sendRedirect("productocl?action=getall");
		}
		
		if("update".equals(action)) {
		
			String filename=null;
			int newsId=Integer.parseInt(request.getParameter("newsId"));
			System.out.println(newsId);
			System.out.println("update........");
			NewsInfo newsInfo=newsInfoservice.findOneNewsInfoById(newsId);
			String dburl=newsInfo.getNewsPic();
			
			//获取上传文件
			try {
			Part part=request.getPart("newsPic");
			if(part.getSize()==0) {
				System.out.println("null");
			}else {
				
			//获取请求信息
			String name=part.getHeader("content-disposition");
			//获取文件上传真实路径
			String root=request.getServletContext().getRealPath("/upload");
			//取出上传文件的后缀名
			String str=name.substring(name.lastIndexOf("."),name.length()-1);
			String ram=UUID.randomUUID().toString()+str;
			filename=root+"\\"+ram;
			dburl="upload/"+ram;
			//实现图片上传
			part.write(filename);
			}
			System.out.println("上传文件成功");
			}catch(Exception e) {
				 e.printStackTrace();
				 request.setAttribute("info", "上传文件失败");
			}
			int newsid=Integer.parseInt(request.getParameter("newsId"));
			String newstitle=request.getParameter("newsTitle");
			String newsinfo=request.getParameter("newsInfo");
			SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
			Date newsdate=null;
			try {
				newsdate = sdf.parse(request.getParameter("newsDate"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String newspic=dburl;
			String newsdetails=request.getParameter("newsDetails");
			int newsSortId=Integer.parseInt(request.getParameter("newsSortId"));
		
			NewsInfo newsInfo1=new NewsInfo();
			newsInfo1.setNewsId(newsid);
			newsInfo1.setNewsTitle(newstitle);
			System.out.println("newstitle"+newstitle);
			newsInfo1.setNewsInfo(newsinfo);
			newsInfo1.setNewsDate(newsdate);
			newsInfo1.setNewsPic(newspic);
			newsInfo1.setNewsDetails(newsdetails);
			newsInfo1.setNewsSortId(newsSortId);
			newsInfoservice.updateOneNewsInfo(newsInfo1);
			PrintWriter out=response.getWriter();
			out.println("<script>alert('更新成功！');location.href='news?action=getall';</script>");
		}
		
		
	}

}
