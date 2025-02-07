package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SanPhamController {
	@GetMapping("/sanpham")
	public String doGetListSanPham() {
		return "listsanpham";
	}

	@GetMapping("/sanpham/{tensanpham}")
	public String doGetTenSanPham(@PathVariable("tensanpham") String tenSP, Model model) {
		model.addAttribute("sanpham", tenSP);
		return "listsanpham";
	}
}
