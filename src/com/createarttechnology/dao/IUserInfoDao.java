package com.createarttechnology.dao;

import com.createarttechnology.domain.UserInfo;

public interface IUserInfoDao extends IBaseDao<UserInfo> {
	//�����û�����ȡ�û�ID
	Integer getUserIdByUsername(String username);
	//�жϵ�¼��Ϣ�Ƿ�Ϸ�
	Boolean userValid(String username, String password, String offset);

}