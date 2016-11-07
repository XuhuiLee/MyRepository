package com.createarttechnology.service;

import java.util.List;

import com.createarttechnology.domain.ArticleContent;

public interface IArticleContentService {
	//��������
	Boolean saveArticleContent(ArticleContent articleContent);
	//ɾ������
	void deleteArticleContent(ArticleContent articleContent);
	//����IDɾ������
	void deleteArticleContentById(int articleId);
	//��������
	void updateArticleContent(ArticleContent articleContent);
	//����ID��ȡ��������
	ArticleContent getArticleContent(int articleId);
	//��ȡȫ�����µ�ID
	List<Integer> getAllArticleId();
	//����ID��ȡ�����������Ϣ
	List<Object[]> getArticleInfo(List<Integer> articleIds);
	
}
