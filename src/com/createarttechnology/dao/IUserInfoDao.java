package com.createarttechnology.dao;

import com.createarttechnology.domain.UserInfo;

public interface IUserInfoDao extends IBaseDao<UserInfo> {
	//根据用户名获取用户ID
	Integer getUserIdByUsername(String username);
	//判断登录信息是否合法
	Boolean userValid(String username, String password, String offset);

}