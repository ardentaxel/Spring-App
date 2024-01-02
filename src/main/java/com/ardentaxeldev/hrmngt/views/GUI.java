package com.ardentaxeldev.hrmngt.views;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.ardentaxeldev.hrmngt.controllers.EmployeeDAO;
import com.ardentaxeldev.hrmngt.controllers.EmployeeDAOImpl;
import com.ardentaxeldev.hrmngt.services.EmployeeService;

import jakarta.persistence.EntityManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class GUI {
	private Stage stage = new Stage();
	
	private HBox mainLayout;
    private VBox contentArea;
    private VBox container;
    private HBox header;
    private HBox body;
    private ArrayList<Button> buttons;
    private int id = 1;
    
    private EmployeeView emplView;
    private ProjectView projView;
    private ProjectAssignmentView projAssignView;
    private DepartmentView deptView;
    private DependentsView depenView;
    
    
    private EmployeeService employeeService;
	
	

	public GUI() {
		
	}



	public void init(EmployeeService employeeService) {
		
		this.employeeService = employeeService;
	   
//	    projAssignView = new ProjectAssignmentView();
//	    deptView = new DepartmentView();
//	    depenView = new DependentsView();
		
		container = new VBox();
		
		header = new HBox();
		HBox.setHgrow(header, Priority.ALWAYS);
		header.setPrefHeight(50);
		header.setMaxWidth(Double.MAX_VALUE);
		header.setBackground(new Background(new BackgroundFill(Color.web("#336699"), CornerRadii.EMPTY, Insets.EMPTY)));
		Text headerText = new Text("Human Resource Management");
		headerText.setFill(Color.WHITE);
		header.setAlignment(Pos.CENTER);
		headerText.setFont(new Font(20));
		
		body = new HBox();
		mainLayout = new HBox();
        contentArea = new VBox();
        
     // Create buttons for side navigation
        buttons = new ArrayList<Button>(0);
        Button addEmployeeBtn = createNavigationButton("Add Employees");
        Button ProjectsBtn = createNavigationButton("Projects");
        Button AssignProjectBtn = createNavigationButton("Assign Projects");
        Button DepartmentsBtn = createNavigationButton("Departments");
        Button DependentsBtn = createNavigationButton("Dependents");
        buttons.add(addEmployeeBtn);
		buttons.add(ProjectsBtn);
		buttons.add(AssignProjectBtn);
		buttons.add(DepartmentsBtn);
		buttons.add(DependentsBtn);
        
     // Create the side navigation
        VBox sideNavigation = new VBox(addEmployeeBtn, ProjectsBtn, AssignProjectBtn, DepartmentsBtn, DependentsBtn);
        sideNavigation.setBackground(new Background(new BackgroundFill(Color.web("#012e34"), CornerRadii.EMPTY, Insets.EMPTY)));
        
        VBox.setVgrow(mainLayout, Priority.ALWAYS);
        
     // Set the side navigation as the left component of the main layout
        mainLayout.getChildren().addAll(sideNavigation,contentArea);
        
        container.getChildren().addAll(header,mainLayout);
        VBox.setVgrow(body, Priority.ALWAYS);
        header.getChildren().add(headerText);
 
        
        Scene scene = new Scene(container, 600, 400);
        stage.setScene(scene);

        // Set the stage title and show it
        stage.setTitle("HR Management");
		
	}
	
	

	private Button createNavigationButton(String buttonText) {
		Button button = new Button(buttonText);
		button.setId(Integer.toString(id));
		button.setPrefHeight(40);
		button.setPrefWidth(120);
		button.setStyle("-fx-background-color: #444e5a; -fx-text-fill: white; -fx-background-radius: 0; -fx-border-width: 0 0 2 0; -fx-border-color: white;");
		id++;
		
		button.setOnAction(e -> {
        	for(Button btn : buttons) {
        		// Revert styling for all buttons
        		btn.setStyle("-fx-background-color: #444e5a; -fx-text-fill: white; -fx-background-radius: 0; -fx-border-width: 0 0 2 0; -fx-border-color: white;");
        	}
        	// Apply new styling on individual button
        	button.setStyle("-fx-background-color: white;");
        	int btnId = Integer.parseInt(button.getId());
        	if(btnId == 1) {
        		System.out.println("Employees button clicked: emplView -" + emplView);
        		int count = 1;
        		if (this.emplView == null) {
                    this.emplView = new EmployeeView(this.employeeService);
                    this.emplView.init(); // Call init only if the instance is created for the first time
                }
        		setContent(this.emplView.getView());
        	}else if(btnId == 2) {
        		this.projView = new ProjectView();
        		setContent(this.projView.getView());
        	}else if(btnId == 3) {
        		this.projAssignView = new ProjectAssignmentView();
        		setContent(this.projAssignView.getView());
        	}else if(btnId == 4) {
        		this.deptView = new DepartmentView();
        		setContent(this.deptView.getView());
        	}else if(btnId == 5) {
        		this.depenView = new DependentsView();
        		setContent(this.depenView.getView());
        	}
        	System.out.println(button.getId());
        });
        
        return button;
	}

	 //GUI.java
	 private void setContent(SplitPane splitView) {
	        // Update the content area with the selected content
	        contentArea.getChildren().clear();
	        VBox.setVgrow(splitView, Priority.ALWAYS);
	        HBox.setHgrow(contentArea, Priority.ALWAYS);
	        contentArea.getChildren().add(splitView);
	   }

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
