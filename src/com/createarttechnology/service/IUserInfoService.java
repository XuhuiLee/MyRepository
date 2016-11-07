package com.createarttechnology.service;

import com.createarttechnology.domain.UserInfo;

public interface IUserInfoService {
	//保存登录信息
	Boolean saveUserInfo(UserInfo userInfo);
	//删除登录信息
	void deleteUserInfo(UserInfo userInfo);
	//根据用户ID删除登录信息
	void deleteUserInfoByUserId(int userId);
	//更改登录信息
	void updateUserInfo(UserInfo userInfo);
	//根据ID获取登录信息
	UserInfo getUserInfo(int userId);
	//根据用户名查询用户ID
	Integer getUserIdByUsername(String username);
	//登录信息验证
	Boolean validUserInfo(String username, String password, String offset);
	//判断用户是否存在
	Boolean userInfoExist(UserInfo userInfo);
	//判断用户名是否已被使用
	Boolean usernameExist(String username);
	//统计用户数目
	Long countUserInfo();
	
}
