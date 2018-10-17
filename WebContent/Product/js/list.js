$(function(){
	$(".pagination").children().click(function(){
		$(this).addClass("active");
		$(this).siblings().removeClass("active");
	});
	$(".thpic").mousemove(function(){
		$(this).addClass("hover");
		$(this).removeClass("hover1");
		
	});
	$(".thpic").mouseleave(function(){
		$(this).removeClass("hover");
		$(this).addClass("hover1");

	});
})