package com.poly.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.AccountDAO;
import com.poly.entity.Account;
import com.poly.service.SessionService;

@Controller
public class AuthController {
	@Autowired
	AccountDAO accountDAO;
	
	@Autowired
	SessionService session;
	
	@GetMapping("/auth/login")
	public String loginForm(Model model) {
		return "/login";
	}
	
	@PostMapping("/auth/login")
	public String logiProcess(Model model, @RequestParam("username") String username, @RequestParam("password") String password) {
		Optional<Account> userOpt = accountDAO.findById(username);
		if (userOpt.isPresent()) {
			Account user = userOpt.get();
			if (user == null) {
				model.addAttribute("message", "Invalid email!");
			} else if (!user.getPassword().equals(password)) {
				model.addAttribute("message", "Invalid password!");
			} else {
				session.set("user", user);
				model.addAttribute("message", "Login successfully");
				String securityUri = (String) session.get("securityUri");
					if(securityUri != null) {
					return "redirect:" + securityUri;
				}
			}
		}
		return "/login";
	}
	
	@GetMapping("/admin/dashboard")
	public String admin() {
		return "admin/dashboard";
	}

}
