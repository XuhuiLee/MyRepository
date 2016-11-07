package com.createarttechnology.action;

import com.createarttechnology.domain.UserAccount;
import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.service.IUserAccountService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyIconAction extends ActionSupport {

	private static final long serialVersionUID = -4384708018391740659L;
	
	private String icon;
	private IUserAccountService userAccountService;
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public void setUserAccountService(IUserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

	public String execute() throws Exception {
        UserInfo user_info = (UserInfo) ActionContext.getContext().getSession().get("userinfo");
        UserAccount user_account = userAccountService.getUserAccount(user_info.getId());
        user_account.setIcon(icon);
        userAccountService.updateUserAccount(user_account);
    	return SUCCESS;
	}
	
}
