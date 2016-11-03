<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到 C.A.T</title>
<!-- JS -->
<script src="js/jquery-2.1.4.js"></script>
<script src="js/index.js"></script>
<!-- CSS -->
<link rel="stylesheet" href="css/index.css" />
</head>

<body>
<!-- 置顶信息栏 -->
<jsp:include page="top.jsp"/>
<!-- 导航栏 -->
<jsp:include page="nav.jsp"/>

<!-- 文章 -->
<s:bean var="articleComparator" name="com.createarttechnology.util.ArticleComparator" />

<s:if test="articleInfos_C.size()>0">
<div class="articles">
	<!-- C图片墙 -->
	<div id="preview_C" class="preview">
		<ul>
	        <li><a href='<s:url action="article"><s:param name="id" value="26" /></s:url>' target="_blank"><img src="img/Index/C_1.png" width="950" height="400" name="新的C.A.T新的小游戏！"/></a></li>
	        <li><a href='<s:url action="article"><s:param name="id" value="25" /></s:url>' target="_blank"><img src="img/Index/C_2.png" width="950" height="400" name="新版C.A.T正式上线，欢迎提交BUG或建议！"/></a></li>
			<li><a href='<s:url action="article"><s:param name="id" value="3" /></s:url>' target="_blank"><img src="img/Index/C_3.png" width="950" height="400" name="猫俄罗斯方块现已提供下载╰(￣▽￣)╭"/></a></li>
		</ul>
	</div>
	<!-- C文章标题 -->
	<s:sort	source="articleInfos_C" comparator="#articleComparator" var="sortedList_C" />
	<div class="news_container" align="center" id="news_container">
		<ul>
			<s:iterator	value="#attr.sortedList_C" var="a">
			<li class="news_title">
				<a href='<s:url action="article"><s:param name="id" value="id" /></s:url>' target="_blank"><s:property value="title" /></a>
				<div class="article_info"><s:property value="date" />&nbsp;<s:property value="thumbs" />点赞&nbsp;<s:property value="comments" />评论</div>
				<hr />
			</li>
			</s:iterator>
		</ul>
	</div>
	<s:if test="articleInfos_C.size()>0 && articleInfos_A.size()>0 && articleInfos_T.size()>0">
	<div class="goto"><a href="create"><img src="img/Index/goto_C.png"/></a></div>
	</s:if>
</div>
</s:if>

<s:if test="articleInfos_A.size()>0">
<div class="articles">
	<!-- A图片墙 -->
	<div id="preview_A" class="preview">
		<ul>
	        <li><a href='<s:url action="article"><s:param name="id" value="24" /></s:url>' target="_blank"><img src="img/Index/A_1.png" width="950" height="400" name="庆祝改版里程碑1完成[]~(￣▽￣)~*"/></a></li>
	        <li><a href='<s:url action="article"><s:param name="id" value="22" /></s:url>' target="_blank"><img src="img/Index/A_2.png" width="950" height="400" name="喵星人Vol.2"/></a></li>
	        <li><a href='<s:url action="article"><s:param name="id" value="15" /></s:url>' target="_blank"><img src="img/Index/A_1.png" width="950" height="400" name="C.A.T怎能没有喵星人驻扎"/></a></li>
		</ul>
	</div>
	<!-- A文章标题 -->
	<s:sort	source="articleInfos_A" comparator="#articleComparator" var="sortedList_A" />
	<div class="news_container" align="center" id="news_container">
		<ul>
			<s:iterator	value="#attr.sortedList_A" var="a">
			<li class="news_title">
				<a href='<s:url action="article"><s:param name="id" value="id" /></s:url>' target="_blank"><s:property value="title" /></a>
				<div class="article_info"><s:property value="date" />&nbsp;<s:property value="thumbs" />点赞&nbsp;<s:property value="comments" />评论</div>
				<hr />
			</li>
			</s:iterator>
		</ul>
	</div>
	<s:if test="articleInfos_C.size()>0 && articleInfos_A.size()>0 && articleInfos_T.size()>0">
	<div class="goto"><a href="art"><img src="img/Index/goto_A.png"/></a></div>
	</s:if>
</div>
</s:if>

<s:if test="articleInfos_T.size()>0">
<div class="articles">
	<!-- T图片墙 -->
	<div id="preview_T" class="preview">
		<ul>
	        <li><a href='<s:url action="article"><s:param name="id" value="25" /></s:url>' target="_blank"><img src="img/Index/C_2.png" width="950" height="400" name="暂无图片，敬请期待"/></a></li>
		</ul>
	</div>
	<!-- T文章标题 -->
	<s:sort	source="articleInfos_T" comparator="#articleComparator" var="sortedList_T" />
	<div class="news_container" align="center" id="news_container">
		<ul>
			<s:iterator	value="#attr.sortedList_T" var="a">
			<li class="news_title">
				<a href='<s:url action="article"><s:param name="id" value="id" /></s:url>' target="_blank"><s:property value="title" /></a>
				<div class="article_info"><s:property value="date" />&nbsp;<s:property value="thumbs" />点赞&nbsp;<s:property value="comments" />评论</div>
				<hr />
			</li>
			</s:iterator>
		</ul>
	</div>
	<s:if test="articleInfos_C.size()>0 && articleInfos_A.size()>0 && articleInfos_T.size()>0">
	<div class="goto"><a href="technology"><img src="img/Index/goto_T.png"/></a></div>
	</s:if>
</div>
</s:if>

<!-- 公告 -->
<s:if test="articleInfos_C.size()>0 && articleInfos_A.size()>0 && articleInfos_T.size()>0">
<div class="announcement">
    <p>&nbsp;</p>
    <p id="title">公&nbsp;告</p>
    <p>&nbsp;</p>
    <hr />
    <p>最新已完成：2016/09/04 文件上传功能完成，可上传头像</p>
    <hr />
    <p>&nbsp;</p>
    <hr />
    <p><a href='<s:url action="updateinfo" />' target="_blank">网站更新记录</a></p>
    <hr />
    <p>&nbsp;</p>
    <hr />
    <p>ver:0.1.3</p>
    <hr />
    <p>&nbsp;</p>
</div>
<!-- 页脚 -->
<div class="footer">
	©2016 Lee Tel:188xxxx9187 <a href="http://www.miitbeian.gov.cn/" target="_blank">京ICP备15060321号</a>
</div>
</s:if>
</body>
</html>