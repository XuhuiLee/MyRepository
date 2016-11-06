package com.createarttechnology.dao;

import com.createarttechnology.domain.ArticleThumb;

public interface IArticleThumbDao extends IBaseDao<ArticleThumb> {
	//�ж��û���ĳƪ�����Ƿ��ѵ���
	boolean existThumb(ArticleThumb at);
	//���ĳ���µĵ�������
	Long countThumbByArticleId(Integer articleId);
	
}
