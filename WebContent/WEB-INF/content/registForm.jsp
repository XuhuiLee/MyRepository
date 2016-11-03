<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.createarttechnology.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新用户注册</title>
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
%>
<!-- JS -->
<script src="js/jquery-2.1.4.js"></script>
<script src="js/regist.js"></script>
<!-- CSS -->
<link rel="stylesheet" href="css/top.css" />
<link rel="stylesheet" href="css/regist.css" />
</head>

<body>
<!-- 置顶信息栏 -->
<jsp:include page="top.jsp"/>
<!-- 注册表单 -->
<div class="regist_container">
<s:form action="registAction" validate="true">
	<h1>注册</h1>
    <div class="text_container">*&nbsp;<div class="text_black">用户名：</div></div>
    <input type="text" name="username" class="edit_text" id="username" placeholder="6~30位英文字母、数字或下划线组成" value='<s:property value="username"/>' >
	<s:fielderror fieldName="username"/>
    <div class="text_container">*&nbsp;<div class="text_black">密码：</div></div>
    <input type="password" name="password" class="edit_text" id="password" placeholder="6~32位，请注意大小写">
	<s:fielderror fieldName="password"/>
    <div class="text_container">*&nbsp;<div class="text_black">确认密码：</div></div>
    <input type="password" name="repeat_password" class="edit_text" id="repeat_password" placeholder="再输入一次密码">
	<div class="errorMessage" id="repeat_password" ></div>
    <div class="agreement_container">
    	<input type="checkbox" name="agreement_checkbox" class="agree_check" value="false"/>
    	<div class="agreement_text">我已阅读并同意<a href="agreement" target="_blank">《C.A.T网站服务条款》</a></div>
    </div>
    <input type="submit" value="注&nbsp;&nbsp;&nbsp;&nbsp;册" class="button" id="submit" disabled="disabled">
</s:form>
</div>

</body>
</html>