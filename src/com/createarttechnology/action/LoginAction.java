package com.createarttechnology.action;

import java.util.Map;

import com.createarttechnology.dao.IUserInfoDao;
import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.util.CookieManager;
import com.createarttechnology.util.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	private String username;
	private String password;
	private IUserInfoDao dao;
	
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
	public void setDao(IUserInfoDao dao) {
		this.dao = dao;
	}
	
	public String execute() throws Exception {
        boolean exist = dao.usernameExist(username);
        if(!exist) {
        	this.addFieldError("username" , "*用户名不存在");
        	return INPUT;
        }
        boolean valid = dao.userValid(username, password, ActionContext.getContext());
        if(valid) {
    		Map<String, Object> session = ActionContext.getContext().getSession();
        	Integer id = dao.getUserId(username);
        	UserInfo ui = dao.getUserInfo(id);
    		CookieManager.set("u_id", id.toString());
    		CookieManager.set("u_username", username);
    		session.put("userinfo", ui);
    		session.put("message", Message.LOGIN_SUCCESS);
        	return SUCCESS;
        }
        else {
        	this.addFieldError("password" , "*密码错误");
        	return INPUT;
        }
	}
	
}
