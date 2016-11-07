package com.createarttechnology.util;

import java.util.Comparator;

import com.createarttechnology.action.IndexAction.ArticleInfo;

public class ArticleComparator implements Comparator<ArticleInfo> {

	@Override
	public int compare(ArticleInfo arg0, ArticleInfo arg1) {
		return arg1.getId() - arg0.getId();
	}
	
}
