package com.createarttechnology.action;

import java.util.Map;

import com.createarttechnology.dao.IUserAccountDao;
import com.createarttechnology.dao.IUserInfoDao;
import com.createarttechnology.domain.UserAccount;
import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.util.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ModifySafeAction extends ActionSupport {

	private String password;
	private String newPassword;
	private String email;
	private IUserAccountDao accountDao;
	private IUserInfoDao infoDao;
	
	public void setPassword(String password) {
		this.password = password;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAccountDao(IUserAccountDao accountDao) {
		this.accountDao = accountDao;
	}
	public void setInfoDao(IUserInfoDao infoDao) {
		this.infoDao = infoDao;
	}
	
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
        UserInfo ui = (UserInfo) session.get("userinfo");
        UserAccount ua = accountDao.getUserAccount(ui.getId());
    	if(password.length() != 0) {
    		if(infoDao.userValid(ui.getUsername(), password, ActionContext.getContext())) {
        		ui.setPassword(newPassword);
        		infoDao.updateUserInfo(ui);
        		session.put("userinfo", ui);
    		}
    		else {
        		session.put("message", Message.MODIFY_ERROR);
        		return INPUT;
    		}
    	}
        if(ua == null) {
           	ua = new UserAccount();
           	ua.setId(ui.getId());
           	ua.setEmail(email);
           	accountDao.saveUserAccount(ua);
        }
        else {
           	ua.setEmail(email);
           	accountDao.updateUserAccount(ua);
        }
		session.put("message", Message.MODIFY_SUCCESS);
    	return SUCCESS;
	}
	
}
