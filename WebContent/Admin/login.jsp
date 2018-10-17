<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
    	String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.print(basePath);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>Insert title here</title>
<style>
	*{
		position: relative;
	}
	body{
		
	background-image:url(Admin/img/1.jpg);
	background-repeat: no-repeat;
	background-size: 100% 100%;

	background-attachment: fixed;
}

	form{	
			position:fixed;
			width:30%;
			height:240px;
			top: 28%;
			left: 34%;
			background-color: rgba(255,255,255,0.5);
			border-radius: 10px;
		
	}
	table{
			position:absolute;
			top:0;
			left:17%;
			
			
	}
	.login h4{
		font-weight: 500;
		
		font-size: 20px;
		
	}
	.submit{
		margin-top:10%;
		width:90px;
		height:28px;
		background-color:#D6E4EA;
		border-radius:7px;
		border: 1px solid #D6E4EA;
		box-shadow: 3px 3px 3px gainsboro ;
		font-size:14px;
	}
	.username,.password{
		border: 1px solid #D6E4EA;
		height: 18px;
		
	}
</style>
</head>
<body>
<form action="userocl?action=login" method="post">
<br/><br/><br/><br/><br/>
<table>
	<tr class="login" >
		<td colspan="8" align="center"><h4>用户登录</h4></td>
	</tr>
	<tr >
		<td colspan="2" align="center"></td>
	</tr>
	<tr>
		<td>账号：</td>
		<td><input type="text" name="username" class="username"/> </td>
	</tr>
	<tr >
		<td colspan="2" align="center"></td>
	</tr>
	<tr >
		<td colspan="2" align="center"></td>
	</tr>
	<tr >
		<td colspan="2" align="center"></td>
	</tr>
	<tr>
		<td>密码：</td>
		<td><input type="password" name="password" class="password" /> </td>
	</tr>
	<tr>
		<td colspan="4" align="center"><input type="submit" value="登录" class="submit"/> </td>
	</tr>
</table>
<p align="center"><font color="red"><%=request.getAttribute("errmsg")==null?"":request.getAttribute("errmsg") %></font></p>
</form>
</body>
</html>