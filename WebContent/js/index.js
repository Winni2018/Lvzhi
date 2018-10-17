$(function() {
	
	
	
	$(".section1-left").mouseover(function() {
		$(this).children().eq(1).show();
		$(this).children().eq(1).children().fadeIn();
		$(this).css("cursor", "pointer");

	});
	$(".section1-left").mouseout(function() {
		$(this).children().eq(1).hide();
		$(this).children().eq(1).children().hide();

	});
	$(".section1-right").mouseover(function() {
		$(this).children().eq(1).show();
		$(this).children().eq(1).children().fadeIn();
		$(this).css("cursor", "pointer");

	});
	$(".section1-right").mouseout(function() {
		$(this).children().eq(1).hide();
		$(this).children().eq(1).children().hide();

	});
	$("section").mouseover(function(){
		$(this).children().eq(3).show();
		$(this).children().eq(2).slideDown();
		
	});
	$("section").mouseout(function(){
		$(this).children().eq(3).hide();
		//\ 1 $(this).children().eq(2).hide();
		
	});
	$(".buy").mousemove(function(){
		$(this).addClass("hover");
		$(this).removeClass("hover1");
		$(this).children().eq(1).hide();
		$(this).children().eq(2).show();
	});
	$(".buy").mouseleave(function(){
		$(this).removeClass("hover");
		$(this).addClass("hover1");
		$(this).children().eq(1).show();
		$(this).children().eq(2).hide();
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
 