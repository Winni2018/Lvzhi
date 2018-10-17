<%@page import="com.login.Lz.Bean.*"%>
<%@page import="com.login.Lz.Service.*"%>
<%@page import="java.util.List"%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
  Customerservice customerService=new Customerservice();
  OrderService orderservice=new OrderService();
  Customer customer=(Customer)session.getAttribute("customer");
%>
<%
int customerId=Integer.parseInt(request.getParameter("customerId"));
List<Order> orders=(List<Order>)orderservice.selectallOrderBycusId(customerId);
%>
<h4>我的订单</h4>
<form>
<table class="table table-striped table-bordered">
<tr>
		<td>订单编号</td>
		<td>订单状态</td>
		<td>创建时间</td>
		<td>订单金额</td>
		<td>商品名称</td>

</tr>
<%
	for(Order order:orders){
	%>
<tr>

		<td><%=order.getOrderId() %></td>
		<td><%=order.getOrderStatus() %></td>
		<td><%=order.getOrderTime() %></td>
		<td><%=order.getOrderPrice() %></td>
		<td><%=order.getProduct().getProName()%></td>
		

		

</tr>
<%} %>
</table>
</form>
<p>暂没有相关记录</p>