<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.createarttechnology.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<s:if test="#session.message==null"><%response.sendRedirect("index");%></s:if>
<%
Message msg = (Message) request.getSession().getAttribute("message");
String target = msg.getTarget();
if(target == null) target = "index";
%>
<title><%=msg.getTitle() %></title>
<!-- CSS -->
<link rel="stylesheet" href="css/message.css"/>
</head>
<%response.addHeader("refresh", "3;" + target);%>
<body>
<div class="container">
    <div class="message"><%=msg.getMessage() %></div>
    <div class="link">
    	<a href="<%=target %>">若未能自动跳转，请点击这里</a>
    </div>
</div>
</body>
<%request.getSession().removeAttribute("message"); %>
</html>