package com.createarttechnology.dao;

import com.createarttechnology.domain.ArticleThumb;

public interface IArticleThumbDao extends IBaseDao<ArticleThumb> {
	//�ж��û���ĳƪ�����Ƿ��ѵ���
	Boolean existThumb(ArticleThumb articleThumb);
	//���ĳ���µĵ�������
	Long countThumbByArticleId(Integer articleId);
	
}
