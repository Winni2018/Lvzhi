$(function(){
	$(".navMenu").click(function(){
		var mtitle=$(this).html();
		var murl=$(this).attr("url");
		var tabsexit=$("#tabs").tabs("exists",mtitle);
		if(!tabsexit){
			$("#tabs").tabs("add",{title:mtitle,content:getContent(murl),closable:true});
		}else{
			$("#tabs").tabs("select",mtitle);
		}
	});
	$("#tabs").tabs("add",{
		title:"首页",
		content:getContent("Admin/home.jsp"),
		closable:true
		});
	
});
function getContent(url){
	return "<iframe src='"+url+"' width='100%' height='100%' frameborder='0'></iframe>";
}
