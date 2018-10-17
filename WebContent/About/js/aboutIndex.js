$(function(){
	$(".section2-mb img").click(function(){
		$(this).parents().siblings(".section2-article").show();
		$(this).parent().hide();
	});
$(".section2-article").mouseout(function(){
	$(this).siblings(".section2-mb").hide();
	$(this).hide();
});
$(window).scroll(function(){
	if($(window).scrollTop()>200){
		$(".topreturn").fadeIn();
	}
	else{
		$(".topreturn").fadeOut();
	}
});
})