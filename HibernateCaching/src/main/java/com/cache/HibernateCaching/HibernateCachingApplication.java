package com.cache.HibernateCaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cache.controller.EmployeeController;
import com.cache.model.Department;
import com.cache.model.Employee;
import com.cache.repository.EmployeeRepository;
import com.cache.service.impl.EmployeeServiceImpl;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackageClasses = { EmployeeRepository.class })
@EntityScan(basePackageClasses = { Employee.class, Department.class })
@ComponentScan(basePackageClasses = { EmployeeController.class, EmployeeServiceImpl.class })
public class HibernateCachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateCachingApplication.class, args);
	}
}
