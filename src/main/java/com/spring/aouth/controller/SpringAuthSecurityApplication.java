package com.spring.aouth.controller;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableAutoConfiguration
@EnableOAuth2Sso
public class SpringAuthSecurityApplication extends WebSecurityConfigurerAdapter { 
	
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .antMatcher("/**")
	      .authorizeRequests()
	        .antMatchers("/", "/login**", "/webjars/**")
	        .permitAll()
	      .anyRequest()
	        .authenticated();
	  }

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAuthSecurityApplication.class, args);
	}
}