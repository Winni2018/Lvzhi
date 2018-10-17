<%@page import="com.login.Lz.Bean.*"%>
<%@page import="com.login.Lz.Service.*"%>
<%@page import="java.util.List"%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.print(basePath);
 %>
 <%
	Customer customer=(Customer)session.getAttribute("customer");
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
		<link rel="stylesheet" type="text/css" href="person/css/personIndex.css"/>
		<link rel="stylesheet" type="text/css" href="person/css/address.css"/>
		<link rel="stylesheet" type="text/css" href="person/css/change.css"/>
		<link rel="stylesheet" type="text/css" href="person/css/change1.css"/>
		<link rel="stylesheet" type="text/css" href="person/css/Info.css"/>
		<link rel="stylesheet" type="text/css" href="person/css/myperson.css"/>
		<link rel="stylesheet" type="text/css" href="person/css/order.css"/>
		<link rel="stylesheet" type="text/css" href="person/css/review.css"/>
		<link rel="stylesheet" type="text/css" href="person/css/save.css"/>
		<script src="person/js/personIndex.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function(){
				var a=<%=customer.getCustomerId()%>
				if(a!=null){
					$(".customerPic").show();
					$(".login").hide();
				}
			})
		</script>
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
							<img src="img/logo.jpg" />
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
									<a href="#">关于我们</a>
								</li>
								<li>
									<img src="<%=customer.getCustomerPic()%>" width="45px" height="45px" class="img-circle customerPic"/>
									<button type="submit" class="btn btn-success btn-xs login"><a href="login.jsp">登录</a></button>
									
								</li>

							</ul>
						</div>

					</div>
				</nav>
			</header>

			<div class="main">
				<div class="row mainrow">
					<div class="col-md-3 col-xs-12 col-sm-12 left1">
					
						<ul class="order"> 
							<li class="titleorder">订单中心</li>
							<li class="current" data-id="order">
								<a>我的订单</a>
							</li>
							<li data-id="change">
								<a>购物车</a>
							</li>
						
							
						</ul>
						<ul class="person">
							<li class="titleperson">个人中心</li>
							<li class="current1" data-id="myinfo">
								<a>我的信息</a>
							</li>
							<li data-id="add">
								<a>收货地址</a>
							</li>
							<li data-id="gunali">
								<a>安全管理</a>
							</li>
						</ul>
					</div>
					<div class="col-md-9 col-xs-12 col-sm-12 right1 " id="content">
						
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
							<img src="img/search.png" />
						</div>

						<h5>关注我们</h5>
						<img src="img/footer.png" width="90px" height="90px" />
					</div>
				</div>
			</footer>
			</div>
			
			<a href="#top" class="topreturn">
				<img src="img/top.png" width="34px" height="34px" />
			</a>


		
	</body>
	 <script>
        $(function() {
            $(".order").on("click", "li", function() {
                var sId = $(this).data("id"); //获取data-id的值
                window.location.hash = sId; //设置锚点
                loadInner(sId);
            });
            $(".person").on("click", "li", function() {
                var sId = $(this).data("id"); //获取data-id的值
                window.location.hash = sId; //设置锚点
                loadInner(sId);
            });
 
            function loadInner(sId) {
                var sId = window.location.hash;
                var pathn, i;
                switch(sId) {
                    case "#order":
                        pathn = "order?action=select&customerId=<%=customer.getCustomerId()%>";
                        i = 0;
                        break;　　　　　　　
                    case "#change":
                        pathn = "cartHandler?action=select&customerId=<%=customer.getCustomerId()%>";
                        i = 1;
                        break;
                    case "#review":
                        pathn = "person/review.jsp";
                        i = 2;
                        break;　
                    case "#myinfo":
                        pathn = "person/info.jsp";
                        i = 3;
                        break;
                    case "#add":
                        pathn = "person/address.jsp";
                        i = 4;
                        break;
                    case "#gunali":
                        pathn = "person/save.jsp";
                        i = 5;
                        break;　　　　　
                    default:
                        pathn = "order.jsp";
                        i = 0;
                        break;
                }
                $("#content").load(pathn); //加载相对应的内容
                $(".order li").eq(i).addClass("current").siblings().removeClass("current"); //当前列表高亮
                 $(".person li").eq(i).addClass("current").siblings().removeClass("current"); //当前列表高亮
            }
            var sId = window.location.hash;
            loadInner(sId);
        });
    </script>

</html>