<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//从session中移除username
session.removeAttribute("user");
response.sendRedirect("login.jsp");
%>