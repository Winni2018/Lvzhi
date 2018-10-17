<%@page import="com.login.Lz.Bean.Proclass"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%
    	String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.print(basePath);
    %>
<%
	List<Proclass> proClass=(List<Proclass>)request.getAttribute("proclass");
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<script src="bootstrap-3.3.4-dist/jquery-3.3.1.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.4-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.4-dist/css/bootstrap-theme.min.css"/>
<script type="text/javascript" src="bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
<style type="text/css">
	a{
		font-size: 10px;
		color: black;
	}
</style>
</head>
<body>
<h3 align="center">商品分类</h3>
<table class="table table-striped">
	<thead>
   <tr>
		<td>编号</td>
		<td>名称</td>
		<td>操作</td>
		
	</tr>
    </thead>
    <tbody>
    <%
	for(Proclass proclass: proClass){
	%>
	<tr>
		<td><%=proclass.getProClassId()%></td>
		<td><%=proclass.getProClassname()%></td>
		<td><a href="productocl?action=sort&proclassId=<%=proclass.getProClassId()%>"><h6>查看</h6></a>  </td>
		
		
	</tr>
	<%} %>
    </tbody>
	
	
	
</table>
</body>
</html>