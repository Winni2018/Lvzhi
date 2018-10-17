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
	List<Order> orders=(List<Order>)request.getAttribute("orders");
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
</head>
<h3 align="center">订单信息浏览</h3>
<table class="table table-striped">
	<thead>
   <tr>
		<td>订单编号</td>
		<td>创建时间</td>
		<td>用户账号</td>
		<td>商品名称</td>
		<td>订单金额</td>
		<td>订单状态</td>
		<td colspan="6" >操作</td>
	</tr>
    </thead>
    <tbody>
    <%
	for(Order order:orders){
	%>
	<tr>
		<td><%=order.getOrderId()%></td>
		<td><%=order.getOrderTime() %></td>
		<td><%=order.getCustomer().getCusAccount()%></td>
		<td><%=order.getProduct().getProName()%></td>
		<td><%=order.getOrderPrice() %></td>
		<td><%=order.getOrderStatus()%></td>

	

		<td colspan="4">
			<img src="Admin/img/gengxin.png" class="icon" width="20px" height="20px"/>
			<a href="order?action=orderDetail&orderId=<%=order.getOrderId() %>">
				查看订单
			</a>
			
			
		</td>
		<td colspan="4">
			
			<img src="Admin/img/del.png" class="icon" width="20px" height="20px"/>
			<a href="order?action=delete&orderId=<%=order.getOrderId() %>">
			删除订单
			</a>
		</td>
	</tr>
	<%} %>
    </tbody>
	
	
	
</table>
</body>
</html>