<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.createarttechnology.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户中心</title>
<s:if test="#session.userinfo==null&&id==null">
<%
request.getSession().setAttribute("message", Message.REQUIRE_LOGIN);
response.sendRedirect("message");
%>
</s:if>
<!-- CSS -->
<link rel="stylesheet" href="css/account.css"/>
<!-- JS -->
<script src="js/jquery-2.1.4.js"></script>
<script src="js/account.js"></script>
<script src="js/md5.js"></script>
</head>

<body>
<!-- 置顶信息栏 -->
<jsp:include page="top.jsp"/>
<!-- 内容 -->
<div class="main_container">
	<!--左侧栏-->
	<div class="bar">
    	<!--显示头像和昵称-->
    	<div class="info">
        	<div class="info_icon"><img name="" src="<s:property value="ua.icon" />" width="130" height="130" alt="" /></div>
            <div class="info_name">
		    <s:if test="ua.name!=null"><s:property value="ua.name" /></s:if>
		    <s:else>用户未填写昵称</s:else>
		    </div>
            <div class="hides" hidden="true" ><s:property value="ua.sex" /></div>
        </div>
        <div><hr color="#CCCCCC" size="1px"/></div>
        <!--每个子页面的按钮-->
    	<div class="button_group">
		    <button class="button_item" id="info" onclick="click_info()">用户信息</button>
		    <s:if test="#session.userinfo!=null&&(id==null||id==#session.userinfo.id)">
        	<button class="button_item" id="icon" onclick="click_icon()">用户头像</button>
        	<button class="button_item" id="safe" onclick="click_safe()">账号安全</button>
        	</s:if>
    	</div>
        <div><hr color="#CCCCCC" size="1px"/></div>
    </div>
    <!--右侧子页面-->
    <div class="inner_frame" id="info">
		<jsp:include page="ifinfo.jsp"/>
    </div>
    <s:if test="#session.userinfo!=null&&(id==null||id==#session.userinfo.id)">
    <div class="inner_frame" id="icon" style="display:none">
		<jsp:include page="ificon.jsp"/>
    </div>
    <div class="inner_frame" id="safe" style="display:none">
		<jsp:include page="ifsafe.jsp"/>
    </div>
    </s:if>
</div>
</body>
</html>
