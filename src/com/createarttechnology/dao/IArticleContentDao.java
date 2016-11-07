package com.createarttechnology.dao;

import java.util.List;
import com.createarttechnology.domain.ArticleContent;

public interface IArticleContentDao extends IBaseDao<ArticleContent> {
	//��ȡ�������µ�ID
	List<Integer> getArticleIds();
	//��������ID��ȡ������Ϣ
	List<Object[]> getArticleInfosById(List<Integer> articleIds);
	
}
