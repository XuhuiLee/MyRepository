package com.createarttechnology.util;

import java.util.Random;

import javax.servlet.http.HttpSession;

public class Offset {
	
	public static Integer generate(HttpSession session) {
		Random rand = new Random();
		Integer offset = rand.nextInt();
		session.setAttribute("offset", offset);
		return offset;
	}
	
}