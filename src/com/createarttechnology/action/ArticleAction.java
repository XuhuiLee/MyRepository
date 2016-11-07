package com.createarttechnology.action;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.createarttechnology.domain.ArticleComment;
import com.createarttechnology.domain.ArticleContent;
import com.createarttechnology.domain.UserAccount;
import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.service.IArticleCommentService;
import com.createarttechnology.service.IArticleContentService;
import com.createarttechnology.service.IArticleThumbService;
import com.createarttechnology.service.IUserAccountService;
import com.createarttechnology.service.IUserInfoService;
import com.createarttechnology.util.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport {
	
	private static final long serialVersionUID = -3537330573430694357L;
	
	private Integer articleId;
	private ArticleContent articleContent;
	private String name;
	private List<ArticleComment> comments;
	private Long thumb;
	private IArticleCommentService articleCommentService;
	private IArticleThumbService articleThumbService;
	private IArticleContentService articleContentService;
	private IUserInfoService userInfoService;
	private IUserAccountService userAccountService;
	
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public ArticleContent getArticleContent() {
		return articleContent;
	}
	public String getName() {
		return name;
	}
	public List<ArticleComment> getComments() {
		return comments;
	}
	public Long getThumb() {
		return thumb;
	}
	public void setArticleCommentService(IArticleCommentService articleCommentService) {
		this.articleCommentService = articleCommentService;
	}
	public void setArticleThumbService(IArticleThumbService articleThumbService) {
		this.articleThumbService = articleThumbService;
	}
	public void setArticleContentService(IArticleContentService articleContentService) {
		this.articleContentService = articleContentService;
	}
	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	public void setUserAccountService(IUserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(articleId == null) {
			session.put("message", Message.PAGE_NOT_FOUND);
			return ERROR;
		}
		articleContent = articleContentService.getArticleContent(articleId);
		if(articleContent == null){
			session.put("message", Message.PAGE_NOT_FOUND);
			return ERROR;
		}
		name = getNameById(articleContent.getUserId());
		comments = articleCommentService.getAllArticleCommentsByArticleId(articleId);
		if(comments != null) {
			for(ArticleComment c : comments) {
				c.setName(getNameById(c.getUserInfo().getId()));
			}
		}
		thumb = articleThumbService.countThumb(articleId);
		return SUCCESS;
	}
	
	private String getNameById(Integer userId) {
		UserAccount user_account = userAccountService.getUserAccount(userId);
		String user_name;
		if(user_account == null || user_account.getName() == null) {
			UserInfo user_info = userInfoService.getUserInfo(userId);
			user_name = user_info.getUsername();
		}
		else {
			user_name = user_account.getName();
		}
		return user_name;
	}
	
	public String getRandomText() {
		String[] text = {
				"这么好的文章竟然没人评论(ノಠ益ಠ)ノ彡┻━┻",
				"沙发才不是给你留的呢，哼(〃｀ 3′〃)",
				"看少侠骨骼惊奇，我这珍藏多年的沙发就送给你了o(*￣▽￣*)ブ",
				"没人跟我抢沙发吧(ﾟДﾟ≡ﾟДﾟ)",
				"难道这就是传说中的沙发ε = = (づ′▽`)づ",
				"听说抢到这个沙发的人都被送去了德国骨科(。・＿・。)",
				"抢我沙发者，虽远必诛(*Φ皿Φ*)",
				"其实沙发已经被抢了，不信你试试┑(￣Д ￣)┍",
				"没人评论不开心(｡˘•ε•˘｡)",
				"别走，你忍心看着这死一般的寂静吗(￣┰￣*)",
				"没人陪我玩┭┮﹏┭┮</div>",
				"没关系，下次再评论也行(≧∇≦)ﾉ",
				"终于有人要评论了，我们下篇文章见哦(づ｡◕‿‿◕｡)づ",
		};
		int i = new Random().nextInt(text.length);
		return text[i];
	}
	
}
