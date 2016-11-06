package com.createarttechnology.dao;

import com.createarttechnology.domain.UserInfo;
import com.opensymphony.xwork2.ActionContext;

public interface IUserInfoDao extends IBaseDao<UserInfo> {
	//�����û�����ȡ�û�ID
	int getUserIdByUsername(String username);
	//�жϵ�¼��Ϣ�Ƿ�Ϸ�
	boolean userValid(String username, String password, ActionContext ctx);
	//�ж��û���Ϣ�Ƿ��Ѵ���
	boolean userExist(UserInfo ui);
	//�ж��û����Ƿ��Ѵ���
	boolean usernameExist(String username);

}