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
 List<NewsInfo> newsInfos1=newsInfoservice.selectNewsInfo1();
 List<NewsInfo> newsInfos6=newsInfoservice.selectNewsInfo2();
 List<NewsInfo> newsInfos7=newsInfoservice.selectNewsInfo3();
 List<NewsInfo> newsInfos=newsInfoservice.Newsapplication();
%>
 <%
 List<NewsInfo> newsInfos2=newsInfoservice.selectNewsSort();
 CarouselService carouselService=new CarouselService();
%>
 <%
	Customer customer=(Customer)session.getAttribute("customer");
%>
<%
 List<NewsInfo> newsInfos3=newsInfoservice.findOneNews();
List<NewsInfo> newsInfos4=newsInfoservice.findOneNews1();
List<NewsInfo> newsInfos5=newsInfoservice.findOneNews2();
List<Carousel> carousels=carouselService.findNewsCarousel();
List<Carousel> carousels1=carouselService.findNewsCarousel1();
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
		<link rel="stylesheet" type="text/css" href="News/css/newsIndex.css"/>
		<script src="News/js/newsIndex.js"></script>
		
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
									<a href="#">新闻中心</a>
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
				<div class="row">
					<div class="col-md-9 col-sm-12 col-xs-12 main-left">
						<div id="myCarousel" class="carousel slide">
						<!-- 轮播（Carousel）指标 -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
						</ol>
						<!-- 轮播（Carousel）项目 -->
						<div class="carousel-inner">
					<%
	for(Carousel carousel:carousels){
	%>		
							<div class="item active">
								<img src="<%=carousel.getImgPic() %>" alt="First slide">
							
							</div>
		<%} %>					
		<%
	for(Carousel carousel:carousels1){
	%>
							<div class="item">
								<img src="<%=carousel.getImgPic() %>" alt="Second slide">
							
							</div>
						<%} %>
						</div>
						<!-- 轮播（Carousel）导航 -->
						<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
							<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a>
						<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>
					
					
						<section>
							<ul class="nav nav-pills nav-justified">
								<li class="industry"><a>行业资讯</a></li>
								<li class="maintain"><a>养护管理</a></li>
							
								<li class="house"><a>家居装饰</a></li>
								<li></li>
							</ul>
							<div class="row sectionrow">
						<%
	for(NewsInfo newsInfo:newsInfos3){
	%>			
	<a href="news?action=select&newsId=<%=newsInfo.getNewsId()%>">
								<div class="col-md-6 col-xs-6 col-sm-12 section-left leftnews1">
									<img src="<%=newsInfo.getNewsPic() %>"/>
									<h4><%=newsInfo.getNewsTitle() %></h4>
									<p><%=newsInfo.getNewsDate()%></p>
									<p><%=newsInfo.getNewsInfo() %>
									</p>
								</div>
		</a>
		<%} %>			
		<%
	for(NewsInfo newsInfo:newsInfos4){
	%>			
	<a href="news?action=select&newsId=<%=newsInfo.getNewsId()%>">
								<div class="col-md-6 col-xs-6 col-sm-12 section-left leftnews2">
									<img src="<%=newsInfo.getNewsPic() %>"/>
									<h4><%=newsInfo.getNewsTitle() %></h4>
									<p><%=newsInfo.getNewsDate()%></p>
									<p><%=newsInfo.getNewsInfo() %>
									</p>
								</div>
	</a>
		<%} %>		
		<%
	for(NewsInfo newsInfo:newsInfos5){
	%>			
	<a href="news?action=select&newsId=<%=newsInfo.getNewsId()%>">
								<div class="col-md-6 col-xs-6 col-sm-12 section-left leftnews3">
									<img src="<%=newsInfo.getNewsPic() %>"/>
									<h4><%=newsInfo.getNewsTitle() %></h4>
									<p><%=newsInfo.getNewsDate()%></p>
									<p><%=newsInfo.getNewsInfo() %>
									</p>
								</div>
		</a>
		<%} %>		
								<div class="col-md-6 col-xs-6 col-sm-12 section-right">
					<%
	for(NewsInfo newsInfo:newsInfos1){
	%>
	<a href="news?action=select&newsId=<%=newsInfo.getNewsId()%>">
									<div class="col-md-12 col-xs-12 col-sm-12 section-right1 rightnews1">
										<img src="<%=newsInfo.getNewsPic() %>"/>
										<h4><%=newsInfo.getNewsTitle() %></h4>
										<span><%=newsInfo.getNewsDate()%>|</span><span>绿植|</span><span>生活</span>
								
									</div>
		</a>
		<%} %>			
		<%
	for(NewsInfo newsInfo:newsInfos6){
	%>
	 <a href="news?action=select&newsId=<%=newsInfo.getNewsId()%>">
									<div class="col-md-12 col-xs-12 col-sm-12 section-right1 rightnews2">
										<img src="<%=newsInfo.getNewsPic() %>"/>
										<h4><%=newsInfo.getNewsTitle() %></h4>
										<span><%=newsInfo.getNewsDate()%>|</span><span>绿植|</span><span>生活</span>
								
									</div>
		</a>
		<%} %>			
		<%
	for(NewsInfo newsInfo:newsInfos7){
	%>
	 <a href="news?action=select&newsId=<%=newsInfo.getNewsId()%>">
									<div class="col-md-12 col-xs-12 col-sm-12 section-right1 rightnews3">
										<img src="<%=newsInfo.getNewsPic() %>"/>
										<h4><%=newsInfo.getNewsTitle() %></h4>
										<span><%=newsInfo.getNewsDate()
										%>|</span><span>绿植|</span><span>生活</span>
								
									</div>
		</a>
		<%} %>							
									
									
								</div>
							</div>
						</section>
						<section class="article">
							<h4>最新文章</h4>
				<%
	for(NewsInfo newsInfo:newsInfos1){
	%>
	                       <a href="news?action=select&newsId=<%=newsInfo.getNewsId()%>">
							<div class="row section-new">
								<div class="col-md-6 col-xs-12 col-sm-12 new-left">
									<img src="<%=newsInfo.getNewsPic() %>"/>
								</div>
								<div class="col-md-6 col-xs-12 col-sm-12 new-right">
									<h4><%=newsInfo.getNewsTitle() %></h4>
									<p><%=newsInfo.getNewsDate()%></p>
									<p><%=newsInfo.getNewsInfo()%></p>
									<button type="button" class="btn btn-success btn-xs">马上阅读</button>
								</div>
							</div>
	</a>
	<%} %>						
						
						</section>
					
					
					
					</div>
					<div class="col-md-3 col-sm-12 col-xs-12 main-right">
						<ul class="sort">
							<li class="sortname">绿植应用</li>
				<%
	for(NewsInfo newsInfo:newsInfos){
	%>			<a href="news?action=select&newsId=<%=newsInfo.getNewsId()%>">
							<li>
								<h4 class="sorttitle"><%=newsInfo.getNewsTitle() %></h4></li>
						
		</a>
	<%} %>
						</ul>
						<ul class="sort1">
							<li class="sortname1">最新资讯</li>
				<%
	for(NewsInfo newsInfo:newsInfos2){
	%>			<a href="news?action=select&newsId=<%=newsInfo.getNewsId()%>">
	
							<li>
										<img src="<%=newsInfo.getNewsPic() %>" class="iconimg"/>
										<h4 class="sorttitle1"><%=newsInfo.getNewsTitle() %></h4>
								
							</li>
	</a>
	<%} %>
							
							
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
		<a href="News/newsIndex.jsp" class="topreturn">
			<img src="img/top.png" width="34px" height="34px"/>
		</a>
		
	</body>
</html>
