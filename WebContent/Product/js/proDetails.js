$(function(){
	//数量加开始
	$(".glyphicon-plus").click(function(){
		var no=parseInt($(this).siblings("#shopNo").val())+1;
		$(this).siblings("#shopNo").val(no);
	});
	//数量减开始
	$(".glyphicon-minus").click(function(){
		var no=parseInt($(this).siblings("#shopNo").val())-1;
		$(this).siblings("#shopNo").val(no);
	});
	
})