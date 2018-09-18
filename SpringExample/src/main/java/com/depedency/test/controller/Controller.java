package com.depedency.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.depedency.test.entity.Department;

@RestController
public class Controller {
	@Autowired
	public Controller(Department department) {
		this.department = department;
	}

	private Department department;

	@GetMapping("/test")
	public void test() {
		department.show();
	}
}
