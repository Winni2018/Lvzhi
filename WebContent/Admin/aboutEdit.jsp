<%@page import="com.login.Lz.Bean.*"%>
<%@page import="com.login.Lz.Service.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.print(basePath);
    AboutUs aboutInfo = (AboutUs)request.getAttribute("aboutInfo");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<script src="bootstrap-3.3.4-dist/jquery-3.3.1.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.4-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.4-dist/css/bootstrap-theme.min.css"/>
<script type="text/javascript" src="bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
<script src="Admin/utf8-jsp/ueditor.config.js"></script>
<script src="Admin/utf8-jsp/ueditor.all.min.js"></script>
<script src="Admin/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<title>Insert title here</title>
<style type="text/css">
	input{
	border:0;
	}
	.info{
	width:70%;
	}
</style>
</head>
<body>
<h3 align="center">更新</h3>
<form action="aboutHandler?action=update" method="post" enctype="multipart/form-data">
<input name="aboutId" type="hidden" value="<%=aboutInfo.getAboutId() %>" />
<table class="table" align="center">
	<tr>
		<td>标题：</td>
		<td><input name="aboutTitle" type="text" value="<%=aboutInfo.getAboutTitle() %>" /></td>
	</tr>
	<tr>
		<td>信息：</td>
		<td><script id="container" name="aboutInfo" type="text/plain" charset="utf-8" style="height:200px">
			 
		 </script>
		 <script type="text/javascript" charset="utf-8">
		 UE.getEditor('container');
			 
		 </script>
		 </td>
	</tr>
	<tr>
		<td>图片：</td>
		<td><input name="aboutPic" type="file" value="<%=aboutInfo.getAboutPic() %>" /></td>
	</tr>
	

	<tr>
		<td colspan="2" align="center"><input type="submit" value="更新"><input type="reset" value="重置" /></td>
	</tr>
</table>
</form>
</body>
</html>