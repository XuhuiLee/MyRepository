<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.createarttechnology.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录到 C.A.T</title>
<s:if test="#session.userinfo!=null">
<%
request.getSession().setAttribute("message", Message.ALREADY_LOGIN);
response.sendRedirect("message");
%>
</s:if>
<%
if(request.getSession().getAttribute("from_url") == null) {
	String referer = request.getHeader("Referer");
	request.getSession().setAttribute("from_url", referer);
}
Offset.generate(request.getSession());
%>
<!-- CSS -->
<link rel="stylesheet" href="css/top.css"/>
<link rel="stylesheet" href="css/login.css">
<!-- JS -->
<script src="js/jquery-2.1.4.js"></script>
<script src="js/login.js"></script>
<script src="js/md5.js"></script>
</head>
<div class="offset" style="display:none"><%=request.getSession().getAttribute("offset").toString() %></div>
<body>
<!-- 置顶信息栏 -->
<jsp:include page="top.jsp"/>
<!-- 登录表单 -->
<div class="login_container">
	<h1>欢迎</h1>
	<s:form action="loginAction" validate="true">
		<input type="text" name="username" class="username" placeholder="请输入用户名" value='<s:property value="username"/>' >
		<s:fielderror fieldName="username"/>
		<input type="password" name="password" class="password" placeholder="请输入密码" >
		<s:fielderror fieldName="password"/>
		<div class="prompt">
			<div class="prompt_item"><a href='#' class="getpswd">忘记密码？</a></div>
			<div class="prompt_item"><a href='regist' class="regist">注册</a></div>
		</div>
		<button type="submit" onclick="return onSubmit()">登&nbsp;&nbsp;&nbsp;&nbsp;录</button>
	</s:form>
</div>
<script>
$('.username').focus();
</script>
</body>
</html>