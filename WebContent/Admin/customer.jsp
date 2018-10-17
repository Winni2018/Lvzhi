<%@page import="com.login.Lz.Bean.*"%>
<%@page import="com.login.Lz.Service.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    	String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.print(basePath);
   Customerservice customerService=new Customerservice();
    AddressService addressService=new AddressService();
    AddSmallService addsmallService=new AddSmallService();

    %>
    
<%
List<Customer> customers=customerService.findAllCustomer();
List<Address> address=addressService.selectAllAddress();
List<Addsmall> addsmallList=addsmallService.selectAlladdSmall();
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
	a{
		font-size: 10px;
		color: black;
	}
</style>
</head>
<body>
<h3 align="center">用户信息浏览</h3>
<table class="table table-striped">
	<thead>
		<tr>
		<td>用户ID</td>
		<td>用户账号</td>
		<td>用户昵称</td>
		<td>电话</td>
		<td>邮箱</td>
		<td>城市</td>
		<td>市/区县</td>
		<td>详细地址</td>
		
		<td colspan="6" >操作</td>
	</tr>
	</thead>
	<tbody>
    <%
	for(Customer customer:customers){
	%>
	<tr>
		<td><%=customer.getCustomerId() %></td>
		<td><%=customer.getCusAccount()%></td>
		<td><%=customer.getCusName() %></td>
		<td><%=customer.getCusTel()%></td>
		<td><%=customer.getCusEmail()%></td>
		<td><%=customer.getAddsmall().getAddress().getAddCont()%></td>
		<td><%=customer.getAddsmall().getAddSmallCont()%></td>
		<td><%=customer.getAddDetails()%></td>
	
		
		
		<td colspan="4">
			<img src="Admin/img/gengxin.png" class="icon"/>
			<a href="customer?action=update&customerId=<%=customer.getCustomerId() %>">
				更新
			</a>
			
			
		</td>
		<td colspan="4">
			
			<img src="Admin/img/del.png" class="icon"/>
			<a href="customer?action=delete&customerId=<%=customer.getCustomerId() %>">
			删除
			</a>
		</td>
	</tr>
	<%} %>
    </tbody>
</table>
</body>
</html>