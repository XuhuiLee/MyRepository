package com.createarttechnology.service.impl;

import com.createarttechnology.dao.IUserAccountDao;
import com.createarttechnology.domain.UserAccount;
import com.createarttechnology.service.IUserAccountService;

public class UserAccountServiceImpl implements IUserAccountService {

	private IUserAccountDao userAccountDao;
	
	public IUserAccountDao getUserAccountDao() {
		return userAccountDao;
	}
	public void setUserAccountDao(IUserAccountDao userAccountDao) {
		this.userAccountDao = userAccountDao;
	}

	@Override
	public Boolean saveUserAccount(UserAccount userAccount) {
		return this.getUserAccountDao()
			.save(userAccount) == null;
	}

	@Override
	public void deleteUserAccount(UserAccount userAccount) {
		this.getUserAccountDao()
			.delete(userAccount);
	}

	@Override
	public void deleteUserAccountById(int userId) {
		this.getUserAccountDao()
			.delete(UserAccount.class, userId);
	}

	@Override
	public void updateUserAccount(UserAccount userAccount) {
		this.getUserAccountDao()
			.update(userAccount);
	}

	@Override
	public UserAccount getUserAccount(int userId) {
		UserAccount user_account = this.getUserAccountDao()
			.get(UserAccount.class, userId);
		if(user_account == null) {
			user_account = new UserAccount();
			user_account.setId((Integer) userId);
			this.getUserAccountDao()
				.save(user_account);
		}
		return user_account;
	}
	
}
