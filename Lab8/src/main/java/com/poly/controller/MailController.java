package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.service.MailService;

@Controller
public class MailController {
	@Autowired
	MailService mailService;

	@GetMapping("/")
	public String showForm(Model model) {
		model.addAttribute("mail", new MailService.Mail());
		return "mailForm";
	}
	
	@PostMapping("/send")
	public String sendMail(@ModelAttribute MailService.Mail mail, @RequestParam("action") String action) {
		if ("direct".equals(action)) {
			mailService.send(mail);
		} else if ("queue".equals(action)) {
			mailService.push(mail);
		}
		return "result";
	}
}
