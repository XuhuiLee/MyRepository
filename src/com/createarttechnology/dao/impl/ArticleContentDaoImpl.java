package com.createarttechnology.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.createarttechnology.dao.IArticleContentDao;
import com.createarttechnology.dao.IBaseDao;
import com.createarttechnology.domain.ArticleContent;

public class ArticleContentDaoImpl implements IArticleContentDao {

	private IBaseDao base;
	
	public void setBase(IBaseDao base) {
		this.base = base;
	}

	@Override
	public boolean saveArticleContent(ArticleContent act) {
		boolean success = false;
		if(base.getSession().save(act) != null) {
			success = true;
		}
		base.closeSession();
		return success;
	}

	@Override
	public void deleteArticleContent(ArticleContent act) {
		base.getSession().delete(act);
		base.closeSession();
	}

	@Override
	public void updateArticleContent(ArticleContent act) {
		base.getSession().update(act);
		base.closeSession();
	}

	@Override
	public ArticleContent getArticleContent(Integer id) {
		ArticleContent act = base.getSession().get(ArticleContent.class, id);
		base.closeSession();
		return act;
	}

	@Override
	public List<Integer> getArticleIds() {
		List<Integer> ids = base.query("SELECT articleId FROM ArticleContent");
		return ids;
	}

	@Override
	public List<Object[]> getArticleInfos(List<Integer> ids) {
		List<Object[]> results = new ArrayList<Object[]>();
		Object[] result;
		for(Integer id : ids) {
			result = (Object[]) base.unique("SELECT title, userId, date, directory1 FROM ArticleContent WHERE articleId =" + id.toString());
			results.add(result);
		}
		return results;
	}

}
