package com.createarttechnology.action;

import java.util.Map;

import com.createarttechnology.util.CookieManager;
import com.createarttechnology.util.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	
	private static final long serialVersionUID = -7995423270487564299L;

	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		CookieManager.del("u_id");
		CookieManager.del("u_username");
		session.remove("userinfo");
		session.put("message", Message.LOGOUT_SUCCESS);
    	return SUCCESS;
	}
	
}
