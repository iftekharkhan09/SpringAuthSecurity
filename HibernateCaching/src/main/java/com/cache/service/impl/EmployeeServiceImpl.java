package com.cache.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cache.model.Department;
import com.cache.model.Employee;
import com.cache.repository.EmployeeRepository;
import com.cache.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void addEmployee() {
		Department department = new Department("CSE Dept");
		Employee employee = new Employee("Iftekhar", department);
		employeeRepository.save(employee);
	}

	@Override
	public void showEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		Iterator<Employee> iterator = employees.iterator();
		while (iterator.hasNext()) {
			Employee e = iterator.next();
			System.out.println("Name :" + e.getName() + "Department :" + e.getDepartment().getName() + "version "
					+ e.getVersion());
		}
	}

}
