package com.ardentaxeldev.hrmngt.views;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.ardentaxeldev.hrmngt.controllers.EmployeeDAO;
import com.ardentaxeldev.hrmngt.controllers.EmployeeDAOImpl;
import com.ardentaxeldev.hrmngt.models.Employee;
import com.ardentaxeldev.hrmngt.services.EmployeeService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

@Component
public class EmployeeView {
	
	private SplitPane view;
	private HBox entryContainer;
	private TableView tableView;
	
	private DatePicker joinDate;
	private TextField nameField;
	private ComboBox<String> gender;
	private TextField ageField;
	private TextField addressField;
	private DatePicker dob;
	private TextField qualificationField;
	private TextField experienceField;
	private TextField positionField;
	private ComboBox<String> department;
	private TextField salaryField;
	private Button addBtn;
	
	
	private EmployeeService employeeService;
	
	
	
	public EmployeeView(EmployeeService employeeService) {
		this.employeeService = employeeService;
		System.out.println("EmployeeView constructor - employeeService: " + employeeService);
	}
	
	public void init() {
		view = new SplitPane();
		view.setOrientation(javafx.geometry.Orientation.VERTICAL);
		
		entryContainer = new HBox(50);
		

		TableView tableView = new TableView();
        //bottomPane.getChildren().add(new Label("Employee bot"));
		
		 dataEntry();
		 entryContainer.setAlignment(Pos.CENTER);
		
        view.getItems().addAll(entryContainer, tableView);
        view.setDividerPositions(0.5);
	}
	
