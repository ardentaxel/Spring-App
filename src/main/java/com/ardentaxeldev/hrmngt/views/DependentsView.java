package com.ardentaxeldev.hrmngt.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class DependentsView {

	private SplitPane view;
	private HBox entryContainer;
	private TableView tableView;
	
	private TextField employeeIdField;
	private TextField dependentNameField;
	private TextField ageField;
	private TextField relationField;
	private Button addBtn;
	
	public DependentsView() {
		view = new SplitPane();
		view.setOrientation(javafx.geometry.Orientation.VERTICAL);
		
		entryContainer = new HBox(50);
		

		TableView tableView = new TableView();
		
		dataEntry();
		entryContainer.setAlignment(Pos.CENTER);
		
        view.getItems().addAll(entryContainer, tableView);
        view.setDividerPositions(0.5);
	}

	private void dataEntry() {
		
		VBox container = new VBox(5);

		// To-do restrict this further
		HBox employeeBox = new HBox();
		Label employeeLbl = new Label("Employee ID: ");
		employeeLbl.setMaxWidth(100);
		employeeLbl.setPrefWidth(Double.MAX_VALUE);
		employeeIdField = new TextField();
		HBox.setHgrow(employeeIdField, Priority.ALWAYS);
		employeeBox.getChildren().addAll(employeeLbl, employeeIdField);
		
		HBox dependentNameBox = new HBox();
		Label dependentNameLbl = new Label("Dependent Name: ");
		dependentNameLbl.setMaxWidth(100);
		dependentNameLbl.setPrefWidth(Double.MAX_VALUE);
		dependentNameField = new TextField();
		HBox.setHgrow(dependentNameField, Priority.ALWAYS);
		dependentNameBox.getChildren().addAll(dependentNameLbl, dependentNameField);
		
		HBox ageBox = new HBox();
		Label ageLbl = new Label("Age: ");
		ageLbl.setMaxWidth(100);
		ageLbl.setPrefWidth(Double.MAX_VALUE);
		ageField = new TextField();
		HBox.setHgrow(ageField, Priority.ALWAYS);
		ageBox.getChildren().addAll(ageLbl, ageField);
		
		HBox relationBox = new HBox();
		Label relationLbl = new Label("Relation: ");
		relationLbl.setMaxWidth(100);
		relationLbl.setPrefWidth(Double.MAX_VALUE);
		relationField = new TextField();
		HBox.setHgrow(relationField, Priority.ALWAYS);
		relationBox.getChildren().addAll(relationLbl, relationField);
		
		HBox buttonBox = new HBox();
		Label btnLbl = new Label(" ");
		btnLbl.setMaxWidth(100);
		btnLbl.setPrefWidth(Double.MAX_VALUE);
		addBtn = new Button("Add");
		addBtn.setPrefWidth(100);
		HBox.setHgrow(addBtn, Priority.ALWAYS);
		buttonBox.getChildren().addAll(btnLbl, addBtn);
		
		container.getChildren().addAll(employeeBox,dependentNameBox,ageBox,relationBox,buttonBox);
		container.setAlignment(Pos.TOP_CENTER);
		Insets marginTop = new Insets(50, 0, 0, 0); // top, right, bottom, left
        HBox.setMargin(container, marginTop);
		entryContainer.getChildren().add(container);
		
	}

	public SplitPane getView() {
		return view;
	}
}
