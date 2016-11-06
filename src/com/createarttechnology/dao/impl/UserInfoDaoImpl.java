package com.createarttechnology.dao.impl;

import java.util.List;
import com.createarttechnology.dao.IUserInfoDao;
import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.util.MD5;
import com.opensymphony.xwork2.ActionContext;

public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo> implements IUserInfoDao {

	@SuppressWarnings("unchecked")
	@Override
	public int getUserIdByUsername(String username) {
		String hql = "FROM UserInfo WHERE username = ?0";
		List<UserInfo> list = (List<UserInfo>) this.find(hql, username);
		if(list.isEmpty())return -1;
		else return list.get(0).getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean userValid(String username, String password, ActionContext ctx) {
		String hql = "FROM UserInfo WHERE username = ?0";
		List<UserInfo> list = (List<UserInfo>) this.find(hql, username);
		if(list.isEmpty())return false;
		String offset = ctx.getSession().get("offset").toString();
		ctx.getSession().remove("offset");
		String md5password = MD5.toMD5(list.get(0).getPassword() + offset);
		return md5password.equals(password);
	}

	@Override
	public boolean userExist(UserInfo ui) {
		String username = this.get(UserInfo.class, ui.getId()).getUsername();
		return ui.getUsername().equals(username);
	}

	@Override
	public boolean usernameExist(String username) {
		if(getUserIdByUsername(username) != -1) return true;
		else return false;
	}
	
}
