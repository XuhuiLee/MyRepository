package com.createarttechnology.action;

import java.util.Map;

import com.createarttechnology.domain.ArticleComment;
import com.createarttechnology.domain.UserAccount;
import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.service.IArticleCommentService;
import com.createarttechnology.service.IUserAccountService;
import com.createarttechnology.util.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CommentAction extends ActionSupport {
	
	private static final long serialVersionUID = 4599094726614709895L;
	
	private Integer articleId;
	private Integer replyId;
	private String data;
	private IArticleCommentService articleCommentService;
	private IUserAccountService userAccountService;
	private String result;
	
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public void setArticleCommentService(IArticleCommentService articleCommentService) {
		this.articleCommentService = articleCommentService;
	}
	public void setUserAccountService(IUserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}
	
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
        if(articleId == null) {
			session.put("message", Message.PAGE_NOT_FOUND);
        	setResult("ERROR");
			return SUCCESS;
		}
        ArticleComment article_comment = new ArticleComment();
        UserInfo user_info = (UserInfo) (session.get("userinfo"));
        UserAccount ua = userAccountService.getUserAccount(user_info.getId());
        article_comment.setArticleId(articleId);
        article_comment.setUserInfo(user_info);
        article_comment.setReplyId(replyId);
        article_comment.setData(data);
        article_comment.setUserAccount(ua);
    	articleCommentService.saveArticleComment(article_comment);
    	setResult("SUCCESS");
    	return SUCCESS;
	}
	
}
