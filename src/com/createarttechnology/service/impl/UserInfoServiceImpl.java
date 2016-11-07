package com.createarttechnology.service.impl;

import com.createarttechnology.dao.IUserInfoDao;
import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.service.IUserInfoService;

public class UserInfoServiceImpl implements IUserInfoService {

	private IUserInfoDao userInfoDao;
	
	public IUserInfoDao getUserInfoDao() {
		return userInfoDao;
	}
	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public Boolean saveUserInfo(UserInfo userInfo) {
		return this.getUserInfoDao()
			.save(userInfo) == null;
	}

	@Override
	public void deleteUserInfo(UserInfo userInfo) {
		this.getUserInfoDao()
			.delete(userInfo);
	}

	@Override
	public void deleteUserInfoByUserId(int userId) {
		this.getUserInfoDao()
			.delete(UserInfo.class, userId);
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		this.getUserInfoDao()
			.update(userInfo);
	}

	@Override
	public UserInfo getUserInfo(int userId) {
		return this.getUserInfoDao()
			.get(UserInfo.class, userId);
	}

	@Override
	public Integer getUserIdByUsername(String username) {
		return this.getUserInfoDao()
			.getUserIdByUsername(username);
	}

	@Override
	public Boolean validUserInfo(String username, String password, String offset) {
		return this.getUserInfoDao()
			.userValid(username, password, offset);
	}

	@Override
	public Boolean userInfoExist(UserInfo userInfo) {
		String username = this.getUserInfoDao()
			.get(UserInfo.class, userInfo.getId()).getUsername();
		return userInfo.getUsername().equals(username);
	}

	@Override
	public Boolean usernameExist(String username) {
		return getUserIdByUsername(username) != -1;
	}

	@Override
	public Long countUserInfo() {
		return this.getUserInfoDao()
			.getCount(UserInfo.class);
	}

}
