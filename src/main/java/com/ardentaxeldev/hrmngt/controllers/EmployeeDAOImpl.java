package com.ardentaxeldev.hrmngt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ardentaxeldev.hrmngt.models.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	private EntityManager entityManager;
	
	
	// Constructor injection
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		entityManager.persist(employee);
		
	}

	@Override
	public Employee findById(String employeeID) {
		return entityManager.find(Employee.class,employeeID);
	}

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employees", Employee.class);
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Employee employee) {
		entityManager.merge(employee);
		
	}

	@Override
	@Transactional
	public void delete(String employeeID) {
		Employee theEmployee = entityManager.find(Employee.class,employeeID);
        entityManager.remove(theEmployee);
		
	}

	@Override
	@Transactional
	public int deleteAll() {
		int numRowsDeleted = entityManager.createQuery("DELETE FROM Employees").executeUpdate();
        return numRowsDeleted;
	}

	@Override
	public void nullTest() {
		System.out.println("NOT NULL");
		
	}

}
