package com.myproject.throttle.ThrottlerApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.myproject.throttle.controller.MyController;

@SpringBootApplication
@ComponentScan(basePackageClasses = { MyController.class, RateLimitingInterceptor.class })
public class ThrottlerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThrottlerAppApplication.class, args);
	}
}
