<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.createarttechnology.domain.UserInfo" %>
<link href="css/top.css" rel="stylesheet" type="text/css" />
<script src="js/top.js"></script>
<% UserInfo ui = (UserInfo)session.getAttribute("userinfo"); %>
<div class="top_container">
    <div class="top">
        <ul class="top_left">
			<li><div class="top_item"><a href='index'>首页</a></div></li>
        </ul>
        <ul class="top_right">
		<s:if test="#session.userinfo!=null">
			<li class="user">
				<div class="user_container">
	                <a href="#"><%=ui.getUsername() %></a>
	                <a href='account'>个人空间</a>
	                <a href="logoutAction">登出账号</a>
				</div>
				<script>hide()</script>
			</li>
		</s:if>
		<s:else>
			<li><div class="top_item"><a href='login'>登录</a></div></li>
			<li><div class="top_item"><a href='regist'>注册</a></div></li>
		</s:else>
        </ul>
    </div>
</div>