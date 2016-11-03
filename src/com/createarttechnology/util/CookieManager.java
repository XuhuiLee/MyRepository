package com.createarttechnology.util;

import javax.servlet.http.Cookie;
import org.apache.struts2.ServletActionContext;

public class CookieManager {
	
	public static void set(String key, String value) {
		Cookie c = new Cookie(key, value);
		ServletActionContext.getResponse().addCookie(c);
	}
	
	public static void set(String key, String value, int time) {
		Cookie c = new Cookie(key, value);
		if(time != -1) c.setMaxAge(time);
		ServletActionContext.getResponse().addCookie(c);
	}
	
	public static String get(String key) {
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		for(Cookie c : cookies) {
			if(c.getName().equals(key)) return c.getValue();
		}
		return null;
	}
	
	public static void del(String key) {
		set(key, "", 0);
	}
	
	public static boolean check(String key) {
		if(get(key) == null) return false;
		else return true;
	}
	
}
