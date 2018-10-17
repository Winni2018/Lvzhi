<%@page import="com.login.Lz.Bean.*"%>
<%@page import="com.login.Lz.Service.*"%>
<%@page import="java.util.List"%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	Customer customer=(Customer)session.getAttribute("customer");

%>

<h4>收货地址管理</h4>
<form>
	<div class="row address">
		<div class="col-md-2 col-xs-2 col-sm-2">
			收货人：
		</div>
		<div class="col-md-8 col-xs-8 col-sm-8 address1">
			<input type="text" id="" value="<%=customer.getCusName()%>" />
		</div>
	</div>
	<div class="row address">
		<div class="col-md-2 col-xs-2 col-sm-2">
			联系电话：
		</div>
		<div class="col-md-8 col-xs-8 col-sm-8 address1">
			<input type="tel" id="" value="<%=customer.getCusTel()%>" />
		</div>
	</div>
	<div class="row address">
		<div class="col-md-2 col-xs-2 col-sm-2">
			收货地址：
		</div>
		<div class="col-md-9 col-xs-9 col-sm-9 address1">
			<input type="text" id="AddDetails" value="<%=customer.getAddDetails()%>" />
		</div>
	</div>

	<div class="row address">
		<div class="col-md-2 col-xs-2 col-sm-2">
			邮编：
		</div>
		<div class="col-md-8 col-xs-8 col-sm-8 address1">
			<input type="text" id="" value="<%=customer.getCuspost()%>" />
		</div>
	</div>

	<div class="row address">

		<div class="col-md-8 col-xs-8 col-sm-8 address2">
			<input type="checkbox" id="" value="" /> 设为默认地址
		</div>
	</div>
	<div class="row address">
		<div class="col-md-2 col-xs-2 col-sm-2">

		</div>
		<div class="col-md-8 col-xs-8 col-sm-8 address3">
			<button type="submit" class="btn btn-success btn-xs">添加新地址</button>
		</div>
	</div>

</form>