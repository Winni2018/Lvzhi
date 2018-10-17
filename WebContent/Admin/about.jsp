<%@page import="com.login.Lz.Bean.*"%>
<%@page import="com.login.Lz.Service.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.print(basePath);
    AboutUsService aboutUsservice=new AboutUsService();
    %>
 <%
 List<AboutUs> aboutInfos=aboutUsservice.FindAllAboutInfo();

 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.4-dist/css/bootstrap.min.css"/>
<script src="bootstrap-3.3.4-dist/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
<script src="bootstrap-3.3.4-dist/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="Admin/css/product.css"/>
</head>
<body>
<h3 align="center">公司信息浏览</h3>
<table class="table table-striped">
	<thead>
   <tr>
		<td>编号</td>
		<td>标题</td>
		<td>信息</td>
		<td>图片</td>

		<td colspan="6" >操作</td>
	</tr>
    </thead>
    <tbody>
    <%
	for(AboutUs aboutInfo:aboutInfos){
	%>
	<tr>
		<td><%=aboutInfo.getAboutId()%></td>
		<td><%=aboutInfo.getAboutTitle() %></td>
		<td><%=aboutInfo.getAboutInfo() %></td>
		<td><img class="imgpic" src="<%=aboutInfo.getAboutPic()%>" ></td>
		
		
		<td colspan="4">
			<img src="Admin/img/gengxin.png" class="icon"/>
			<a href="aboutHandler?action=updateget&aboutId=<%=aboutInfo.getAboutId() %>">
				更新
			</a>
			
			
		</td>
		<td colspan="4">
			
			<img src="Admin/img/del.png" class="icon"/>
			<a href="aboutHandler?action=delete&aboutId=<%=aboutInfo.getAboutId() %>">
			删除
			</a>
		</td>
	</tr>
	<%} %>
    </tbody>
	
	
	
</table>
</body>
</html>