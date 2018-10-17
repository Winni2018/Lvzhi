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
	Carousel carousel=(Carousel)request.getAttribute("carousel");
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
<script src="Admin/utf8-jsp/ueditor.config.js"></script>
<script src="Admin/utf8-jsp/ueditor.all.min.js"></script>
<script src="Admin/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<h3 align="center">更新</h3>
<form action="carousel?action=updatedo" method="post" enctype="multipart/form-data">
<input name="imgId" type="hidden" value="<%=carousel.getImgId() %>" />
<table class="table" align="center">
	<tr>
		<td>名称：</td>
		<td><input name="imgName" type="text" value="<%=carousel.getImgName()%>" /></td>
	</tr>
	
	<tr>
		<td>图片：</td>
		<td><input name="imgPic" type="file" value="<%=carousel.getImgPic() %>" /></td>
	</tr>
		<tr>
		<td>标题：</td>
		<td><input name="imgTitle" type="text" value="<%=carousel.getImgTitle()%>" /></td>
	</tr>
	<tr>
		<td>详情：</td>
		<td><script id="container" name="imgDetails" type="text/plain" charset="utf-8" style="height:200px">
			 
		 </script>
		 <script type="text/javascript" charset="utf-8">
		 UE.getEditor('container');
			 
		 </script>
		 </td>
	</tr>
	
	<tr>
		<td colspan="2" align="center"><input type="submit" value="更新"><input type="reset" value="重置" /></td>
	</tr>
</table>
</form>
</body>
</html>