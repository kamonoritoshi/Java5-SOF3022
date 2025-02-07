package com.poly.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.model.Product;

@Controller
public class ProductController {
	@GetMapping("/product/form")
	public String form(Model model) {
		Product p = new Product();
		p.setName("iPhone 30");
		p.setPrice(5000.0);
		model.addAttribute("product", p);
		return "product/form";
	}

	@PostMapping("/product/save")
	public String save(@ModelAttribute("product") Product p, Model model) {
		model.addAttribute("savedProduct", p);
		model.addAttribute("items", getItems());
		return "product/form";
	}

	@ModelAttribute("items")
	public List<Product> getItems() {
		return Arrays.asList(new Product("A", 1.0), new Product("B", 12.0));
	}
}
