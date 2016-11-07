package com.createarttechnology.dao.impl;

import java.io.Serializable;
import com.createarttechnology.dao.IUserAccountDao;
import com.createarttechnology.domain.UserAccount;

public class UserAccountDaoImpl extends BaseDaoImpl<UserAccount> implements IUserAccountDao {

	@Override
	public UserAccount get(Class entityType, Serializable userId) {
		UserAccount user_account = this.get(UserAccount.class, userId);
		if(user_account == null) {
			user_account = new UserAccount();
			user_account.setId((Integer) userId);
			this.save(user_account);
		}
		return user_account;
	}
	
}
