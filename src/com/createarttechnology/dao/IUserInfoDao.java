package com.createarttechnology.dao;

import com.createarttechnology.domain.UserInfo;
import com.opensymphony.xwork2.ActionContext;

public interface IUserInfoDao extends IBaseDao<UserInfo> {
	int getUserId(String username);
	boolean userValid(String username, String password, ActionContext ctx);
	boolean userExist(UserInfo ui);
	boolean usernameExist(String username);
}