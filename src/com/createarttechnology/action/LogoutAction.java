package com.createarttechnology.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.createarttechnology.util.CookieManager;
import com.createarttechnology.util.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String referer = ServletActionContext.getRequest().getHeader("Referer");
		CookieManager.del("u_id");
		CookieManager.del("u_username");
		session.remove("userinfo");
		session.put("message", Message.LOGOUT_SUCCESS);
    	return SUCCESS;
	}
	
}
