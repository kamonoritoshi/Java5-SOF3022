package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhepTinhController {
	@GetMapping("/pheptinh/form")
	public String doGetForm() {
		return "form2";
	}
}
