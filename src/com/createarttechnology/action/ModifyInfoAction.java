package com.createarttechnology.action;

import com.createarttechnology.dao.IUserAccountDao;
import com.createarttechnology.domain.UserAccount;
import com.createarttechnology.domain.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyInfoAction extends ActionSupport {

	private String name;
	private String sign;
	private Integer sex;
	private IUserAccountDao dao;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public void setDao(IUserAccountDao dao) {
		this.dao = dao;
	}
	
	public String execute() throws Exception {
        UserInfo ui = (UserInfo) ActionContext.getContext().getSession().get("userinfo");
        UserAccount ua = dao.get(UserAccount.class, ui.getId());
        if(ua == null) {
        	ua = new UserAccount();
        	ua.setId(ui.getId());
        	ua.setName(name);
        	ua.setSign(sign);
        	ua.setSex(sex);
        	dao.save(ua);
        }
        else {
        	ua.setName(name);
        	ua.setSign(sign);
        	ua.setSex(sex);
        	dao.update(ua);
        }
    	return SUCCESS;
	}
	
}
