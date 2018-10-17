<%@page import="com.login.Lz.Bean.*"%>
<%@page import="com.login.Lz.Service.*"%>
<%@page import="java.util.List"%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h4>安全管理</h4>
<div class="row save">
	<div class="col-md-8 col-xs-8 col-sm-8 save-left">
		<h3>账号密码</h3>
		<span>用于保护帐号信息和登录安全</span>
	</div>
	<div class="col-md-3 col-xs-3 col-sm-3 save-right">
		<button type="submit" class="btn btn-xs">修改</button>
	</div>

</div>
<div class="row save">
	<div class="col-md-8 col-xs-8 col-sm-8 save-left">
		<h3>安全邮箱</h3>
		<span>安全邮箱将可用于登录小米帐号和重置密码，建议立即设置</span>
	</div>
	<div class="col-md-3 col-xs-3 col-sm-3 save-right">
		<button type="submit" class="btn btn-xs">绑定</button>
	</div>
</div>
<div class="row save">
	<div class="col-md-8 col-xs-8 col-sm-8 save-left">
		<h3>安全手机</h3>
		<span>安全手机可以用于登录帐号，重置密码或其他安全验证</span>
	</div>
	<div class="col-md-3 col-xs-3 col-sm-3 save-right">
		<button type="submit" class="btn btn-xs">绑定</button>
	</div>

</div>