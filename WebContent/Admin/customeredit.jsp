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

   Customer customer=(Customer)request.getAttribute("customer");
List<Address> addresslist=(List<Address>)request.getAttribute("address");
List<Addsmall> addsmallList=(List<Addsmall>)request.getAttribute("addsmall");
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
<script src="Admin/utf8-jsp/ueditor.config.js"></script>
<script src="Admin/utf8-jsp/ueditor.all.min.js"></script>
<script src="Admin/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<h3 align="center">更新</h3>
<form action="customer?action=updatedo" method="post" enctype="multipart/form-data">
<input name="customerId" type="hidden" value="<%=customer.getCustomerId()%>" />
<table class="table" align="center">

	<tr>
		<td>账号：</td>
		<td><input name="cusAccount" type="text" value="<%=customer.getCusAccount()%>"/></td>
	</tr>

	<tr>
		<td>昵称：</td>
		<td><input name="cusName" type="text" value="<%=customer.getCusName()%>"/>
		 </td>
	</tr>
	<tr>
		<td>电话：</td><td><input name="cusTel" type="text" value="<%=customer.getCusTel()%>"/></td>
	</tr>
	<tr>
		<td>邮箱：</td><td><input name="cusEmail" type="text" value="<%=customer.getCusEmail()%>"/></td>
	</tr>
	
	<tr>
		<td>收货地址：</td>
		<td><select name="addCont" id="addCont">
	<% 	
		for(Address address:addresslist){
			%>
		<option value="<%=address.getAddressId()%>">
		<%=address.getAddCont()%>
		</option>
		<%} %>
		</select>小类
		<select name="addSmallId" id="addSmallId">
		
		</select>	 
		<script type="text/javascript">
			$(function(){
				getSelect();
				$("#addCont").change(function(){
					getSelect();
				});
			});
			function getSelect(){
				$.post("customer?action=addsmall",{addressId:$("#addCont").val()},function(data,status){
					console.log('001')
					console.log(data)
					var jsonData = data;
					//alert("jsonDate"+jsonDate.length);
					$("option",$("#addSmallId")).remove();
					var html="";
					for(var i=0;i<jsonData.length;i++){
						//debugger;
						//alert("jsonDate");
						var aobj=jsonData[i];
						//alert("jsonData111"+aobj.addSmallCont);
						html+="<option value='"+jsonData[i].addSmallId+"'>"+jsonData[i].addSmallCont+"</option>";
						//alert("aobj.addSmallCont"+jsonData[i].addSmallCont);
						
					}
					$("#addSmallId").html(html);
				});
			}
		</script>
		
		 </td>
		 
	</tr>
	<tr>
		<td>详细地址:</td>
		<td><script id="container" name="addDetails" type="text/plain" charset="utf-8" style="height:200px">
			 
		 </script>
		 <script type="text/javascript" charset="utf-8">
		 UE.getEditor('container');
			 
		 </script>
		 </td>
	</tr>
	
	
	<tr>
		<td colspan="2" align="center"><input type="submit" value="更新"><input type="reset" value="重置" /></td>
	</tr>
</table>
</form>
</body>
</html>