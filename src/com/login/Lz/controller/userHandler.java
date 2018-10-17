package com.login.Lz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.Lz.Bean.User;
import com.login.Lz.Service.Userservice;

/**
 * Servlet implementation class userHandler
 */
@WebServlet("/userocl")
public class userHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Userservice userService=new Userservice(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if("logout".equals(action)) {
			HttpSession session=request.getSession();
			session.removeAttribute("user");
			response.sendRedirect("Admin/login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//提取动作参数
		String action=request.getParameter("action");
		//登录
		if("login".equals(action)) {
			//提取表单数据
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			//判断
			User user=userService.userLogin(username, password);
			System.out.println(username);
			if(user!=null) {
				//在会话中记录用户信息
				request.getSession().setAttribute("user", user);
				//重定向的主页面
				response.sendRedirect("Admin/main.jsp");
			
			}else {
				request.setAttribute("errmsg", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request,response);
				
			}
		}
	}

}
