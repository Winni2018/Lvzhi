<%@page import="com.login.Lz.Bean.*"%>
<%@page import="com.login.Lz.Service.*"%>
<%@page import="java.util.List"%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		Customer customer=(Customer)session.getAttribute("customer");
%>
<h4>我的信息</h4>
<div class="row change">
	<div class="col-xs-10 col-sm-3 col-md-3 chang-span2">
		<span>修改头像</span>
	</div>

	<div class="col-xs-6 col-sm-3 col-md-3 change-upload">
		<a href='javascript:void(0);' class="blueButton">
			选择文件
		</a>
		<input type="file" class="myFileUpload" />
		<div class="show"></div>
	</div>
</div>
<div class="row change">
	<div class="col-xs-10 col-sm-3 col-md-3 chang-span2">
		账号
	</div>
	<input type="text  class="col-xs-6 col-sm-6 col-md-6 change-box1" value="<%=customer.getCusAccount()%>" />
</div>
<div class="row change">
	<div class="col-xs-10 col-sm-3 col-md-3 chang-span2">
		昵称
	</div>
	<input type="text"  class="col-xs-6 col-sm-6 col-md-6 change-box1" value="<%=customer.getCusName()%>" />
</div>
<div class="row change">
	<div class="col-xs-10 col-sm-3 col-md-3 chang-span2">
		性别
	</div>
	<div class="col-xs-6 col-sm-6 col-md-6 change-sex">
		<input type="radio" name="sex" id="sex" checked="checked" />男
		<input type="radio" name="sex" id="sex" />女
	</div>
</div>
<div class="row change">
	<div class="col-xs-10 col-sm-3 col-md-3 chang-span2">
		电话
	</div>
	<input type="text" class="col-xs-6 col-sm-6 col-md-6 change-box1" value="<%=customer.getCusTel()%>"/>
</div>
<div class="row change">
	<div class="col-xs-10 col-sm-3 col-md-3 chang-span2">
		邮箱
	</div>
	<input type="text" class="col-xs-6 col-sm-6 col-md-6 change-box1" value="<%=customer.getCusEmail()%>"/>
</div>
<div class="row change">
	<div class="col-xs-10 col-sm-3 col-md-3 chang-span2">
		所在地
	</div>
	<input type="text" class="col-xs-6 col-sm-6 col-md-6 change-box1" value="<%=customer.getAddDetails()%>"/>
</div>
<div class="row change2">
	<div class="col-sm-2 col-md-2">

	</div>
	<div class="col-sm-5 col-md-5">
		<button type="submit" class="btn">提交</button>
	</div>
</div>