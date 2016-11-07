package com.createarttechnology.action;

import java.util.Map;

import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.service.IUserInfoService;
import com.createarttechnology.util.CookieManager;
import com.createarttechnology.util.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	private static final long serialVersionUID = 2261806726276317382L;
	
	private String username;
	private String password;
	private IUserInfoService userInfoService;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	public String execute() throws Exception {
        if(!userInfoService.usernameExist(username)) {
        	this.addFieldError("username" , "*用户名不存在");
        	return INPUT;
        }
		String offset = ActionContext.getContext().getSession().get("offset").toString();
		ActionContext.getContext().getSession().remove("offset");
        if(userInfoService.validUserInfo(username, password, offset)) {
    		Map<String, Object> session = ActionContext.getContext().getSession();
        	Integer user_id = userInfoService.getUserIdByUsername(username);
        	UserInfo user_info = userInfoService.getUserInfo(user_id);
    		CookieManager.set("u_id", user_id.toString());
    		CookieManager.set("u_username", username);
    		session.put("userinfo", user_info);
    		session.put("message", Message.LOGIN_SUCCESS);
        	return SUCCESS;
        }
        else {
        	this.addFieldError("password" , "*密码错误");
        	return INPUT;
        }
	}
	
}
