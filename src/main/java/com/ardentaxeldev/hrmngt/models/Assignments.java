package com.ardentaxeldev.hrmngt.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Project_Assignments")
public class Assignments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Date_Assigned")
	private Date dateAssigned;
	
	@Column(name="Employee_ID")
	private int employeeId;
	
	@Column(name="Project_ID")
	private int projectId;

	public Assignments() {
		
	}

	public Assignments(Date dateAssigned, int employeeId, int projectId) {
		
		this.dateAssigned = dateAssigned;
		this.employeeId = employeeId;
		this.projectId = projectId;
	}

	public Date getDateAssigned() {
		return dateAssigned;
	}

	public void setDateAssigned(Date dateAssigned) {
		this.dateAssigned = dateAssigned;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "Assignments [dateAssigned=" + dateAssigned + ", employeeId=" + employeeId + ", projectId=" + projectId
				+ "]";
	}

	
	
	

}