	public void dataEntry() {
		
		HBox dateBox = new HBox();
		Label joinDateLbl = new Label("Date of joining: ");
		joinDateLbl.setMaxWidth(100);
		joinDateLbl.setPrefWidth(Double.MAX_VALUE);
		joinDate = new DatePicker();
		HBox.setHgrow(joinDate, Priority.ALWAYS);
		dateBox.getChildren().addAll(joinDateLbl, joinDate);
		
		HBox nameBox = new HBox();
		Label nameLbl = new Label("Name: ");
		nameLbl.setMaxWidth(100);
		nameLbl.setPrefWidth(Double.MAX_VALUE);
		nameField = new TextField();
		HBox.setHgrow(nameField, Priority.ALWAYS);
		nameBox.getChildren().addAll(nameLbl, nameField);
		
		HBox genderBox = new HBox();
		Label genderLbl = new Label("Gender: ");
		genderLbl.setMaxWidth(100);
		genderLbl.setPrefWidth(Double.MAX_VALUE);
		ArrayList<String> genders = new ArrayList<>();
		genders.add("Male");
		genders.add("Female");
		genders.add("Error 404");
		ObservableList<String> observableGenders = FXCollections.observableArrayList(genders);
		gender = new ComboBox<String>(observableGenders);
		HBox.setHgrow(gender, Priority.ALWAYS);
		gender.setValue("Male");
		HBox.setHgrow(gender, Priority.ALWAYS);
		genderBox.getChildren().addAll(genderLbl, gender);
		
		HBox ageBox = new HBox();
		Label ageLbl = new Label("Age: ");
		ageLbl.setMaxWidth(100);
		ageLbl.setPrefWidth(Double.MAX_VALUE);
		ageField = new TextField();
		HBox.setHgrow(ageField, Priority.ALWAYS);
		ageBox.getChildren().addAll(ageLbl, ageField);
		
		HBox addressBox = new HBox();
		Label addressLbl = new Label("Address: ");
		addressLbl.setMaxWidth(100);
		addressLbl.setPrefWidth(Double.MAX_VALUE);
		addressField = new TextField();
		HBox.setHgrow(addressField, Priority.ALWAYS);
		addressBox.getChildren().addAll(addressLbl, addressField);
		
		VBox leftBox = new VBox(5);
		leftBox.getChildren().addAll(dateBox,nameBox,genderBox,ageBox,addressBox);
		Insets marginTop = new Insets(10, 0, 0, 0); // top, right, bottom, left
        HBox.setMargin(leftBox, marginTop);
		leftBox.setAlignment(Pos.TOP_LEFT);
		
		HBox dobBox = new HBox();
		Label dobLbl = new Label("D.O.B: ");
		dobLbl.setMaxWidth(100);
		dobLbl.setPrefWidth(Double.MAX_VALUE);
		dob = new DatePicker();
		dobBox.getChildren().addAll(dobLbl, dob);
		
		HBox qualificationBox = new HBox();
		Label qualificationLbl = new Label("Qualification: ");
		qualificationLbl.setMaxWidth(100);
		qualificationLbl.setPrefWidth(Double.MAX_VALUE);
		qualificationField = new TextField();
		qualificationBox.getChildren().addAll(qualificationLbl, qualificationField);
		
		HBox experienceBox = new HBox();
		Label experienceLbl = new Label("Experience: ");
		experienceLbl.setMaxWidth(100);
		experienceLbl.setPrefWidth(Double.MAX_VALUE);
		experienceField = new TextField();
		experienceBox.getChildren().addAll(experienceLbl, experienceField);
		
		HBox positionBox = new HBox();
		Label positionLbl = new Label("Position: ");
		positionLbl.setMaxWidth(100);
		positionLbl.setPrefWidth(Double.MAX_VALUE);
		positionField = new TextField();
		positionBox.getChildren().addAll(positionLbl, positionField);
		
		HBox departmentBox = new HBox();
		Label departmentLbl = new Label("Department: ");
		departmentLbl.setMaxWidth(100);
		departmentLbl.setPrefWidth(Double.MAX_VALUE);
		ArrayList<String> departments = new ArrayList<>();
		departments.add("Option 1");
		departments.add("Option 2");
		departments.add("Option 3");
		ObservableList<String> observableDepartments = FXCollections.observableArrayList(departments);
		department = new ComboBox<String>(observableDepartments);
		HBox.setHgrow(department, Priority.ALWAYS);
		department.setValue("Option 1");
		departmentBox.getChildren().addAll(departmentLbl, department);
		
		HBox salaryBox = new HBox();
		Label salaryLbl = new Label("Monthly Salary: ");
		salaryLbl.setMaxWidth(100);
		salaryLbl.setPrefWidth(Double.MAX_VALUE);
		salaryField = new TextField();
		salaryBox.getChildren().addAll(salaryLbl, salaryField);
		
		addBtn = new Button("Add");
		addBtn.setPrefWidth(100);
		addBtn.setOnAction(e -> {
//			Date date = new Date(joinDate.getValue().toEpochDay());
//			String name = nameField.getText();
//			String genderData= gender.getValue();
//			int age = Integer.parseInt(ageField.getText());
//			String address = addressField.getText();
//			Date dateofBirth = new Date(dob.getValue().toEpochDay());
//			String qualificationData = qualificationField.getText();
//			String experienceData = experienceField.getText();
//			String positionData = positionField.getText();
//			String departmentData = department.getValue();
//			int salaryData = Integer.parseInt(salaryField.getText());
			System.out.println("Add button clicked - employeeService: " + employeeService);
			Date date = new Date();
			String name = "QWERTY";
			String genderData= "QWERTY";
			int age = Integer.parseInt("19");
			String address = "QWERTY";
			Date dateofBirth = new Date();
			String qualificationData = "QWERTY";
			String experienceData = "QWERTY";
			String positionData = "QWERTY";
			String departmentData = "QWERTY";
			int salaryData = Integer.parseInt("120");
			Employee employeeData = new Employee(date, name, genderData, age, address, dateofBirth, qualificationData, experienceData, positionData, departmentData, salaryData);
			System.out.println(employeeData.toString());
			employeeService.save(employeeData);
			//save();
		});
		HBox.setHgrow(addBtn, Priority.ALWAYS);
		
		VBox rightBox = new VBox(5);
		rightBox.getChildren().addAll(dobBox,qualificationBox,experienceBox,positionBox,departmentBox,salaryBox,addBtn);
        HBox.setMargin(rightBox, marginTop);
		rightBox.setAlignment(Pos.TOP_LEFT);
		
		entryContainer.getChildren().addAll(leftBox,rightBox);
		
		
	}
	


	public void dataView() {
		TableView<Employee> table = new TableView<>();
		
	}
	
	public SplitPane getView() {
		return this.view;
	}

}
