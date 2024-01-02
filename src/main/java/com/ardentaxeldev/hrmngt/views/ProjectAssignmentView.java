package com.ardentaxeldev.hrmngt.views;

import java.util.ArrayList;

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
import javafx.scene.layout.VBox;

public class ProjectAssignmentView {
	
	private SplitPane view;
	private HBox entryContainer;
	private TableView tableView;
	
	private DatePicker date;
	private TextField employeeIdField;
	private ComboBox<String> projectIDCombo;
	
	private Button submitBtn;
	
	public ProjectAssignmentView() {
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
		
		HBox dateBox = new HBox();
		Label dateLbl = new Label("Date: ");
		dateLbl.setMaxWidth(100);
		dateLbl.setPrefWidth(Double.MAX_VALUE);
		date = new DatePicker();
		HBox.setHgrow(date, Priority.ALWAYS);
		dateBox.getChildren().addAll(dateLbl, date);
		
		
		// To-do restrict this further
		HBox employeeBox = new HBox();
		Label employeeLbl = new Label("Employee ID: ");
		employeeLbl.setMaxWidth(100);
		employeeLbl.setPrefWidth(Double.MAX_VALUE);
		employeeIdField = new TextField();
		HBox.setHgrow(employeeIdField, Priority.ALWAYS);
		employeeBox.getChildren().addAll(employeeLbl, employeeIdField);
		
		HBox projectIdBox = new HBox(50);
		Label projectIdLbl = new Label("Project ID: ");
		projectIdLbl.setMaxWidth(100);
		projectIdLbl.setPrefWidth(Double.MAX_VALUE);
		ArrayList<String> projectIds = new ArrayList<>();
		projectIds.add("#1");
		projectIds.add("#2");
		projectIds.add("#3");
		ObservableList<String> observableDepartments = FXCollections.observableArrayList(projectIds);
		projectIDCombo = new ComboBox<String>(observableDepartments);
		HBox.setHgrow(projectIDCombo, Priority.ALWAYS);
		projectIDCombo.setValue("Select Project ID");
		projectIdBox.getChildren().addAll(projectIdLbl, projectIDCombo);
		
		HBox submitButtonBox = new HBox();
		Label submitBtnLbl = new Label(" ");
		submitBtnLbl.setMaxWidth(100);
		submitBtnLbl.setPrefWidth(Double.MAX_VALUE);
		submitBtn = new Button("Submit");
		submitBtn.setPrefWidth(100);
		HBox.setHgrow(submitBtn, Priority.ALWAYS);
		submitButtonBox.getChildren().addAll(submitBtnLbl, submitBtn);
		
		container.getChildren().addAll(dateBox,employeeBox,projectIdBox,submitButtonBox);
		container.setAlignment(Pos.TOP_CENTER);
		Insets marginTop = new Insets(50, 0, 0, 0); // top, right, bottom, left
        HBox.setMargin(container, marginTop);
		entryContainer.getChildren().add(container);
		
	}

	public SplitPane getView() {
		return view;
	}
}
