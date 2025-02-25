package com.poly.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.poly.interceptor.AuthInterceptor;
import com.poly.interceptor.LogInterceptor;

@Configuration
public class AuthConfig implements WebMvcConfigurer {
	@Autowired
	AuthInterceptor auth;
	
	@Autowired
	LogInterceptor login;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(auth).addPathPatterns("/admin/**", "/account/**", "/order/**");
		registry.addInterceptor(login).addPathPatterns("/admin/**", "/account/**", "/order/**");
	}
}
