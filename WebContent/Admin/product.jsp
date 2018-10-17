<%@page import="com.login.Lz.Bean.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%
    	String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.print(basePath);
    %>
<%
	List<Product> products=(List<Product>)request.getAttribute("products");
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
<link rel="stylesheet" type="text/css" href="Admin/css/product.css"/>
<style type="text/css">
	a{
		font-size: 10px;
		color: black;
	}
</style>
</head>
<body>
<h3 align="center">商品信息浏览</h3>
<table class="table table-striped">
	<thead>
   <tr>
		<td>编号</td>
		<td>名称</td>
		<td>价格</td>
		<td>信息</td>
		<td>图片</td>
		<td>详情</td>
		<td>分类</td>
		<td colspan="6" >操作</td>
	</tr>
    </thead>
    <tbody>
    <%
	for(Product product:products){
	%>
	<tr>
		<td><%=product.getProId() %></td>
		<td><%=product.getProName() %></td>
		<td><%=product.getProPrice() %></td>
		<td><%=product.getProInfo() %></td>
		<td><img class="imgpic" src="<%=product.getProPic() %>" ></td>
		<td><%=product.getProDetails() %></td>
		<td><%=product.getProclass().getProClassname()%></td>
		
		
		<td colspan="4">
			<img src="Admin/img/gengxin.png" class="icon"/>
			<a href="productocl?action=updateget&proId=<%=product.getProId() %>">
				更新
			</a>
			
			
		</td>
		<td colspan="4">
			
			<img src="Admin/img/del.png" class="icon"/>
			<a href="productocl?action=delete&proId=<%=product.getProId() %>">
			删除
			</a>
		</td>
	</tr>
	<%} %>
    </tbody>
	
	
	
</table>
</body>
</html>