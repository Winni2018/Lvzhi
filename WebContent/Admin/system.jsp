<%@page import="com.login.Lz.Bean.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%
    	String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.print(basePath);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<script src="bootstrap-3.3.4-dist/jquery-3.3.1.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.4-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.4-dist/css/bootstrap-theme.min.css"/>
<script type="text/javascript" src="bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
<style type="text/css">
	.table{
		width: 60%;
		margin-left: 15%;
		margin-top: 10%;
	}
	.td1{
	width:250px;
	background:#f7f7f7;
	}
	tr{
	height:50px;
	line-height:50px;
	}
	
</style>
</head>
<body>
<table class="table table-bordered">
	<tr><td class="td1">操作系统</td><td>Windows7/8/10</td></tr>
	<tr><td class="td1">Web服务器</td><td>Tomcat v7.0</td></tr>
	<tr><td class="td1">MySQL版本</td><td>5.6.30</td></tr>
	<tr><td class="td1">编码</td><td>UTF-8</td></tr>
	<tr><td class="td1">文件上传的最大大小</td><td>40M</td></tr>

</table>
</body>
</html>