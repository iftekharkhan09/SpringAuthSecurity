package com.myproject.throttle.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@GetMapping("/test")
	public void test() {
		System.out.println("I was Called!");
	}
}
