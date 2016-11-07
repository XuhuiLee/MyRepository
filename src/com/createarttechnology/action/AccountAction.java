package com.createarttechnology.action;

import java.util.Map;

import com.createarttechnology.domain.UserAccount;
import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.service.IUserAccountService;
import com.createarttechnology.service.IUserInfoService;
import com.createarttechnology.util.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport {

	private static final long serialVersionUID = 3664494417661602674L;
	
	private Integer userId;
	private UserInfo userInfo;
	private UserAccount userAccount;
	private IUserInfoService userInfoService;
	private IUserAccountService userAccountService;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	public void setUserAccountService(IUserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public UserAccount getUserAccount() {
		return userAccount;
	}
	
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		userInfo = (UserInfo) session.get("userinfo");
		if(userInfo != null && userId == null) userId = userInfo.getId();
		if(userInfo == null || userInfo.getId() != userId) {
			if(userId == null) {
				session.put("message", Message.PAGE_NOT_FOUND);
				return ERROR;
			}
			userInfo = userInfoService.getUserInfo(userId);
			if(userInfo == null) {
				session.put("message", Message.PAGE_NOT_FOUND);
				return ERROR;
			}
		}
		userAccount = userAccountService.getUserAccount(userInfo.getId());
		return SUCCESS;
	}
	
}
