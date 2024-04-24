package com.mycompany.testfx;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;

public class Faculty {
    
    private int facultyID;
    private String name;
    private String email;
    private String buildingName;
    private int officeNumber;
    private long phoneNumber;
    private String department;
    private String position;
    private static int prevFacID = 99;
    
    static void create(ArrayList<Faculty> faculty) {
    	// Create a window
    	// On button click, append new Faculty() to faculty
    	Stage stage = new Stage();
        
        Label lblName = new Label("Full Name:");
            TextField txtName = new TextField();
        Label lblEmail = new Label("Email:");
            TextField txtEmail = new TextField();
        Label lblBuilding = new Label("Building Name:");
            TextField txtBuilding = new TextField();
        Label lblOffice = new Label("Office Number:");
            TextField txtOffice = new TextField();
        Label lblPhone = new Label("Phone Number:");
            TextField txtPhone = new TextField();
        Label lblDepartment = new Label("Department:");
            TextField txtDepartment = new TextField();
        Label lblPosition = new Label("Position:");
            TextField txtPosition = new TextField();
        Button btnAdd = new Button("Add Faculty");
        
        GridPane grid = new GridPane();
        
        grid.add(lblName , 0, 0);
        grid.add(txtName, 1, 0);
        grid.add(lblEmail, 0, 1);
        grid.add(txtEmail, 1, 1);
        grid.add(lblBuilding, 0, 2);
        grid.add(txtBuilding, 1, 2);
        grid.add(lblOffice, 0, 3);
        grid.add(txtOffice, 1, 3);
        grid.add(lblPhone, 0, 4);
        grid.add(txtPhone, 1, 4);
        grid.add(lblDepartment, 0, 5);
        grid.add(txtDepartment, 1, 5);
        grid.add(lblPosition, 0, 6);
        grid.add(txtPosition, 1, 6);
        grid.add(btnAdd, 0, 7);
        
        grid.setAlignment(Pos.CENTER);
        
        btnAdd.setOnAction(e -> {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String building = txtBuilding.getText();
            int office = Integer.valueOf(txtOffice.getText());
            int phone = Integer.valueOf(txtPhone.getText());
            String department = txtDepartment.getText();
            String position = txtPosition.getText();
            
            Faculty fac = new Faculty(name, email, building, office, phone, department, position);
            faculty.add(fac);
            stage.close();
            
            
        });
        
        Scene scene = new Scene(grid, 300, 300);
        stage.setScene(scene);
        stage.show();
        
        
    }
    
    static void edit(Faculty faculty) {
    	// Create a window with data fields filled
    	// On button click, iterate through each field and set each
    	System.out.println("Edit Faculty");
    }
    
    public Faculty (String name, String email, String buildingName, 
                        int officeNumber, long phoneNumber,
                        String department, String position) {
    
        this.facultyID = getNewId();
        this.name = name;
        this.email = email;
        this.buildingName = buildingName;
        this.officeNumber = officeNumber;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.position = position;
    
    }
    
    public void editFaculty(String name, String email, String buildingName,
                        int officeNumber, long phoneNumber, String department, String position) {
        
        this.name = name;
        this.email = email;
        this.buildingName = buildingName;
        this.officeNumber = officeNumber;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.position = position;
    
    }
    
    public int getFacultyID(){
        return this.facultyID;
    }

    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }

    public long getPhone(){
        return this.phoneNumber;
    }

    private static int getNewId() {
        int newID = prevFacID++;
        return newID;
     
        }
    
    public boolean equals(Faculty fac) {
        return this.name.equals(fac.getName());
    }

}


