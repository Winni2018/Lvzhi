$(function(){
	$(".right1").load("person/myperson.jsp");
	
	$(".myinfo").click(function(){
		$(".right1").load("person/Info.jsp");
	});
	$(".add").click(function(){
		$(".right1").load("person/address.jsp");
	});
	$(".gunali").click(function(){
		$(".right1").load("person/save.jsp");
	});
	//$(".order").click(function(){
	//	$(".right1").load("person/order.jsp");
	//});
	$(".change").click(function(){
		$(".right1").load("person/change.jsp");
	});
	$(".change1").click(function(){
		$(".right1").load("person/change1.jsp");
	});
	$(".review").click(function(){
		$(".right1").load("person/review.jsp");
	});
	$(window).scroll(function(){
		if($(window).scrollTop()>700){
			$(".topreturn").fadeIn();
		}
		else{
			$(".topreturn").fadeOut();
		}
	});
	
})
