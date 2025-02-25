package com.poly.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.poly.entity.Account;
import com.poly.service.SessionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {
	@Autowired
	SessionService session;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		session.set("securityUri", uri);
		Account user = (Account) request.getSession().getAttribute("user");
		if (user == null) {
			response.sendRedirect("/auth/login");
			return false;
		}
		if (uri.startsWith("/admin") && !user.isAdmin()) {
			response.sendRedirect("/auth/login");
			return false;
		}
		return true;
	}
}
