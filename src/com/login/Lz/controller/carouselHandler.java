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

import com.login.Lz.Bean.Carousel;
import com.login.Lz.Bean.Product;
import com.login.Lz.Service.CarouselService;
import com.login.Lz.Service.Productservice;

/**
 * Servlet implementation class carouselHandler
 */
@MultipartConfig
@WebServlet("/carousel")
public class carouselHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarouselService carouselService=new CarouselService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public carouselHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action");
		if("getall".equals(action)) {
			System.out.println("action.......");
			List<Carousel> carousels=carouselService.findAllCarousel();
			request.setAttribute("carousels", carousels);
			System.out.println("carousel"+carousels);
			//System.out.println(123);
			request.getRequestDispatcher("Admin/carousel.jsp").forward(request, response);
		}
		if("delete".equals(action)) {
			//��ȡͼ����
			int imgId=Integer.parseInt(request.getParameter("imgId"));
			carouselService.deleteOneCarousel(imgId);
			response.sendRedirect("carousel?action=getall");
		}
		if("update".equals(action)) {
			int imgId=Integer.parseInt(request.getParameter("imgId"));
			Carousel carousel=carouselService.findOneCarouselById(imgId);
			request.setAttribute("carousel",carousel);
			request.getRequestDispatcher("Admin/carouselEdit.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action=request.getParameter("action");
		if("updatedo".equals(action)) {
			String filename=null;
			int imgId=Integer.parseInt(request.getParameter("imgId"));
			System.out.println(imgId);
			Carousel carousel=carouselService.findOneCarouselById(imgId);
			String dburl=carousel.getImgPic();
			//��ȡ�ϴ��ļ�
			try {
			Part part=request.getPart("imgPic");
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
			int imgid=Integer.parseInt(request.getParameter("imgId"));
			String imgname=request.getParameter("imgName");
			String imgtitle=request.getParameter("imgTitle");
			String imgdetails=request.getParameter("imgDetails");
			String imgpic=dburl;
			
			Carousel carousel1=new Carousel();
			carousel1.setImgId(imgid);
			carousel1.setImgName(imgname);
			carousel1.setImgTitle(imgtitle);
			carousel1.setImgDetails(imgdetails);
			carousel1.setImgPic(imgpic);
			carouselService.updateOneCarousel(carousel1);
			PrintWriter out=response.getWriter();
			out.println("<script>alert('���³ɹ���');location.href='carousel?action=getall';</script>");
		}
	}

}
