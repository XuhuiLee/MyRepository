package com.createarttechnology.interceptor;

import java.util.Map;

import com.createarttechnology.domain.UserInfo;
import com.createarttechnology.util.Message;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class RequireLoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 5467265468855912981L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		Map<String, Object> session = ctx.getSession();
		UserInfo ui = (UserInfo)session.get("userinfo");
		if(ui != null) {
			return invocation.invoke();
		}
		session.put("message", Message.REQUIRE_LOGIN);
		return Action.LOGIN;
	}
	
}
