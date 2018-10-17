<%@page import="com.login.Lz.Bean.*"%>
<%@page import="com.login.Lz.Service.*"%>
<%@page import="java.util.List"%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
  Customerservice customerService=new Customerservice();
   
    CartService cartservice=new CartService();
  Customer customer=(Customer)session.getAttribute("customer");
%>
<%
int customerId=Integer.parseInt(request.getParameter("customerId"));
List<Cart> carts=(List<Cart>)cartservice.selectcart(customerId);
%>
<h4>购物车</h4>
<table class="table table-striped table-bordered">
<tr>
		<th>
			<label class="choose">全选</label>
		</th>
		<td>商品编号</td>
		<td>商品名称</td>
		<td>图片</td>
		<td>单价</td>
		<td>购买数量</td>
		<td>金额</td>

</tr>
<%
	for(Cart cart:carts){
	%>
<tr>
		<td><input type="checkbox" class="chooses" checked="checked" /></td>
		<td><%=cart.getProId() %></td>
		<td><%=cart.getProduct().getProName() %></td>
		<td><img src="<%=cart.getProduct().getProPic() %>" width="60px" height="60px"/></td>
		<td><%=cart.getProduct().getProPrice() %></td>
		<td><button class="glyphicon-minus"></button>
			<input type="text" name="" id="cartNo" value="<%=cart.getCartNo()%>" size="1"/>
			
			<button class="glyphicon-plus"></button>
		</td>
		<td id="price"></td>
		
</tr>

<%} %>
</table>
	<div class="container-fluid">
		总计：<label class="total">0</label>
	</div>
</div>
<script type="text/javascript">
	$(function(){
		var total=0;
		$("tr").each(function(i){
			if(i>0){
				var allprice=0;
				var price=$(this).children("td").eq(4).text();
				var no=parseInt($(this).children("td").eq(5).children("#cartNo").val());
				allprice=price*no;
				$(this).children("td").eq(6).text(allprice);
				total+=parseInt($(this).children("td").eq(6).text());
			}
		});
			$(".total").text(total);
		$(".glyphicon-plus").click(function(){
			var no=parseInt($(this).siblings("#cartNo").val())+1;
			$(this).siblings("#cartNo").val(no);
			var price=$(this).parent().prev().text();
			//alert("price"+price);
			var allprice=price*no;
			$(this).parent().next().text(allprice);
			
			
		});
	
		$(".glyphicon-minus").click(function(){
			var no=parseInt($(this).siblings("#cartNo").val())-1;
			$(this).siblings("#cartNo").val(no);
			var price=$(this).parent().prev().text();
			//alert("price"+price);
			var allprice=price*no;
			$(this).parent().next().text(allprice);
			
		});
	
		$("#cartNo").change(function(){
			var no=parseInt($(this).val());
			var price=$(this).parent().prev().text();
			var allprice=price*no;
			$(this).parent().next().text(allprice);
			
		});
	
		$(function(){
			$(".chooses").change(function(){
				if(!$(this).is(":checked")){
					total-=parseInt($(this).parent().siblings("#price").text());
					$(".total").text(total);
				}
				if($(this).is(":checked")){
					total+=parseInt($(this).parent().siblings("#price").text());
					$(".total").text(total);
				}
			})
		})
	})
</script>