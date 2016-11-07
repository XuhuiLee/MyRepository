<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.createarttechnology.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<s:if test="articleId==null">
<%
request.getSession().setAttribute("message", Message.PAGE_NOT_FOUND);
response.sendRedirect("message");
%>
</s:if>
<title><s:property value="articleContent.title" /></title>
<!-- CSS -->
<link rel="stylesheet" href="css/article.css" />
<!-- JS -->
<script src="js/jquery-2.1.4.js"></script>
<script src="js/article.js"></script>
<script src="js/cookie.js"></script>
</head>
<body>
<!--置顶信息栏-->
<jsp:include page="top.jsp"/>
<!--导航-->
<jsp:include page="nav.jsp"/>
<!--内容-->
<div class="main_container">
	<!--正文-->
    <div class="content_container">
        <div class="content_title"><s:property value="articleContent.title" /></div>
        <div class="content_annotation"><s:property value="articleContent.annotation" /></div>
        <div class="content_information">
            <div class="content_author">
                <div class="content_author_icon"><img src="img/User/icon.png" width="30" height="30" /></div>
                <div class="content_author_name"><a href='<s:url action="account"><s:param name="userId" value="articleContent.userId" /></s:url>' target="_blank"><s:property value="name" /></a></div>
            </div>
            <div class="content_date"><s:property value="articleContent.date" /></div>
        	<div class="content_line"><hr /></div>
        </div>
        <div class="content_data"><s:property value="articleContent.data" escapeHtml="false"/></div>
        <div class="content_addons">
            <div class="content_thumb">
            	<button class="button_thumb" <s:if test="#session.userinfo==null">disabled="disabled"</s:if>><div id="left"><img src="img/Article/thumb.png" width="27" height="27" /></div><div id="right"><s:property value="thumb" />人觉得很赞</div>
            	</button>
            </div>
        	<div class="content_line"><hr /></div>
            <div class="content_tag">tag</div>
        </div>
    </div>
    <!--评论-->
    <jsp:include page="comment.jsp"/>
</div>
</body>
</html>