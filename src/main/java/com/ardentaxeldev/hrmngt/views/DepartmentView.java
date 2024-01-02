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

public class DepartmentView {

	private SplitPane view;
	private HBox entryContainer;
	private TableView tableView;
	
	private TextField nameField;
	private TextField locationField;
	private Button addBtn;
	

	public DepartmentView() {
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

		HBox nameBox = new HBox();
		Label nameLbl = new Label("Name: ");
		nameLbl.setMaxWidth(100);
		nameLbl.setPrefWidth(Double.MAX_VALUE);
		nameField = new TextField();
		nameBox.getChildren().addAll(nameLbl, nameField);
		
		HBox locationBox = new HBox();
		Label locationLbl = new Label("Location: ");
		locationLbl.setMaxWidth(100);
		locationLbl.setPrefWidth(Double.MAX_VALUE);
		locationField = new TextField();
		locationBox.getChildren().addAll(locationLbl, locationField);
		
		HBox buttonBox = new HBox();
		Label btnLbl = new Label(" ");
		btnLbl.setMaxWidth(100);
		btnLbl.setPrefWidth(Double.MAX_VALUE);
		addBtn = new Button("Add");
		addBtn.setPrefWidth(100);
		HBox.setHgrow(addBtn, Priority.ALWAYS);
		buttonBox.getChildren().addAll(btnLbl, addBtn);
		
		container.getChildren().addAll(nameBox,locationBox,buttonBox);
		container.setAlignment(Pos.TOP_CENTER);
		Insets marginTop = new Insets(50, 0, 0, 0); // top, right, bottom, left
        HBox.setMargin(container, marginTop);
		entryContainer.getChildren().add(container);
		
	}



	public SplitPane getView() {
		return view;
	}

}
