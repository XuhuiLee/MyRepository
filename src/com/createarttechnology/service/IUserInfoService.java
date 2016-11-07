package com.createarttechnology.service;

import com.createarttechnology.domain.UserInfo;

public interface IUserInfoService {
	//�����¼��Ϣ
	Boolean saveUserInfo(UserInfo userInfo);
	//ɾ����¼��Ϣ
	void deleteUserInfo(UserInfo userInfo);
	//�����û�IDɾ����¼��Ϣ
	void deleteUserInfoByUserId(int userId);
	//���ĵ�¼��Ϣ
	void updateUserInfo(UserInfo userInfo);
	//����ID��ȡ��¼��Ϣ
	UserInfo getUserInfo(int userId);
	//�����û�����ѯ�û�ID
	Integer getUserIdByUsername(String username);
	//��¼��Ϣ��֤
	Boolean validUserInfo(String username, String password, String offset);
	//�ж��û��Ƿ����
	Boolean userInfoExist(UserInfo userInfo);
	//�ж��û����Ƿ��ѱ�ʹ��
	Boolean usernameExist(String username);
	//ͳ���û���Ŀ
	Long countUserInfo();
	
}
