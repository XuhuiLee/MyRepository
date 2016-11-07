<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:form class="if" id="iconform" enctype="multipart/form-data" action="imageUpload">
	<div class="container" id="select">
		<img src="<s:property value="userAccount.icon" />" height="200" width="200" />
		<s:file name="upload" class="select" value="file" onchange="iconOnSubmit()"/>
		<s:submit value="上传" class="container" id="save" onclick="return iconOnSubmit()" />
		<div class="errorMessage" id="icon">大小限制1MB，建议比例1:1</div>
	</div>
</s:form>