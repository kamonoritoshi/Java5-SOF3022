package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.service.CookieService;
import com.poly.service.ParamService;
import com.poly.service.SessionService;

@Controller
public class AccountController {
	@Autowired
	CookieService cookieService;
	@Autowired
	ParamService paramService;
	@Autowired
	SessionService sessionService;
	
	@GetMapping("/account/login")
	public String login1() {
		return "/account/login";
	}
	
	@PostMapping("/account/login")
	public String login2() {
		String un = paramService.getString("username", "");
		String pw = paramService.getString("password", "");
		boolean rm = paramService.getBoolean("remember", false);
		if (un.equals("poly") && pw.equals("123")) {
			sessionService.set("username", un);
		} else {
			sessionService.remove("username");
		}
		if (rm) {
			cookieService.add("user", un, 10);
		} else {
			cookieService.remove("user");
		}
		return "/account/login";
	}
}
