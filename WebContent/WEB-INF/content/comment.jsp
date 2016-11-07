<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.createarttechnology.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="comment_container">
<s:if test="comments.size()>0">
<s:iterator	value="comments" var="c">
	<div class="comment_item">
		<div class="comment_information">
			<div class="comment_user_icon"><img src="<s:property value="userAccount.icon" />" /></div>
			<div class="comment_user_username"><a href='<s:url action="account"><s:param name="id" value="userInfo.id" /></s:url>' target="_blank"><s:property value="name" /></a></div>
			<div class="comment_date"><s:property value="date" /></div>
			<div class="comment_floor"><s:property value="floor" />楼</div>
		</div>
		<div class="comment_data"><s:property value="data" /></div>
	</div>
</s:iterator>
</s:if>
<s:else>
	<div class="comment_item">
		<div class="comment_information">暂无评论</div>
		<div class="comment_data"><s:property value="randomText" /></div>
	</div>
</s:else>
</div>
<s:form class="comment_input">
	<input type="text" name="articleId" id="articleId" hidden="true" value='<s:property value="articleId" />' />
	<div class="comment_re"></div>
	<textarea name="data" class="comment_textarea"
		<s:if test="#session.userinfo==null">placeholder="评论需要先登录哦" disabled="disabled"</s:if>
    	<s:else>placeholder="评论字数上限为400字节"</s:else> ></textarea>
	<div class="comment_warn"></div>
    <s:if test="#session.userinfo==null">
    <input type="button" class="comment_submit" value="发表评论" disabled="disabled"/>
    </s:if>
    <s:else>
    <input type="button" class="comment_submit" value="发表评论" style="background:#0AE;color:#FFF"/>
    </s:else>
</s:form>
</body>