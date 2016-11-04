package com.createarttechnology.dao;

import java.util.List;
import com.createarttechnology.domain.ArticleContent;

public interface IArticleContentDao extends IBaseDao<ArticleContent> {
	List<Integer> getArticleIds();
	List<Object[]> getArticleInfos(List<Integer> ids);
}
