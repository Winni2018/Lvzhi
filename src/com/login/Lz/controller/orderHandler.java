package com.login.Lz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.Lz.Bean.Address;
import com.login.Lz.Bean.Addsmall;
import com.login.Lz.Bean.Customer;
import com.login.Lz.Bean.Order;
import com.login.Lz.Bean.Product;
import com.login.Lz.Service.Customerservice;
import com.login.Lz.Service.OrderService;
import com.login.Lz.Service.Productservice;

/**
 * Servlet implementation class orderHandler
 */
@MultipartConfig
@WebServlet("/order")
public class orderHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService orderservice=new OrderService();
	private Customerservice customerService=new Customerservice();
	private Productservice productService=new Productservice();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action=request.getParameter("action");
		
		if("getall".equals(action)) {
			
			List<Order> orders=orderservice.findAllOrder();
			
			request.setAttribute("orders", orders);
			
			System.out.println("order"+orders);
			//System.out.println(123);
		
			request.getRequestDispatcher("Admin/order.jsp").forward(request, response);
		}
			if("select".equals(action)) {
				System.out.println("findOner13....");
				int customerId=Integer.parseInt(request.getParameter("customerId"));
				System.out.println("customerId"+customerId);
				List<Order> orders=orderservice.selectallOrderBycusId(customerId);
				request.setAttribute("order",orders);
				request.setAttribute("customerId",customerId);
				System.out.println("order"+orders);
				request.getRequestDispatcher("person/order.jsp").forward(request, response);
			
			}
			if("orderDetail".equals(action)) {
				
				int orderId=Integer.parseInt(request.getParameter("orderId"));
				Order order=orderservice.findOneOrderById(orderId);
				request.setAttribute("order",order);
				
				
				System.out.println("orderId"+orderId);

				request.setAttribute("orderId",orderId);
				
				System.out.println("orderDetai.....");
				//int proId=Integer.parseInt(request.getParameter("proId"));
				//Product product=productService.getOneProductById(proId);
				//request.setAttribute("product",product);
				request.getRequestDispatcher("Admin/orderDetail.jsp").forward(request, response);
			
			}
			if("delete".equals(action)) {
				//Ã·»°Õº È±‡∫≈
				int orderId=Integer.parseInt(request.getParameter("orderId"));
				orderservice.deleteOneOrder(orderId);
				response.sendRedirect("order?action=getall");
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action=request.getParameter("action");
		
		if("findOne".equals(action)) {
			int orderId=Integer.parseInt(request.getParameter("orderId"));
			int customerId=Integer.parseInt(request.getParameter("customerId"));
			int proId=Integer.parseInt(request.getParameter("proId"));
			Order order=orderservice.findOneOrderById(orderId);
			Customer customer=customerService.findOneCustomerById(customerId);
			Product product=productService.getOneProductById(proId);
			
			int orderid=Integer.parseInt(request.getParameter("orderId"));
			SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
			Date ordertime=null;
			try {
				ordertime = sdf.parse(request.getParameter("orderTime"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			int cusaccount=Integer.parseInt(request.getParameter("cusAccount"));
			int proid=Integer.parseInt(request.getParameter("proId"));
			Float orderprice=Float.parseFloat(request.getParameter("orderPrice"));
			String orderstatus=request.getParameter("orderStatus");
			
			String cusname=request.getParameter("cusName");
			String custel=request.getParameter("cusTel");
			String adddetails=request.getParameter("addDetails");
			
			String proname=request.getParameter("proName");
			float proprice=Float.parseFloat(request.getParameter("proPrice"));
			
			String propic=request.getParameter("proPic");
			
			Order order1=new Order();
			Customer customer1=new Customer();
			Product product1=new Product();

			order1.setOrderId(orderid);
			order1.setOrderPrice(orderprice);
			order1.setOrderStatus(orderstatus);
			order1.setOrderTime(ordertime);
			customer1.setCusAccount(cusaccount);
			product1.setProId(proid);
			
			customer1.setCusName(cusname);
			customer1.setCusTel(custel);
			customer1.setAddDetails(adddetails);
			
			product1.setProName(proname);
			product1.setProPrice(proprice);
			product1.setProPic(propic);
			
			orderservice.findOneOrderById(orderId);
			customerService.findOneCustomerById(customerId);
			productService.getOneProductById(proId);
		
			
			PrintWriter out=response.getWriter();
			
		}
	}

}
