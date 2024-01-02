package com.ardentaxeldev.hrmngt.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ProjectView {

	private SplitPane view;
	private HBox entryContainer;
	private TableView tableView;
	
	private TextField nameField;
	private TextField descriptionField;
	private DatePicker startDate;
	private DatePicker endDate;
	
	private Button addBtn;
	

	public ProjectView() {
		view = new SplitPane();
		view.setOrientation(javafx.geometry.Orientation.VERTICAL);
		
		entryContainer = new HBox();
		

		TableView tableView = new TableView();
		
		 dataEntry();
		 entryContainer.setAlignment(Pos.CENTER);
		
        view.getItems().addAll(entryContainer, tableView);
        view.setDividerPositions(0.5);
	}
	
	private void dataEntry() {
		
		VBox container = new VBox(5);
	
		HBox nameBox = new HBox();
		Label nameLbl = new Label("Name: ");
		nameLbl.setMaxWidth(100);
		nameLbl.setPrefWidth(Double.MAX_VALUE);
		nameField = new TextField();
		HBox.setHgrow(nameField, Priority.ALWAYS);
		nameBox.getChildren().addAll(nameLbl, nameField);
		
		HBox descriptionBox = new HBox();
		Label descriptionLbl = new Label("Description: ");
		descriptionLbl.setMaxWidth(100);
		descriptionLbl.setPrefWidth(Double.MAX_VALUE);
		descriptionField = new TextField();
		HBox.setHgrow(descriptionField, Priority.ALWAYS);
		descriptionBox.getChildren().addAll(descriptionLbl, descriptionField);
		
		
		HBox startDateBox = new HBox();
		Label startDateLbl = new Label("Start Date: ");
		startDateLbl.setMaxWidth(100);
		startDateLbl.setPrefWidth(Double.MAX_VALUE);
		startDate = new DatePicker();
		HBox.setHgrow(startDate, Priority.ALWAYS);
		startDateBox.getChildren().addAll(startDateLbl, startDate);
		
		HBox endDateBox = new HBox();
		Label endDateLbl = new Label("End Date: ");
		endDateLbl.setMaxWidth(100);
		endDateLbl.setPrefWidth(Double.MAX_VALUE);
		endDate = new DatePicker();
		HBox.setHgrow(endDate, Priority.ALWAYS);
		endDateBox.getChildren().addAll(endDateLbl, endDate);
		
		
		HBox buttonBox = new HBox();
		Label btnLbl = new Label(" ");
		btnLbl.setMaxWidth(100);
		btnLbl.setPrefWidth(Double.MAX_VALUE);
		addBtn = new Button("Add");
		addBtn.setPrefWidth(100);
		HBox.setHgrow(addBtn, Priority.ALWAYS);
		buttonBox.getChildren().addAll(btnLbl, addBtn);
		
		container.getChildren().addAll(nameBox,descriptionBox,startDateBox,endDateBox,buttonBox);
		container.setAlignment(Pos.TOP_CENTER);
		Insets marginTop = new Insets(50, 0, 0, 0); // top, right, bottom, left
        HBox.setMargin(container, marginTop);
		entryContainer.getChildren().add(container);
		
		
		
	}

	public SplitPane getView() {
		return this.view;
	}

}
