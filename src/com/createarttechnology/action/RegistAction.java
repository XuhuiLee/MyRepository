package com.createarttechnology.action;

import com.createarttechnology.dao.IUserAccountDao;
import com.createarttechnology.dao.IUserInfoDao;
import com.createarttechnology.domain.UserAccount;
import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.util.MD5;
import com.createarttechnology.util.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport {

	private String username;
	private String password;
	private IUserInfoDao uiDao;
	private IUserAccountDao uaDao;
	
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
	public void setUiDao(IUserInfoDao uiDao) {
		this.uiDao = uiDao;
	}
	public void setUaDao(IUserAccountDao uaDao) {
		this.uaDao = uaDao;
	}
	
	public String execute() throws Exception {
        boolean exist = uiDao.usernameExist(username);
        if(exist) {
        	this.addFieldError("username" , "*用户名已被注册");
        	return INPUT;
        }
        String md5password = MD5.toMD5(password);
    	UserInfo ui = new UserInfo();
    	ui.setUsername(username);
    	ui.setPassword(md5password);
    	uiDao.saveUserInfo(ui);
    	int id = uiDao.getUserId(username);
    	UserAccount ua = new UserAccount();
    	ua.setId(id);
    	uaDao.saveUserAccount(ua);
		ActionContext.getContext().getSession().put("message", Message.REGIST_SUCCESS);
    	return SUCCESS;
	}
}
