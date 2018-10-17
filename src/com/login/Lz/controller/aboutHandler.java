package com.login.Lz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.login.Lz.Bean.AboutUs;
import com.login.Lz.Bean.NewsInfo;
import com.login.Lz.Bean.Proclass;
import com.login.Lz.Bean.Product;
import com.login.Lz.Service.AboutUsService;
import com.login.Lz.Service.NewsInfoservice;

/**
 * Servlet implementation class aboutHandler
 */
@MultipartConfig
@WebServlet("/aboutHandler")
public class aboutHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AboutUsService aboutUsservice=new AboutUsService();
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public aboutHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<AboutUs> aboutInfos=aboutUsservice.selectAboutInfo();
		List<AboutUs> aboutInfos1=aboutUsservice.selectAboutInfo1();
		List<AboutUs> aboutInfos2=aboutUsservice.selectAboutInfo2();
		List<AboutUs> aboutInfos3=aboutUsservice.selectAboutInfo3();
		request.setAttribute("aboutInfos", aboutInfos);
		String action=request.getParameter("action");
		if("getall".equals(action)) {
			List<AboutUs> aboutInfos4=aboutUsservice.FindAllAboutInfo();
			request.setAttribute("aboutInfos", aboutInfos4);
			//System.out.println(123);
			request.getRequestDispatcher("Admin/about.jsp").forward(request, response);
		}
		if("delete".equals(action)) {
			int aboutId=Integer.parseInt(request.getParameter("aboutId"));
			aboutUsservice.deleteOneAboutUs(aboutId);
			response.sendRedirect("aboutHandler?action=getall");
		}
		if("updateget".equals(action)) {
			int aboutId=Integer.parseInt(request.getParameter("aboutId"));
			AboutUs aboutInfo=aboutUsservice.findOneAboutUsById(aboutId);
			request.setAttribute("aboutInfo",aboutInfo);
			request.getRequestDispatcher("Admin/aboutEdit.jsp").forward(request, response);
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
		if("update".equals(action)) {
			System.out.println("updatedo..");
			String filename=null;
			System.out.println(request.getParameter("aboutId"));
			int aboutId=Integer.parseInt(request.getParameter("aboutId"));
			
			AboutUs aboutInfo=aboutUsservice.findOneAboutUsById(aboutId);
			
			String dburl=aboutInfo.getAboutPic();
			//��ȡ�ϴ��ļ�
			try {
			Part part=request.getPart("aboutPic");
			if(part.getSize()==0) {
				System.out.println("null");
			}else {
				
			//��ȡ������Ϣ
			String name=part.getHeader("content-disposition");
			//��ȡ�ļ��ϴ���ʵ·��
			String root=request.getServletContext().getRealPath("/upload");
			//ȡ���ϴ��ļ��ĺ�׺��
			String str=name.substring(name.lastIndexOf("."),name.length()-1);
			String ram=UUID.randomUUID().toString()+str;
			filename=root+"\\"+ram;
			dburl="upload/"+ram;
			//ʵ��ͼƬ�ϴ�
			part.write(filename);
			}
			System.out.println("�ϴ��ļ��ɹ�");
			}catch(Exception e) {
				 e.printStackTrace();
				 request.setAttribute("info", "�ϴ��ļ�ʧ��");
			}
			int aboutid=Integer.parseInt(request.getParameter("aboutId"));
			String abouttitle=request.getParameter("aboutTitle");
			String aboutinfo=request.getParameter("aboutInfo");

			String aboutpic=dburl;
			AboutUs aboutInfo1=new AboutUs();
			aboutInfo1.setAboutId(aboutid);
			aboutInfo1.setAboutTitle(abouttitle);
			aboutInfo1.setAboutInfo(aboutinfo);
			aboutInfo1.setAboutPic(dburl);
			
		
			aboutUsservice.updateOneAboutUs(aboutInfo1);
			PrintWriter out=response.getWriter();
			System.out.println(aboutInfo1);
			out.println("<script>alert('���³ɹ���');location.href='aboutHandler?action=getall';</script>");
		}
	}

}
