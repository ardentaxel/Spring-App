package com.ardentaxeldev.hrmngt.models;

import java.util.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Join_Date")
	private Date joinDate;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="Age")
	private int age;
	
	@Column(name="Address")
	private String addres;
	
	@Column(name="Date_Of_Birth")
	private Date dateOfBirth;
	
	@Column(name="Qualification")
	private String qualification;
	
	@Column(name="Experience")
	private String experience;
	
	@Column(name="Position")
	private String position;
	
	@Column(name="Department")
	private String department;
	
	@Column(name="Monthly_Salary")
	private int monthlySalary;
	
	
	public Employee() {
		
	}

	public Employee(Date joinDate, String name, String gender, int age, String addres, Date dateOfBirth,
			String qualification, String experience, String position, String department, int monthlySalary) {
		
		this.joinDate = joinDate;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.addres = addres;
		this.dateOfBirth = dateOfBirth;
		this.qualification = qualification;
		this.experience = experience;
		this.position = position;
		this.department = department;
		this.monthlySalary = monthlySalary;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(int monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", joinDate=" + joinDate + ", name=" + name + ", gender=" + gender + ", age="
				+ age + ", addres=" + addres + ", dateOfBirth=" + dateOfBirth + ", qualification=" + qualification
				+ ", experience=" + experience + ", position=" + position + ", department=" + department
				+ ", monthlySalary=" + monthlySalary + "]";
	}
	
	
	
	
	
}
