package com.createarttechnology.dao.impl;

import java.io.Serializable;
import com.createarttechnology.dao.IUserAccountDao;
import com.createarttechnology.domain.UserAccount;

public class UserAccountDaoImpl extends BaseDaoImpl<UserAccount> implements IUserAccountDao {

	@Override
	public UserAccount get(Class entityType, Serializable id) {
		UserAccount ua = this.get(UserAccount.class, id);
		if(ua == null) {
			ua = new UserAccount();
			ua.setId((Integer)id);
			this.save(ua);
		}
		return ua;
	}
	
}
