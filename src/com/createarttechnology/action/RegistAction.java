package com.createarttechnology.action;

import com.createarttechnology.domain.UserAccount;
import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.service.IUserAccountService;
import com.createarttechnology.service.IUserInfoService;
import com.createarttechnology.util.MD5;
import com.createarttechnology.util.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport {

	private static final long serialVersionUID = 1738325412680298787L;
	
	private String username;
	private String password;
	private IUserInfoService userInfoService;
	private IUserAccountService userAccountService;
	
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
	public void setUserAccountService(IUserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}
	
	public String execute() throws Exception {
        if(userInfoService.usernameExist(username)) {
        	this.addFieldError("username" , "*用户名已被注册");
        	return INPUT;
        }
        String md5password = MD5.toMD5(password);
    	UserInfo user_info = new UserInfo();
    	user_info.setUsername(username);
    	user_info.setPassword(md5password);
    	userInfoService.saveUserInfo(user_info);
    	int user_id = userInfoService.getUserIdByUsername(username);
    	UserAccount user_account = new UserAccount();
    	user_account.setId(user_id);
    	userAccountService.saveUserAccount(user_account);
		ActionContext.getContext().getSession().put("message", Message.REGIST_SUCCESS);
    	return SUCCESS;
	}
}
