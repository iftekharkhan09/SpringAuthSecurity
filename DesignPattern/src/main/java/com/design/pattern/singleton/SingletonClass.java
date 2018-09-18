package com.design.pattern.singleton;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component("Singleton")
public class SingletonClass {
	
	@PostConstruct
	public void startUp() {
		System.out.println("Application has started Up!!");
	}
}
