package com.poly.interceptor;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.poly.entity.Account;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LogInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Account user = (Account) request.getSession().getAttribute("user");
		String fullname = (user != null) ? user.getFullname() : "Anonymous";
		System.out.println(request.getRequestURI() + ", " + new Date() + ", " + fullname);
		return true;
	}
	
}
