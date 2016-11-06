package com.createarttechnology.action;

import java.util.Map;

import com.createarttechnology.dao.IUserAccountDao;
import com.createarttechnology.dao.IUserInfoDao;
import com.createarttechnology.domain.UserAccount;
import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.util.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport {

	private Integer id;
	private IUserInfoDao infoDao;
	private IUserAccountDao accountDao;
	private UserInfo ui;
	private UserAccount ua;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setInfoDao(IUserInfoDao infoDao) {
		this.infoDao = infoDao;
	}
	public void setAccountDao(IUserAccountDao accountDao) {
		this.accountDao = accountDao;
	}
	public String getUsername() {
		return ui.getUsername();
	}
	public UserAccount getUa() {
		return ua;
	}
	
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		ui = (UserInfo) session.get("userinfo");
		if(ui != null && id == null) id = ui.getId();
		if(ui == null || ui.getId() != id) {
			if(id == null) {
				session.put("message", Message.PAGE_NOT_FOUND);
				return ERROR;
			}
			ui = infoDao.get(UserInfo.class, id);
			if(ui == null) {
				session.put("message", Message.PAGE_NOT_FOUND);
				return ERROR;
			}
			ua = accountDao.get(UserAccount.class, ui.getId());
			if(ua == null) {
				ua = new UserAccount();
				ua.setId(id);
				accountDao.save(ua);
			}
		}
		else {
			ua = accountDao.get(UserAccount.class, ui.getId());
		}
		return SUCCESS;
	}
	
}
