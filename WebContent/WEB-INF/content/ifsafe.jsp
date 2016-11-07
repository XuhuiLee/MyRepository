<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.createarttechnology.util.*" %>
<%Offset.generate(request.getSession()); %>
<div class="offset" style="display:none"><%=request.getSession().getAttribute("offset").toString() %></div>
<s:form action="modifySafeAction" class="if" id="safeform">
	<div class="container" id="username">
		<div class="text">用户名：</div>
		<div class="input"><s:property value="username" /></div>
	</div>
	<div class="container" id="old">
		<div class="text">原密码：</div>
		<input type="password" class="input" id="old" name="password" placeholder="当前使用的密码" />
	</div>
	<div class="errorMessage" id="old"></div>
	<div class="container" id="new">
		<div class="text">新密码：</div>
		<input type="password" class="input" id="new" name="newPassword" placeholder="6~30字符，如不修改请勿填写"/>
	</div>
	<div class="errorMessage" id="new"></div>
	<div class="container" id="confirm">
		<div class="text">确认密码：</div>
		<input type="password" class="input" id="confirm" placeholder="确认新密码"/>
	</div>
	<div class="errorMessage" id="confirm"></div>
	<div class="container" id="email">
		<div class="text">E-mail：</div>
		<input class="input" id="email" name="email" placeholder="找回密码时使用" value='<s:property value="userAccount.email" />' >
	</div>
	<div class="errorMessage" id="email"></div>
	<div class="container" id="save">
		<button type="submit" onclick="return safeOnSubmit()" >保&nbsp;存</button>
	</div>
</s:form>