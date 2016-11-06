package com.createarttechnology.dao;

import java.util.List;

import com.createarttechnology.domain.ArticleComment;

public interface IArticleCommentDao extends IBaseDao<ArticleComment> {
	//��������ID�ҵ����¥�㣨�����м�¥��ɾ����
	Integer getMaxFloorByArticleId(Integer id);
	//��������IDͳ��������
	Integer countCommentsByArticleId(Integer id);
	//��������ID�����������
	List<ArticleComment> getAllCommentsByArticleId(Integer id);
	
}
