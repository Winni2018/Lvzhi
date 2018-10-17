<%@page import="com.login.Lz.Bean.*"%>
<%@page import="com.login.Lz.Service.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.print(basePath);
    %>
       <%
       Customerservice customerService=new Customerservice();
       Product product = (Product)request.getAttribute("product");
       Customer customer=(Customer)session.getAttribute("customer");
       OrderService orderservice=new OrderService();
       int orderId=Integer.parseInt(request.getParameter("orderId"));
       Order order=orderservice.findOneOrderById(orderId);
    
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
<link rel="stylesheet" type="text/css" href="Admin/css/product.css"/>
<style type="text/css">
	.table{
		width:80%;
		margin-left:10%;
	}
</style>
</head>
<body>



<table class="table table-striped">
<h4 align="center">订单详情</h4>
	<thead>
   <tr>
		<td>订单编号</td>
		<td>创建时间</td>
		<td>用户编号</td>
		<td>商品编号</td>
		<td>订单金额</td>
		<td>订单状态</td>
	</tr>
    </thead>
    <tbody>

	<tr>
		<td><%=order.getOrderId()%></td>
		<td><%=order.getOrderTime() %></td>
		<td><%=order.getCustomerId()%></td>
		<td><%=order.getProId()%></td>
		<td><%=order.getOrderPrice() %></td>
		<td><%=order.getOrderStatus()%></td>
		
	
	</tr>

    </tbody>	
</table>

<table class="table table-striped">
<h4 align="center">收货人信息</h4>
	<thead>
   <tr>
		<td>收货人</td>
		<td>手机号码</td>
		<td>收货地址</td>
		
	</tr>
    </thead>
    <tbody>

	<tr>
		<td name="cusName"><%=order.getCustomer().getCusName()%></td>
		<td name="cusTel"><%=order.getCustomer().getCusTel()%></td>
		<td name="addDetails"><%=order.getCustomer().getAddDetails()%></td>
	</tr>

    </tbody>	
</table>

<table class="table table-striped">
<h4 align="center">商品信息</h4>
	<thead>
   <tr>
		<td>商品编号</td>
		<td>名称</td>
		<td>图片</td>
		<td>金额</td>
		
	</tr>
    </thead>
    <tbody>

	<tr>
		<td><%=order.getProId()%></td>
		<td><%=order.getProduct().getProName() %></td>
		<td><img src="<%=order.getProduct().getProPic()%>" width="60px" height="60px"></td>
		<td><%=order.getProduct().getProPrice()%></td>
	</tr>

    </tbody>	
</table>
</body>
</html>