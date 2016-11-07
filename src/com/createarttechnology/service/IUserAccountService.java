package com.createarttechnology.service;

import com.createarttechnology.domain.UserAccount;

public interface IUserAccountService {
	//�����û���Ϣ
	Boolean saveUserAccount(UserAccount userAccount);
	//ɾ���û���Ϣ
	void deleteUserAccount(UserAccount userAccount);
	//�����û�IDɾ���û���Ϣ
	void deleteUserAccountById(int userId);
	//�����û���Ϣ
	void updateUserAccount(UserAccount userAccount);
	//�����û�ID��ȡ�û���Ϣ
	UserAccount getUserAccount(int userId);
	
}
