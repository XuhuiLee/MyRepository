package com.createarttechnology.util;

import java.util.Comparator;

import com.createarttechnology.action.IndexAction.ArticleInfo;

public class ArticleComparator implements Comparator {
	@Override
	public int compare(Object arg0, Object arg1) {
		ArticleInfo ai0 = (ArticleInfo) arg0;
		ArticleInfo ai1 = (ArticleInfo) arg1;
		return ai1.getId() - ai0.getId();
	}
}
