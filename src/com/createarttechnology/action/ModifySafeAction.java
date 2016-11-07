package com.createarttechnology.action;

import java.util.Map;

import com.createarttechnology.domain.UserAccount;
import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.service.IUserAccountService;
import com.createarttechnology.service.IUserInfoService;
import com.createarttechnology.util.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ModifySafeAction extends ActionSupport {

	private static final long serialVersionUID = -1981682261449470931L;
	
	private String password;
	private String newPassword;
	private String email;
	private IUserAccountService userAccountService;
	private IUserInfoService userInfoService;
	
	public void setPassword(String password) {
		this.password = password;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUserAccountService(IUserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}
	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
        UserInfo user_info = (UserInfo) session.get("userinfo");
        UserAccount user_account = userAccountService.getUserAccount(user_info.getId());
    	if(password.length() != 0) {
    		String offset = ActionContext.getContext().getSession().get("offset").toString();
    		ActionContext.getContext().getSession().remove("offset");
    		if(userInfoService.validUserInfo(user_info.getUsername(), password, offset)) {
    			user_info.setPassword(newPassword);
        		userInfoService.updateUserInfo(user_info);
        		session.put("userinfo", user_info);
    		}
    		else {
        		session.put("message", Message.MODIFY_ERROR);
        		return INPUT;
    		}
    	}
    	user_account.setEmail(email);
        userAccountService.updateUserAccount(user_account);
		session.put("message", Message.MODIFY_SUCCESS);
    	return SUCCESS;
	}
	
}
