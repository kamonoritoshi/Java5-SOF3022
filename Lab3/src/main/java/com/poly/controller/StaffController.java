package com.poly.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.model.Staff;

@Controller
public class StaffController {
	@RequestMapping("/staff/detail")
	public String detail(Model model) {
		Staff stf = Staff.builder().id("liemndps40269@gmail.com").fullname("Nguyễn Duy Liêm").level(2).build();
		model.addAttribute("staff", stf);
		return "/staff-detail";
	}

	@RequestMapping("/staff/list")
	public String list(Model model) {
		List<Staff> list = List.of(Staff.builder().id("user1@gmail.com").fullname("User 1").level(0).build(),
				Staff.builder().id("user2@gmail.com").fullname("User 2").level(1).build(),
				Staff.builder().id("user3@gmail.com").fullname("User 3").level(2).build(),
				Staff.builder().id("user4@gmail.com").fullname("User 4").level(3).build(),
				Staff.builder().id("user5@gmail.com").fullname("User 5").level(1).build(),
				Staff.builder().id("user6@gmail.com").fullname("User 6").level(1).build());
		model.addAttribute("list", list);
		return "/list-controls";
	}
}
