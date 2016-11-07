package com.createarttechnology.service;

import java.util.List;

import com.createarttechnology.domain.ArticleComment;

public interface IArticleCommentService {
	//��������
	Boolean saveArticleComment(ArticleComment articleComment);
	//ɾ������
	void deleteArticleComment(ArticleComment articleComment);
	//���������û�IDɾ������
	void deleteArticleCommentById(int articleId);
	//��������
	void updateArticleComment(ArticleComment articleComment);
	//��ȡID��Ӧ���µ���������
	List<ArticleComment> getAllArticleCommentsByArticleId(int articleId);
	//�����û�ID��ȡ��������
	List<ArticleComment> getAllArticleCommentsByUserId(int userId);
	//��ȡ��������
	Long countArticleCommentsByArticleId(int articleId);
	
}
