<%@page import="com.login.Lz.Bean.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
    	String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.print(basePath);
    %>
    <%
	List<Carousel> carousels=(List<Carousel>)request.getAttribute("carousels");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<script src="bootstrap-3.3.4-dist/jquery-3.3.1.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.4-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.4-dist/css/bootstrap-theme.min.css"/>
<script type="text/javascript" src="bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="Admin/css/product.css"/>
<style type="text/css">
	a{
		font-size: 10px;
		color: black;
	}
</style>
</head>
<body>
<h3 align="center">轮播图片浏览</h3>
<table class="table table-striped">
	<thead>
   <tr>
		<td>编号</td>
		<td>名称</td>
		<td>图片</td>
		<td>标题</td>
		<td>详情</td>
		<td colspan="6" >操作</td>
	</tr>
    </thead>
    <tbody>
    <%
	for(Carousel carousel:carousels){
	%>
	<tr>
		<td><%=carousel.getImgId() %></td>
		<td><%=carousel.getImgName() %></td>
		<td><img class="imgpic" src="<%=carousel.getImgPic() %>" ></td>
		<td><%=carousel.getImgTitle()%></td>
		<td><%=carousel.getImgDetails()%></td>

		
		
		
		<td colspan="4">
			<img src="Admin/img/gengxin.png" class="icon"/>
			<a href="carousel?action=update&imgId=<%=carousel.getImgId() %>">
				更新
			</a>
			
			
		</td>
		<td colspan="4">
			
			<img src="Admin/img/del.png" class="icon"/>
			<a href="carousel?action=delete&imgId=<%=carousel.getImgId() %>">
			删除
			</a>
		</td>
	</tr>
	<%} %>
    </tbody>
	
	
	
</table>
</body>
</html>