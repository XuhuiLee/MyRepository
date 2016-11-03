package com.createarttechnology.dao;

import com.createarttechnology.domain.UserInfo;
import com.opensymphony.xwork2.ActionContext;

public interface IUserInfoDao {
	boolean saveUserInfo(UserInfo ui);
	void deleteUserInfo(UserInfo ui);
	void updateUserInfo(UserInfo ui);
	UserInfo getUserInfo(Integer id);
	int getUserId(String username);
	boolean userValid(String username, String password, ActionContext ctx);
	boolean userExist(UserInfo ui);
	boolean usernameExist(String username);
}