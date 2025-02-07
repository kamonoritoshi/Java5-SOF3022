package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.poly.model.Staff;

import jakarta.validation.Valid;

@Controller
public class StaffController {
	@RequestMapping("/staff/create/form")
	public String createForm(Model model, @ModelAttribute("staff") Staff stf) {
		model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
		return "/staff-create";
	}
	
	@RequestMapping("/staff/create/save")
	public String createSave(Model model,  @RequestPart("photo_file") MultipartFile photoFile, @Valid @ModelAttribute("staff") Staff staff, Errors error) {
		if(!photoFile.isEmpty()) {
			staff.setPhoto(photoFile.getName());
		}
		if(error.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
		} else {
			model.addAttribute("message", "Dữ liệu đã nhập đúng!");
		}
		return "/staff-create";
	}
}
