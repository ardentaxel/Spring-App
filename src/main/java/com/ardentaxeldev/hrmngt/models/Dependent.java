package com.ardentaxeldev.hrmngt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DepartmentsProject_Assignments")
public class Dependent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="EmployeeID")
	private String employeeID;
	
	@Column(name="Dependent_Name")
	private String dependentName;
	
	@Column(name="Dependent_Age")
	private String dependentAge;
	
	@Column(name="relation")
	private String relation;

	public Dependent() {
		
	}

	public Dependent(String employeeID, String dependentName, String dependentAge, String relation) {
		this.employeeID = employeeID;
		this.dependentName = dependentName;
		this.dependentAge = dependentAge;
		this.relation = relation;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}

	public String getDependentAge() {
		return dependentAge;
	}

	public void setDependentAge(String dependentAge) {
		this.dependentAge = dependentAge;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Override
	public String toString() {
		return "Dependent [employeeID=" + employeeID + ", dependentName=" + dependentName + ", dependentAge="
				+ dependentAge + ", relation=" + relation + "]";
	}
	
	
	
	
}
