package com.ardentaxeldev.hrmngt.controllers;

import java.util.List;

import com.ardentaxeldev.hrmngt.models.Employee;

public interface EmployeeDAO {
	
	void nullTest();
	
	void save(Employee employee);
	
	Employee findById(String employeeID);
	
	List<Employee> findAll();
	
	void update(Employee employee);
	
	void delete(String employeeID);
	
	int deleteAll();
}
