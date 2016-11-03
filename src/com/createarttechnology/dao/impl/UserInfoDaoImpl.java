package com.createarttechnology.dao.impl;

import java.util.List;

import com.createarttechnology.dao.IBaseDao;
import com.createarttechnology.dao.IUserInfoDao;
import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.util.MD5;
import com.opensymphony.xwork2.ActionContext;

public class UserInfoDaoImpl implements IUserInfoDao {

	private IBaseDao base;
	
	public void setBase(IBaseDao base) {
		this.base = base;
	}

	@Override
	public boolean saveUserInfo(UserInfo ui) {
		boolean success = false;
		if(!usernameExist(ui.getUsername())) {
			base.getSession().save(ui);
			success = true;
		}
		base.closeSession();
		return success;
	}

	@Override
	public void deleteUserInfo(UserInfo ui) {
		base.getSession().delete(ui);
		base.closeSession();
	}

	@Override
	public void updateUserInfo(UserInfo ui) {
		base.getSession().update(ui);
		base.closeSession();
	}

	@Override
	public UserInfo getUserInfo(Integer id) {
		UserInfo ui = base.getSession().get(UserInfo.class, id);
		base.closeSession();
		return ui;
	}

	@Override
	public int getUserId(String username) {
		List<UserInfo> list = base.query("FROM UserInfo WHERE username ='"+username+"'");
		if(list.isEmpty())return -1;
		else return list.get(0).getId();
	}

	@Override
	public boolean userValid(String username, String password, ActionContext ctx) {
		List<UserInfo> list = base.query("FROM UserInfo WHERE username ='"+username+"'");
		if(list.isEmpty())return false;
		String offset = ctx.getSession().get("offset").toString();
		ctx.getSession().remove("offset");
		String md5password = MD5.toMD5(list.get(0).getPassword() + offset);
		return md5password.equals(password);
	}

	@Override
	public boolean userExist(UserInfo ui) {
		String username = base.getSession().get(UserInfo.class, ui.getId()).getUsername();
		base.closeSession();
		return ui.getUsername().equals(username);
	}

	@Override
	public boolean usernameExist(String username) {
		if(getUserId(username) != -1) return true;
		else return false;
	}

}
