package com.login.Lz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.Lz.Bean.Carousel;
import com.login.Lz.Bean.Customer;
import com.login.Lz.Bean.Product;
import com.login.Lz.Service.CarouselService;
import com.login.Lz.Service.Customerservice;
import com.login.Lz.Service.NewsInfoservice;
import com.login.Lz.Service.Productservice;

/**
 * Servlet implementation class index
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Productservice productService=new Productservice();
	private Customerservice customerService=new Customerservice();
	private CarouselService carouselService=new CarouselService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("1213..............");
		List<Product> products=productService.selectProduct();
		List<Product> products1=productService.selectProduct1();
		List<Product> products2=productService.ProductDuorou();
		List<Product> products5=productService.Productlist();
		List<Carousel> carousels=carouselService.findHomeCarousel();
		List<Carousel> carousels1=carouselService.findHomeCarousel1();
		List<Carousel> carousels2=carouselService.findHomeCarousel2();
		request.setAttribute("products", products);
		request.setAttribute("products", products1);
		request.setAttribute("products", products2);
		request.setAttribute("products", products5);
		request.setAttribute("carousels", carousels);
		request.setAttribute("carousels", carousels1);
		request.setAttribute("carousels", carousels2);

		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action=request.getParameter("action");
		if("login".equals(action)) {
			
			
			//提取表单数据
			int cusAccount=Integer.parseInt(request.getParameter("cusAccount"));
			int customerPwd=Integer.parseInt(request.getParameter("customerPwd"));
			String customerPic=request.getParameter("customerPic");
		
			//判断
			Customer customer=customerService.customerLogin(cusAccount, customerPwd);
			System.out.println(cusAccount);
			System.out.println(customerPwd);
			if(customer!=null) {
				System.out.println("登录.....");
				//在会话中记录用户信息
				request.getSession().setAttribute("customer", customer);
				//重定向的主页面
				response.sendRedirect("person/personIndex.jsp");
				
			
			}else {
				request.setAttribute("errmsg", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request,response);
				
			}
		}

	}

}
