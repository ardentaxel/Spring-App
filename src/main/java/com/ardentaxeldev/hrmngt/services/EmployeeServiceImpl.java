package com.ardentaxeldev.hrmngt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardentaxeldev.hrmngt.controllers.EmployeeDAO;
import com.ardentaxeldev.hrmngt.models.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeD) {
		employeeDAO = employeeD;
	}

	@Override
	public void save(Employee employee) {
		employeeDAO.save(employee);
	}
	
}
