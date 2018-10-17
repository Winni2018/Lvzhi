<%@page import="com.login.Lz.Bean.*"%>
<%@page import="com.login.Lz.Service.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%
    	String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.print(basePath);
    NewsInfoservice newsInfoservice=new NewsInfoservice();
 %>

 <%
 List<NewsInfo> newsInfos=newsInfoservice.Newsapplication();
 List<NewsInfo> newsInfos2=newsInfoservice.selectNewsSort();
 
%>
<%
	Customer customer=(Customer)session.getAttribute("customer");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title></title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" type="text/css" href="bootstrap-3.3.4-dist/css/bootstrap.min.css"/>
		<script src="bootstrap-3.3.4-dist/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="bootstrap-3.3.4-dist/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="News/css/newsDetails.css"/>
	
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
									<a href="News/newsIndex.jsp"">新闻中心</a>
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
				<div class="row main-row">
		
					<div class="col-md-9 col-xs-12 col-sm-12 main-left">
						 <%
int newsId=Integer.parseInt(request.getParameter("newsId"));
NewsInfo newsInfo=newsInfoservice.findOneNewsInfoById(newsId);
%>
									<h4><%=newsInfo.getNewsTitle() %></h4>
									<p><%=newsInfo.getNewsDate()%></p>
									<img src="<%=newsInfo.getNewsPic() %>"/>
									<p><%=newsInfo.getNewsDetails()%>
									</p>
			
						
		
					</div>
	
					<div class="col-md-3 col-sm-12 col-xs-12 main-right">
						<ul class="sort">
							<li class="sortname">绿植应用</li>
								
							<li><h4 class="sorttitle">小小绿植翠色欲滴　满室绿意平添清凉感</h4></li>
							<li><h4 class="sorttitle">冬季装修时放置绿植可防墙面开裂</h4></li>
							<li><h4 class="sorttitle">正确摆放绿植 改善家居风水</h4></li>
							<li><h4 class="sorttitle">11种不适合摆在房间里的植物</h4></li>
							<li><h4 class="sorttitle">庭院种什么绿植才比较合适</h4></li>
						

				
						</ul>
						<ul class="sort1">
							<li class="sortname1">最新资讯</li>
							
							<li>
										<img src="img/e2.jpg" class="iconimg"/>
										<h4 class="sorttitle1">周末了，和绿植为伴，享受自然之美,惬意~</h4>
								
							</li>
							<li>
										<img src="img/d3.jpg" class="iconimg"/>
										<h4 class="sorttitle1">这些植物，天生就是装修污染的克星</h4>
								
							</li>
							<li>
										<img src="img/a6.jpg" class="iconimg"/>
										<h4 class="sorttitle1">	这样装饰自己的家，美观健康两不误</h4>
								
							</li>
							<li>
										<img src="img/e1.jpg" class="iconimg"/>
										<h4 class="sorttitle1">如何让家清新自然？学学软装绿植搭配法则</h4>
								
							</li>
							<li>
										<img src="img/d1.jpg" class="iconimg"/>
										<h4 class="sorttitle1">8个绿植空间—— 青春型室内软装风潮</h4>
								
							</li>

							
							
						</ul>
					</div>
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
		<a href="#top" class="topreturn">
			<img src="img/top.png" width="34px" height="34px"/>
		</a>
	
		
	</body>
</html>
