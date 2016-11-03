package com.createarttechnology.dao.impl;

import org.hibernate.Session;

import com.createarttechnology.dao.IBaseDao;
import com.createarttechnology.dao.IUserAccountDao;
import com.createarttechnology.domain.UserAccount;
import com.createarttechnology.domain.UserInfo;

public class UserAccountDaoImpl implements IUserAccountDao {

	private IBaseDao base;
	
	public void setBase(IBaseDao base) {
		this.base = base;
	}

	@Override
	public boolean saveUserAccount(UserAccount ua) {
		boolean success = false;
		if(getUserAccount(ua.getId()) == null) {
			base.getSession().save(ua);
			success = true;
			base.closeSession();
		}
		return success;
	}

	@Override
	public void deleteUserAccount(UserAccount ua) {
		base.getSession().delete(ua);
		base.closeSession();
	}

	@Override
	public void updateUserAccount(UserAccount ua) {
		base.getSession().update(ua);
		base.closeSession();
	}

	@Override
	public UserAccount getUserAccount(Integer id) {
		Session session = base.getSession();
		UserAccount ua = session.get(UserAccount.class, id);
		if(ua == null) {
			ua = new UserAccount();
			ua.setId(id);
			session.save(ua);
		}
		base.closeSession();
		return ua;
	}

	@Override
	public boolean userExist(Integer id) {
		UserInfo ua = base.getSession().get(UserInfo.class, id);
		base.closeSession();
		return ua == null;
	}
	
	@Override
	public boolean updatePassword(Integer id, String password) {
		boolean success = false;
		Session session = base.getSession();
		UserInfo ui = session.get(UserInfo.class, id);
		if(ui != null) {
			ui.setPassword(password);
			session.save(ui);
			success = true;
		}
		base.closeSession();
		return success;
	}

}
