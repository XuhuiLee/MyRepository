package com.createarttechnology.service;

import com.createarttechnology.domain.ArticleThumb;

public interface IArticleThumbService {
	//�������
	Boolean saveArticleThumb(ArticleThumb articleThumb);
	//����û��Ƿ�����
	Boolean existThumb(ArticleThumb articleThumb);
	//��������IDͳ�Ƶ�����
	Long countThumb(int articleId);
	
}
