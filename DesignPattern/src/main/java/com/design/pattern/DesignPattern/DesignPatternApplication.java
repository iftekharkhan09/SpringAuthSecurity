package com.design.pattern.DesignPattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.design.pattern.singleton.SingletonClass;

@SpringBootApplication
@ComponentScan(basePackageClasses = { SingletonClass.class })
public class DesignPatternApplication {
	public static void main(String[] args) {
		SpringApplication.run(DesignPatternApplication.class, args);
	}
}
