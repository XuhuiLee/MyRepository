package com.createarttechnology.dao;

import com.createarttechnology.domain.UserInfo;
import com.opensymphony.xwork2.ActionContext;

public interface IUserInfoDao extends IBaseDao<UserInfo> {
	//�����û�����ȡ�û�ID
	Integer getUserIdByUsername(String username);
	//�жϵ�¼��Ϣ�Ƿ�Ϸ�
	Boolean userValid(String username, String password, ActionContext ctx);
	//�ж��û���Ϣ�Ƿ��Ѵ���
	Boolean userExist(UserInfo userInfo);
	//�ж��û����Ƿ��Ѵ���
	Boolean usernameExist(String username);

}