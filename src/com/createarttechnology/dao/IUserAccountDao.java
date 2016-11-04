package com.createarttechnology.dao;

import com.createarttechnology.domain.UserAccount;

public interface IUserAccountDao extends IBaseDao<UserAccount> {
	boolean userExist(Integer id);
	boolean updatePassword(Integer id, String password);
}
