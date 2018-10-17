package com.login.Lz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.login.Lz.Bean.NewsInfo;
import com.login.Lz.Bean.Proclass;
import com.login.Lz.Bean.Product;
import com.login.Lz.Service.Proclasservice;
import com.login.Lz.Service.Productservice;


/**
 * Servlet implementation class productHandler
 */
@MultipartConfig
@WebServlet("/productocl")
public class productHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Productservice productService=new Productservice();
	private Proclasservice proclassService =new Proclasservice();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productHandler() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("12...");
		String action=request.getParameter("action");
		if("getall".equals(action)) {
			List<Product> products1=productService.getAllProduct();
			request.setAttribute("products", products1);
			System.out.println("product"+products1);
			//System.out.println(123);
			request.getRequestDispatcher("Admin/product.jsp").forward(request, response);
		}
		if("getsort".equals(action)) {
			List<Proclass> proclass=proclassService.selectAllProclass();
			request.setAttribute("proclass", proclass);
			
			//System.out.println(123);
			request.getRequestDispatcher("Admin/proclass.jsp").forward(request, response);
		}
		if("sort".equals(action)) {
			int proclassId=Integer.parseInt(request.getParameter("proclassId"));
			List<Product> proclass=proclassService.selectsort(proclassId);
			request.setAttribute("products",proclass);
			System.out.println("proclass"+proclass);
			request.getRequestDispatcher("Admin/proSort.jsp").forward(request, response);
		}
		if("delete".equals(action)) {
			//提取图书编号
			int proId=Integer.parseInt(request.getParameter("proId"));
			productService.deleteOneProduct(proId);
			response.sendRedirect("productocl?action=getall");
		}
		if("updateget".equals(action)) {
			int proId=Integer.parseInt(request.getParameter("proId"));
			List<Proclass> proclass=proclassService.selectAllProclass();
			request.setAttribute("proclass",proclass);
			Product product=productService.getOneProductById(proId);
			request.setAttribute("product",product);
			request.getRequestDispatcher("Admin/edit.jsp").forward(request, response);
		}
		if("addpro".equals(action)) {
			List<Proclass> proclass=proclassService.selectAllProclass();
			request.setAttribute("proclass",proclass);
			request.getRequestDispatcher("Admin/add.jsp").forward(request, response);
		}
		if("select".equals(action)) {
			int proId=Integer.parseInt(request.getParameter("proId"));
			Product product=productService.getOneProductById(proId);
			request.setAttribute("product",product);
			request.getRequestDispatcher("Product/proDetails.jsp").forward(request, response);
		}
	}

	
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
			Part part=request.getPart("proPic");
			//获取请求信息
			System.out.println("part="+part);
			String name=part.getHeader("content-disposition");
			System.out.println("name="+name);
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
			Product product=new Product();
			String proname=request.getParameter("proName");
			float proprice=Float.parseFloat(request.getParameter("proPrice"));
			String proinfo=request.getParameter("proInfo");
			String prodetails=request.getParameter("proDetails");
			int proclassId=Integer.parseInt(request.getParameter("proclassId"));
			String propic=dburl;
			
			//存到对象中
		
			product.setProName(proname);
			product.setProPrice(proprice);
			product.setProInfo(proinfo);
			product.setProPic(propic);
			product.setProDetails(prodetails);
			product.setProClassId(proclassId);
			//调用方法
			productService.addOneProduct(product);
			PrintWriter out=response.getWriter();
			out.println("<script>alert('添加成功！');location.href='productocl?action=getall';</script>");
			//response.sendRedirect("productocl?action=getall");
		}
		if("updatedo".equals(action)) {
			String filename=null;
			int proId=Integer.parseInt(request.getParameter("proId"));
			System.out.println(proId);
			Product product=productService.getOneProductById(proId);
			String dburl=product.getProPic();
			//获取上传文件
			try {
			Part part=request.getPart("proPic");
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
			int proid=Integer.parseInt(request.getParameter("proId"));
			String proname=request.getParameter("proName");
			float proprice=Float.parseFloat(request.getParameter("proPrice"));
			String proinfo=request.getParameter("proInfo");
			String prodetails=request.getParameter("proDetails");
			String propic=dburl;
			int proclassId=Integer.parseInt(request.getParameter("proclassId"));
			Product product1=new Product();
			product1.setProId(proid);
			product1.setProName(proname);
			product1.setProPrice(proprice);
			product1.setProInfo(proinfo);
			product1.setProPic(propic);
			product1.setProDetails(prodetails);
			product1.setProClassId(proclassId);
			productService.updateOneProduct(product1);
			PrintWriter out=response.getWriter();
			out.println("<script>alert('更新成功！');location.href='productocl?action=getall';</script>");
		}
	}

}

