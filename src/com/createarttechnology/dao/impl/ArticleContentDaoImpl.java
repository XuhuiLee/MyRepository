package com.createarttechnology.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.createarttechnology.dao.IArticleContentDao;
import com.createarttechnology.domain.ArticleContent;

public class ArticleContentDaoImpl extends BaseDaoImpl<ArticleContent> implements IArticleContentDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getArticleIds() {
		String hql = "SELECT articleId FROM ArticleContent";
		List<Integer> list = (List<Integer>) this.find(hql);
		return list;
	}

	@Override
	public List<Object[]> getArticleInfosById(List<Integer> articleIds) {
		List<Object[]> results = new ArrayList<Object[]>();
		Object[] result;
		String hql;
		for(Integer id : articleIds) {
			hql = "SELECT title, userId, date, directory1 FROM ArticleContent WHERE articleId = ?0";
			result = this.find(hql, id).toArray();
			result = (Object[]) result[0];
			results.add(result);
		}
		return results;
	}

}
