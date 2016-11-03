package com.createarttechnology.action;

import com.createarttechnology.dao.IUserAccountDao;
import com.createarttechnology.domain.UserAccount;
import com.createarttechnology.domain.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyIconAction extends ActionSupport {

	private String icon;
	private IUserAccountDao dao;
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public void setDao(IUserAccountDao dao) {
		this.dao = dao;
	}

	public String execute() throws Exception {
        UserInfo ui = (UserInfo) ActionContext.getContext().getSession().get("userinfo");
        UserAccount ua = dao.getUserAccount(ui.getId());
        if(ua == null) {
        	ua = new UserAccount();
        	ua.setId(ui.getId());
        	ua.setIcon(icon);
        	dao.saveUserAccount(ua);
        }
        else {
        	ua.setIcon(icon);
        	dao.updateUserAccount(ua);
        }
    	return SUCCESS;
	}
	
}
