package com.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cache.model.Employee;
import com.cache.repository.EmployeeRepository;
import com.cache.service.EmployeeService;
import com.cache.service.impl.DataServiceImpl;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DataServiceImpl dataServiceImpl;

	@RequestMapping(value = "/showAll")
	public void showEmployee() {
		employeeService.showEmployee();
		// dataServiceImpl.firstLevelCache();
	}

	@PostMapping(value = "/addEmployee")
	public void addEmployee() {
		// System.out.println("Inside");
		// Employee e = new Employee("baby");
		// employeeRepository.save(e);
		Employee e = new Employee("Iftekhar Khan");
		dataServiceImpl.add(e);
	}

	@PutMapping(value = "/updateEmployee")
	public void updateEmployee() {
		dataServiceImpl.updateEmployee();
	}

	@GetMapping(value = "/getById")
	public void getEmployee() {
		dataServiceImpl.firstLevelCache();
	}
	
	@GetMapping(value = "/savetest")
	public void saveorUpdayeEmployee() {
		dataServiceImpl.saveUpdate();
	}
}
