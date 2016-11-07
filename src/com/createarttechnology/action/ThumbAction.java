package com.createarttechnology.action;

import com.createarttechnology.domain.ArticleThumb;
import com.createarttechnology.service.IArticleThumbService;
import com.opensymphony.xwork2.ActionSupport;

public class ThumbAction extends ActionSupport {
	
	private static final long serialVersionUID = -5100830918003191579L;
	
	private Integer articleId;
	private Integer userId;
	private IArticleThumbService articleThumbService;
	private String result;
	
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public void setArticleThumbService(IArticleThumbService articleThumbService) {
		this.articleThumbService = articleThumbService;
	}
	
	public String execute() throws Exception {
        if(articleId == null) {
        	setResult("ERROR");
			return SUCCESS;
		}
        if(userId == null) {
        	setResult("ERROR");
			return SUCCESS;
		}
        ArticleThumb article_thumb = new ArticleThumb();
        article_thumb.setArticleId(articleId);
        article_thumb.setUserId(userId);
        if(articleThumbService.existThumb(article_thumb)) {
        	setResult("INPUT");
        	return SUCCESS;
        }
        Long c = articleThumbService.countThumb(articleId) + 1;
    	setResult(c.toString());
    	articleThumbService.saveArticleThumb(article_thumb);
    	return SUCCESS;
	}
	
}
