package com.ardentaxeldev.hrmngt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ardentaxeldev.hrmngt.controllers.EmployeeDAO;
import com.ardentaxeldev.hrmngt.services.EmployeeService;
import com.ardentaxeldev.hrmngt.views.GUI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

@SpringBootApplication
public class HrmngtApplication extends Application{ //It didn't extend Application before this comment

	// Declare ConfigurableApplicationContext
	private ConfigurableApplicationContext applicationContext;
	
	private EmployeeService employeeService;
	
	public HrmngtApplication() {
		
	}
	// Update
	@Override
	public void init() throws Exception{
		this.applicationContext = SpringApplication.run(HrmngtApplication.class);
	}
	// Update
	@Override
	public void stop() throws Exception{
		applicationContext.close();
	}
	

	
	
	
	public HrmngtApplication(EmployeeService employeeService) {
		this.employeeService = employeeService;
		System.out.println("CInjection for employee service in HrmngtApplication: employeeService - " + employeeService);
	}
	
	public static void main(String[] args) {
		//SpringApplication.run(HrmngtApplication.class, args);
		// UPDATE
//		System.out.println("Hello World");
//		Application.launch(JfxApplication.class, args);
		launch(args);
		
	}
	
	
	//Messing around and hoping for the best
	@Override
	public void start(Stage primaryStage) throws Exception {
		Platform.runLater(() -> {
			try {
				System.out.println("GUI not instantiated");
	            GUI gui = new GUI();
	            System.out.println("GUI instantiated");
	            gui.init(employeeService);
	            System.out.println("employee service passed to GUI.init()");
	            gui.getStage().show();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
        });
		
		
		
		
	}

	
}
