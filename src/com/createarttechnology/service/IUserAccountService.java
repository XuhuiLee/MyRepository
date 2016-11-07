package com.createarttechnology.service;

import com.createarttechnology.domain.UserAccount;

public interface IUserAccountService {
	//保存用户信息
	Boolean saveUserAccount(UserAccount userAccount);
	//删除用户信息
	void deleteUserAccount(UserAccount userAccount);
	//根据用户ID删除用户信息
	void deleteUserAccountById(int userId);
	//更新用户信息
	void updateUserAccount(UserAccount userAccount);
	//根据用户ID获取用户信息
	UserAccount getUserAccount(int userId);
	
}
