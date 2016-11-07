package com.createarttechnology.dao;

import java.util.List;
import com.createarttechnology.domain.ArticleContent;

public interface IArticleContentDao extends IBaseDao<ArticleContent> {
	//获取所有文章的ID
	List<Integer> getArticleIds();
	//根据文章ID获取描述信息
	List<Object[]> getArticleInfosById(List<Integer> articleIds);
	
}
