<%@page import="com.login.Lz.Bean.Product"%>
<%@page import="com.login.Lz.Bean.Proclass"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Product product = (Product)request.getAttribute("product");
List<Proclass> proclasslist=(List<Proclass>)request.getAttribute("proclass");
%>
    <%
    	String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.print(basePath);
    %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<script src="bootstrap-3.3.4-dist/jquery-3.3.1.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.4-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.4-dist/css/bootstrap-theme.min.css"/>
<script type="text/javascript" src="bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
<script src="Admin/utf8-jsp/ueditor.config.js"></script>
<script src="Admin/utf8-jsp/ueditor.all.min.js"></script>
<script src="Admin/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<title>Insert title here</title>
<style type="text/css">
	input{
	border:0;
	}
	.info{
	width:70%;
	}
</style>
</head>
<body>
<h3 align="center">更新</h3>
<form action="productocl?action=updatedo" method="post" enctype="multipart/form-data">
<input name="proId" type="hidden" value="<%=product.getProId() %>" />
<table class="table" align="center">
	<tr>
		<td>名称：</td>
		<td><input name="proName" type="text" value="<%=product.getProName() %>" /></td>
	</tr>
	<tr>
		<td>价格：</td>
		<td><input name="proPrice" type="text" value="<%=product.getProPrice() %>" /></td>
	</tr>
	<tr>
		<td>信息：</td>
		<td><input name="proInfo" type="text" class="info" value="<%=product.getProInfo()%>"/></td>
	</tr>
	<tr>
		<td>图片：</td>
		<td><input name="proPic" type="file" value="<%=product.getProPic() %>" /></td>
	</tr>
	<tr>
		<td>详情：</td>
		<td><script id="container" name="proDetails" type="text/plain" charset="utf-8" style="height:200px">
			 
		 </script>
		 <script type="text/javascript" charset="utf-8">
		 UE.getEditor('container');
			 
		 </script>
		 </td>
	</tr>
	<tr>
		<td>分类：</td>
		<td>
			<select name="proclassId">
			<%
			for(Proclass proclass:proclasslist){
			
			%>
				<option value="<%=proclass.getProClassId()%>">
					<%=proclass.getProClassname() %>
				</option>
				<% }%>
			</select>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="更新"><input type="reset" value="重置" /></td>
	</tr>
</table>
</form>
</body>
</html>