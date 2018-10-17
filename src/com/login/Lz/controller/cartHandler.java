package com.login.Lz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.Lz.Bean.Cart;
import com.login.Lz.Bean.Order;
import com.login.Lz.Service.CartService;
import com.login.Lz.Service.Productservice;

/**
 * Servlet implementation class cartHandler
 */
@WebServlet("/cartHandler")
public class cartHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartService cartservice=new CartService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if("select".equals(action)) {
			System.out.println("findCart13....");
			int customerId=Integer.parseInt(request.getParameter("customerId"));
			System.out.println("customerId"+customerId);
			List<Cart> carts=cartservice.selectcart(customerId);
			request.setAttribute("cart",carts);
			request.setAttribute("customerId",customerId);
			request.getRequestDispatcher("person/cart.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
