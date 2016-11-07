package com.createarttechnology.dao;

import java.util.List;

import com.createarttechnology.domain.ArticleComment;

public interface IArticleCommentDao extends IBaseDao<ArticleComment> {
	//��������ID�ҵ����¥�㣨�����м�¥��ɾ����
	Integer getMaxFloorByArticleId(Integer articleId);
	//��������IDͳ��������
	Integer countCommentsByArticleId(Integer articleId);
	//��������ID�����������
	List<ArticleComment> getAllCommentsByArticleId(Integer articleId);
	//�����û�ID�����������
	List<ArticleComment> getAllCommentsByUserId(Integer userId);
}
