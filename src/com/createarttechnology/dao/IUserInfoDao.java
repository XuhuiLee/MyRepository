package com.createarttechnology.dao;

import com.createarttechnology.domain.UserInfo;
import com.opensymphony.xwork2.ActionContext;

public interface IUserInfoDao extends IBaseDao<UserInfo> {
	//根据用户名获取用户ID
	int getUserIdByUsername(String username);
	//判断登录信息是否合法
	boolean userValid(String username, String password, ActionContext ctx);
	//判断用户信息是否已存在
	boolean userExist(UserInfo ui);
	//判断用户名是否已存在
	boolean usernameExist(String username);

}