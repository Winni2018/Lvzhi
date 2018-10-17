<%@page import="com.login.Lz.Bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <% 
  //检查用户是否登录
  if(session.getAttribute("user")==null){
	  response.sendRedirect("login.jsp");
	  return;
  }
    
    %>
      <%
    	String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.print("basePath="+basePath);
    %>
<!DOCTYPE html>
<html>
	<head>
	<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="Admin/css/themes/default/easyui.css"/>
		<link rel="stylesheet" type="text/css" href="Admin/css/themes/icon.css"/>
		<link rel="stylesheet" type="text/css" href="Admin/css/main.css"/>
		<script src="bootstrap-3.3.4-dist/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="Admin/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="Admin/js/main.js"></script>
		
	</head>
	<body class="easyui-layout">
		<div class="top" data-options="region:'north',split:false,border:false">
			<span class="span1">
				<%
User user=(User)session.getAttribute("user");
out.println(user.getUsername());

%>
				欢迎访问本系统！</span>
			<span class="span2">后台管理系统</span>
			<span class="span3"><a href="userocl?action=logout">退出登录</a></span>
		</div>
		<div class="left" data-options="region:'west',split:true,border:true,title:'导航菜单'">
			
			<div class="easyui-accordion">
			<div class="home" title="首页">	
					<p><a class="navMenu" href="JavaScript:void(0);" url="Admin/home.jsp">系统首页</a></p>
					<p><a class="navMenu" href="JavaScript:void(0);" url="Admin/system.jsp">系统信息</a></p>
				</div>
			<div class="aboutus" title="公司信息管理">	
					<p><a class="navMenu" href="JavaScript:void(0);" url="aboutHandler?action=getall">信息列表</a></p>

				</div>
				<div class="product" title="商品管理">	
					<p><a class="navMenu" href="JavaScript:void(0);" url="productocl?action=getsort">商品分类</a></p>
					<p><a class="navMenu" href="JavaScript:void(0);" url="productocl?action=getall">商品列表</a></p>
					<p><a class="navMenu" href="JavaScript:void(0);" url="productocl?action=addpro">添加商品</a></p>
				</div>
				<div class="news" title="新闻管理">
					<p><a class="navMenu" href="JavaScript:void(0);" url="news?action=getall">新闻列表</a></p>
					<p><a class="navMenu" href="JavaScript:void(0);" url="news?action=addnews">添加新闻</a></p>
					
				</div>
				<div class="users" title="用户管理">
					<p><a class="navMenu" href="JavaScript:void(0);" url="customer?action=getall">用户列表</a></p>				
				</div>
				<div class="order" title="订单管理">
					<p><a class="navMenu" href="JavaScript:void(0);" url="order?action=getall">订单列表</a></p>
					
					
				</div>
				<div class="carousel" title="轮播管理">
					<p><a class="navMenu" href="JavaScript:void(0);" url="carousel?action=getall">轮播列表</a></p>
				
					
				</div>
			</div>
			
		</div>
		<div class="foot" data-options="region:'south',split:false,border:true">
			底部
			
		</div>
		<div class="main" data-options="region:'center',split:false,border:true">
		<div class="easyui-tabs" id="tabs" fit="true">
			
		</div>
			
		</div>
		<script type="text/javascript">
		$(function(){
			$(".navMenu").click(function(){
				var mtitle=$(this).html();
				var murl=$(this).attr("url");
				var tabsexit=$("#tabs").tabs("exists",mtitle);
				if(!tabsexit){
					$("#tabs").tabs("add",{title:mtitle,content:getContent(murl),closable:true});
				}else{
					$("#tabs").tabs("select",mtitle);
				}
			});
			$("#tabs").tabs("add",{
				title:"首页",
				content:getContent("Admin/home.jsp"),
				closable:true
				});
			
		});
		function getContent(url){
			return "<iframe src='"+url+"' width='100%' height='100%' frameborder='0'></iframe>";
		}

		</script>
	</body>
</html>
