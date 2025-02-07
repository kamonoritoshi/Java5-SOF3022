package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
	@GetMapping("/pheptinh")
	public String doGetIdSanPham(@RequestParam("a") int a, @RequestParam("b") int b, Model model) {
		int kq = a + b;
		model.addAttribute("ketqua", kq);
		return "ketqua";
	}
}
