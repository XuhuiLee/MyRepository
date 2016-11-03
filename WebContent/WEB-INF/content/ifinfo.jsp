<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:form action="modifyInfoAction" class="if" id="infoform" >
	<div class="container" id="name">
	<s:if test="#session.userinfo!=null&&(id==null||id==#session.userinfo.id)">
		<div class="text">昵称：</div>
		<input class="input" id="name" name="name" placeholder="30字符以内" value='<s:property value="ua.name" />' >
	</s:if>
	<s:else>
		<div class="text">ta的昵称：</div>
		<div class="input">
		<s:if test="ua.name!=null"><s:property value="ua.name" /></s:if>
		<s:else>未填写</s:else>
		</div>
	</s:else>
	</div>
	<div class="errorMessage" id="name"></div>
	<div class="container" id="sign">
	<s:if test="#session.userinfo!=null&&(id==null||id==#session.userinfo.id)">
		<div class="text">签名：</div>
		<textarea class="input" id="sign" name="sign" placeholder="100字符以内" ><s:property value="ua.sign" /></textarea>
	</s:if>
	<s:else>
		<div class="text">ta的签名：</div>
		<s:if test="ua.sign!=null">
		<div class="input" id="sign"><s:property value="ua.sign" /></div>
		</s:if>
		<s:else>
		<div class="input" id="sign">未填写</div>
		</s:else>
	</s:else>
	</div>
	<div class="errorMessage" id="sign"></div>
	<div class="container" id="sex">
		<div class="text" id="sex"><s:if test="#session.userinfo!=null&&(id==null||id==#session.userinfo.id)">性别：</s:if>
		    <s:else>ta的性别：</s:else></div>
	    <div class="button_group">
	        <input type="button" id="m" value="男" />
	        <input type="button" id="f" value="女" />
	        <input type="button" id="u" value="保密" />
	        <input type="text" name="sex" class="hide" hidden="true" value=<s:property value="ua.sex" /> />
	    </div>
	</div>
	<s:if test="id==#session.userinfo.id||id==null">
	<div class="container" id="save">
		<button onclick="return infoOnSubmit()" type="submit" >保&nbsp;存</button>
	</div>
	</s:if>
</s:form>
<s:if test="#session.userinfo==null||(id!=null&&id!=#session.userinfo.id)">
<script>
hideSexBtn();
</script>
<style>
.if#infoform .text {
	width: 100px;
}
</style>
</s:if>
