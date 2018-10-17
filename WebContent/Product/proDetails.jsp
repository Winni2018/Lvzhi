<%@page import="com.login.Lz.Bean.*"%>
<%@page import="com.login.Lz.Service.*"%>
<%@page import="java.util.List"%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%
    	String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.print(basePath);
    Productservice productService=new Productservice();

 %>
 <%
List<Product> products4=productService.ProductDetails();
%>
 <%
	Customer customer=(Customer)session.getAttribute("customer");
%>
 <%
 int proId=Integer.parseInt(request.getParameter("proId"));
 Product product=productService.getOneProductById(proId);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
		<title></title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" type="text/css" href="bootstrap-3.3.4-dist/css/bootstrap.min.css"/>
		<script src="bootstrap-3.3.4-dist/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="bootstrap-3.3.4-dist/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="Product/css/proDetails.css"/>
		<script src="Product/js/proDetails.js" type="text/javascript" charset="utf-8"></script>
		
</head>
<body>
		<div class="container-fluid">
			<header>
				<nav class="navbar navbar-default navheader " role="navigation">
					<div class="container">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">
							<span class="sr-only">切换导航</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>	
						</button>
							<img src="img/logo.jpg"/>
						</div>
						<div class="collapse navbar-collapse" id="example-navbar-collapse">
							<ul class="nav navbar-nav navbar-right left">
								<li>
									<a href="index.jsp">首页</a>
								</li>
								<li>
									<a href="Product/productIndex.jsp">商品中心</a>
								</li>
								<li>
									<a href="News/newsIndex.jsp">新闻中心</a>
								</li>
								<li>
									<a href="About/aboutIndex.jsp">关于我们</a>
								</li>
								<li>
									
									<button type="submit" class="btn btn-success btn-xs login"><a href="login.jsp">登录</a></button>
									
								</li>

							</ul>
						</div>

					</div>
				</nav>
			</header>
			
			
				<div class="main">
					<div class="row mainpro">
				<%
	for(Product products:products4){
	%>
						<div class="col-md-7 col-xs-12 col-sm-12 main-left">
							<h3><%=product.getProInfo() %></h3>
							<p><%=product.getProDetails()%></p>
							
							
							<img src="<%=product.getProPic() %>" height="200px" />
							
						
						</div>
		<%} %>
		<%
	for(Product products:products4){
	%>
						<div class="col-md-5 col-xs-12 col-sm-12 main-right">
							<h4><%=product.getProInfo() %></h4>
							<p>盆栽植物室内观叶植物绿植</p>
							<span>价格：</span><span class="price"><%=product.getProPrice() %></span><br /><br />
							<span>数量：</span>
							<button class="glyphicon-plus plus"></button>
							<input type="text" value="1" id="shopNo" name="shopNo" />
							<button class="glyphicon-minus minus"></button><br />
							<button type="submit" class="bt btn-success btn-xs buy">立即购买</button>
							<button type="submit" class="bt btn-success btn-xs buy1">加入购物车</button>
						</div>
		<%} %>
					</div>
				</div>
			<footer>
				<div class="row">
					<div class="col-md-4 col-sm-6 col-xs-12 lianxi">
						<h4>联系我们</h4>
						<h5>电话：400-000-xxxx </h5>
						<h5>邮箱：123xxxxx@163.com </h5>
						<h5>地址：天津市xxx区xxx路moumou大厦5xxx室</h5>
					</div>
					<div class="col-md-4 col-sm-6 col-xs-12 lianjie">
						<h4>快速链接</h4>
						<h5>网站首页</h5>
						<h5>商品中心</h5>
						<h5>新闻中心</h5>
						<h5>关于我们</h5>
					</div>
					<div class="col-md-4 col-sm-6 col-xs-12 sousuo">
						<h4>搜索</h4>
						<div class="searchinput">
							<input type="text" class="submit"></input>
							<img src="img/search.png"/>
						</div>
						
						<h5>关注我们</h5>
						<img src="img/footer.png" width="90px" height="90px"/>
					</div>
				</div>
			</footer>
		</div>
	</body>
</html>
