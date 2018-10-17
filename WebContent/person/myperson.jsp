<%@page import="com.login.Lz.Bean.*"%>
<%@page import="com.login.Lz.Service.*"%>
<%@page import="java.util.List"%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	Customer customer=(Customer)session.getAttribute("customer");
%>
<h4>我的个人中心</h4>
<div class="row myperson">
	<div class="col-md-6 col-xs-6 col-sm-6 right1-left">
		<img src="<%=customer.getCustomerPic()%>" width="60px" height="60px" class="img-circle" />
		<span><%=customer.getCusName()%></span>
	</div>
	<div class="col-md-6 col-xs-6 col-sm-6 right1-right">
		<h5>账户安全：普通</h5>
		<h5>绑定手机：<%=customer.getCusTel()%></h5>
		<h5>绑定邮箱：<%=customer.getCusEmail()%></h5>

	</div>
</div>
