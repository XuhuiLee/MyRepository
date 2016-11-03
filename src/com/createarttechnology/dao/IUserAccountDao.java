package com.createarttechnology.dao;

import com.createarttechnology.domain.UserAccount;

public interface IUserAccountDao {
	boolean saveUserAccount(UserAccount ua);
	void deleteUserAccount(UserAccount ua);
	void updateUserAccount(UserAccount ua);
	UserAccount getUserAccount(Integer id);
	boolean userExist(Integer id);
	boolean updatePassword(Integer id, String password);
}
