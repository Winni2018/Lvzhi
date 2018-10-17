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
		//��ȡ��������
		String action=request.getParameter("action");
		//��¼
		if("login".equals(action)) {
			//��ȡ������
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			//�ж�
			User user=userService.userLogin(username, password);
			System.out.println(username);
			if(user!=null) {
				//�ڻỰ�м�¼�û���Ϣ
				request.getSession().setAttribute("user", user);
				//�ض������ҳ��
				response.sendRedirect("Admin/main.jsp");
			
			}else {
				request.setAttribute("errmsg", "�û������������");
				request.getRequestDispatcher("login.jsp").forward(request,response);
				
			}
		}
	}

}
