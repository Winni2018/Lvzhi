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
	List<NewsInfo> newsInfos=(List<NewsInfo>)request.getAttribute("newsInfos");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<script src="bootstrap-3.3.4-dist/jquery-3.3.1.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.4-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.4-dist/css/bootstrap-theme.min.css"/>
<script type="text/javascript" src="bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
</head>
<body>
<h3 align="center">新闻信息浏览</h3>
<table class="table table-striped">
	<thead>
   <tr>
		<td>编号</td>
		<td>标题</td>
		<td>信息</td>
		<td>日期</td>
		<td>图片</td>
		<td>详情</td>
		<td>分类</td>
		<td colspan="6" >操作</td>
	</tr>
    </thead>
    <tbody>
    <%
	for(NewsInfo newsInfo:newsInfos){
	%>
	<tr>
		<td><%=newsInfo.getNewsId()%></td>
		<td><%=newsInfo.getNewsTitle()%></td>
		<td><%=newsInfo.getNewsInfo() %></td>
		<td><%=newsInfo.getNewsDate() %></td>
		<td><img class="imgpic" src="<%=newsInfo.getNewsPic() %>" width="60px" height="60px"></td>
		<td><%=newsInfo.getNewsDetails()%></td>
		<td><%=newsInfo.getNewsSort().getNewsSortName()%></td>
		
		
		<td colspan="4">
			<img src="Admin/img/gengxin.png" class="icon" width="20px" height="20px"/>
			<a href="news?action=update&newsId=<%=newsInfo.getNewsId() %>">
				更新
			</a>
			
			
		</td>
		<td colspan="4">
			
			<img src="Admin/img/del.png" class="icon" width="20px" height="20px"/>
			<a href="news?action=delete&newsId=<%=newsInfo.getNewsId() %>">
			删除
			</a>
		</td>
	</tr>
	<%} %>
    </tbody>
	
	
	
</table>
</body>
</html>