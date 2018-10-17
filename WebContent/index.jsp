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
    NewsInfoservice newsInfoservice=new NewsInfoservice();
    AboutUsService aboutUsservice=new AboutUsService();
    CarouselService carouselService=new CarouselService();
    Customerservice customerService=new Customerservice();
    %>
<%
List<Product> products=productService.selectProduct();

%>
<%
List<Product> products1=productService.selectProduct1();
%>
<%
List<NewsInfo> newsInfos=newsInfoservice.selectNewsInfo();
%>

<%
List<AboutUs> aboutInfos3=aboutUsservice.selectAboutInfo3();
List<Carousel> carousels=carouselService.findHomeCarousel();
List<Carousel> carousels1=carouselService.findHomeCarousel1();
List<Carousel> carousels2=carouselService.findHomeCarousel2();
%>
<%
	Customer customer=(Customer)session.getAttribute("customer");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="bootstrap-3.3.4-dist/css/bootstrap.min.css" />
		<script type="text/javascript" src="bootstrap-3.3.4-dist/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/index.css" />
		<script src="js/index.js"></script>
	
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
									<a href="#">首页</a>
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
						<div class="banner">
				
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
								<div class="title">
									<h4><%=carousel.getImgTitle() %></h4>
									<p><%=carousel.getImgDetails() %></p>
								</div>
							</div>
					<%} %>	
						<%
	for(Carousel carousel:carousels1){
	%>
							<div class="item">
								<img src="<%=carousel.getImgPic() %>" alt="Second slide">
								<div class="title">
									<h4><%=carousel.getImgTitle() %></h4>
									<p><%=carousel.getImgDetails() %></p>
								</div>
							</div>
					<%} %>	
					<%
	for(Carousel carousel:carousels2){
	%>
							<div class="item">
								<img src="<%=carousel.getImgPic() %>" alt="Third slide">
								<div class="title1">
									<h4><%=carousel.getImgTitle() %></h4>
									<span><%=carousel.getImgDetails() %></span>
								</div>
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
					
						

			</div>
			<div class="main">

				<div class="section1">
					<h3>最新推荐</h3>
					<p>找到适合你的那一款</p>
					<div class="row sectionpro">
						<div class="col-md-6 col-sm-12 col-xs-12 section1-left">
							<img src="img/aa.jpg" />
							<div class="desc-left">
								<h4>绿植室内大型盆景</h4>
								<button type="button" class="btn btn-sm">查看详情</button>
							</div>
						</div>

						<div class="col-md-6 col-sm-12 col-xs-12 section1-info">
						<%
	for(Product product:products){
	%>
	         <a href="productocl?action=select&proId=<%=product.getProId()%>">
							<div class="col-md-6 col-sm-6 col-xs-12 section1-right">
								<img src="<%=product.getProPic() %>" />
								<div class="desc">
									<h4><%=product.getProInfo() %></h4>
									<button type="button" class="btn btn-sm">查看详情</button>
		
								</div>

							</div>
	</a>
	<%} %>
							
						</div>
					</div>
				</div>
				<div class="section4">
					<h3>限时秒杀</h3>
					<p>看看有你满意的吗</p>
					<div class="row sectiontime">
						<%
	for(Product product:products1){
	%>
	<a href="productocl?action=select&proId=<%=product.getProId()%>">
						<div class="col-md-3 col-sm-6 col-xs-12 section4-buy">
							<div class="thumbnail buy">
								<img src="<%=product.getProPic() %>" />
								<div class="description">
									<h3><%=product.getProInfo() %></h3>
									<span>仙人掌仙人球多肉植物桌面小盆栽</span>
									<h4>￥<%=product.getProPrice() %></h4>
								
								</div>
								<button type="button" class="btn btn-success btn-sm">立即秒杀</button>
	
							</div>
							
						</div>
		</a>
			<%} %>
						
						
						
					</div>
				</div>
				<div class="section2">
					<h3>新闻资讯</h3>
					<p>最全面的新闻、资讯、动态</p>
					<div class="row sectionNew">
					<%
	for(NewsInfo newsInfo:newsInfos){
	%>              
						<a href="news?action=select&newsId=<%=newsInfo.getNewsId()%>">
						<div class="col-md-4 col-sm-4 col-xs-12 section2-show">
							<div class="thumbnail sectionNew1">
								<img src="<%=newsInfo.getNewsPic() %>" />
								<h4><%=newsInfo.getNewsTitle() %></h4>
								<h5><%=newsInfo.getNewsDate()%></h5>
								<span><%=newsInfo.getNewsInfo() %></span>
							</div>
							<span class="more">view more→</span>
						</div>
			        </a>
			<%} %>
						
						
					</div>
				</div>
				<div class="section3">
					<h3>关于我们</h3>
					<p>认真的态度服务大家</p>
					<div class="row sectionabout">
						<div class="col-md-6 col-sm-6 col-xs-12 section3-know1">
							<span class="aboutspan">About us</span>
							<%
	for(AboutUs aboutInfo2:aboutInfos3){
		 
	%>
							<section>
								
								<img src="<%=aboutInfo2.getAboutPic() %>"/>
							
								<h4><%=aboutInfo2.getAboutTitle() %></h4>
								<p><%=aboutInfo2.getAboutInfo() %></p>
								<div class="sectionmb"></div>
							</section>
				<%} %>	
							
						</div>
						<div class="col-md-6 col-sm-6 col-xs-12 section3-know2">

							<img src="img/a6.jpg" />
							<div class="mb">
								<h3>美好就在你身边</h3>
								<h5>因为自然就是原始的美</h5>
							</div>

						</div>
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