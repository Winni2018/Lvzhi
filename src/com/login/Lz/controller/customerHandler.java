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

import org.json.JSONArray;
import org.json.JSONObject;

import com.login.Lz.Bean.Address;
import com.login.Lz.Bean.Addsmall;
import com.login.Lz.Bean.Customer;
import com.login.Lz.Bean.User;
import com.login.Lz.Service.AddSmallService;
import com.login.Lz.Service.AddressService;
import com.login.Lz.Service.Customerservice;
import com.login.Lz.Service.OrderService;

/**
 * Servlet implementation class customerHandler
 */
@MultipartConfig
@WebServlet("/customer")
public class customerHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Customerservice customerService=new Customerservice();
    private AddressService addressService=new AddressService();
    private AddSmallService addsmallService=new AddSmallService();
    private OrderService orderService=new OrderService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public customerHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action=request.getParameter("action");
		if("getall".equals(action)) {
			
			List<Customer> customers=customerService.findAllCustomer();
			List<Address> address=addressService.selectAllAddress();
			List<Addsmall> addsmallList=addsmallService.selectAlladdSmall();
			request.setAttribute("customers", customers);
			request.setAttribute("address", address);
			request.setAttribute("addsmallList", addsmallList);
			request.getRequestDispatcher("Admin/customer.jsp").forward(request, response);
			System.out.println("getall.....");
		}
		if("update".equals(action)) {
			System.out.println("update......");
			int customerId=Integer.parseInt(request.getParameter("customerId"));
			List<Address> address=addressService.selectAllAddress();
			List<Addsmall> addsmallList=addsmallService.selectAlladdSmall();
			request.setAttribute("address",address);
			request.setAttribute("addsmallList",addsmallList);
			Customer customer=customerService.findOneCustomerById(customerId);
			request.setAttribute("customer",customer);
		
			request.getRequestDispatcher("Admin/customeredit.jsp").forward(request, response);
		}
		if("delete".equals(action)) {
			
			int customerId=Integer.parseInt(request.getParameter("customerId"));
			customerService.deleteOneCustomer(customerId);
			response.sendRedirect("customer?action=getall");
		}
	}

	/**
	 * @param order 
	 * @param addressId 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action=request.getParameter("action");
		
		if("updatedo".equals(action)) {
			int customerId=Integer.parseInt(request.getParameter("customerId"));
			System.out.println("update........"+customerId);
			Customer customer=customerService.findOneCustomerById(customerId);
			List<Address> address=addressService.selectAllAddress();
			List<Addsmall> addsmallList=addsmallService.selectAlladdSmall();
	
			int cusaccount=Integer.parseInt(request.getParameter("cusAccount"));
			String cusname=request.getParameter("cusName");
			String custel=request.getParameter("cusTel");
			String cusemail=request.getParameter("cusEmail");
			int addsmallId=Integer.parseInt(request.getParameter("addSmallId"));
			String adddetails=request.getParameter("addDetails");
			Customer customer1=new Customer();
			Address address1=new Address();
			Addsmall addsmall=new Addsmall();
			customer1.setCustomerId(customerId);
			customer1.setCusAccount(cusaccount);
			System.out.println("customer1getCusAccount="+customer1.getCusAccount());
			customer1.setCusName(cusname);
			customer1.setCusTel(custel);
			customer1.setCusEmail(cusemail);
			customer1.setAddSmallId(addsmallId);
			customer1.setAddDetails(adddetails);
			System.out.println("AddDetails="+customer1.getAddDetails());
			customerService.updateOneCustomer(customer1);
			PrintWriter out=response.getWriter();
			out.println("<script>alert('更新成功！');location.href='customer?action=getall';</script>");
		}
		if("addsmall".equals(action)) {
			System.out.println("addsmall.......");
			List<Address> address=addressService.selectAllAddress();

			JSONArray jsa=new JSONArray();
			int addressId=Integer.parseInt(request.getParameter("addressId"));
			System.out.println("addressId"+addressId);
			List<Addsmall> addsmallList=addsmallService.selectAlladdsmallByaddressId(addressId);
			for(int i=0;i<addsmallList.size();i++) {
				JSONObject jsonb=new JSONObject();
				jsonb.put("addSmallId", addsmallList.get(i).getAddSmallId());
				jsonb.put("addSmallCont", addsmallList.get(i).getAddSmallCont());
				jsonb.put("addressId", addsmallList.get(i).getAddressId());
				//jsonb.put("addressDetails", addsmallList.get(i).getAddressDetails());
				jsa.put(jsonb);
			}
			response.setContentType("text/json;charset=UTF-8");
			PrintWriter out=response.getWriter();
			System.out.println("jsa="+jsa.toString());
			out.println(jsa.toString());
		}
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
