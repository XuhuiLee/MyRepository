package com.createarttechnology.action;

import com.createarttechnology.domain.UserAccount;
import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.service.IUserAccountService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyInfoAction extends ActionSupport {

	private static final long serialVersionUID = 8184515948416273134L;
	
	private String name;
	private String sign;
	private Integer sex;
	private IUserAccountService userAccountService;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public void setUserAccountService(IUserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}
	
	public String execute() throws Exception {
        UserInfo user_info = (UserInfo) ActionContext.getContext().getSession().get("userinfo");
        UserAccount user_account = userAccountService.getUserAccount(user_info.getId());
        user_account.setName(name);
        user_account.setSign(sign);
        user_account.setSex(sex);
        userAccountService.updateUserAccount(user_account);
    	return SUCCESS;
	}
	
}
