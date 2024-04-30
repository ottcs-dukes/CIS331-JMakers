package com.mycompany.testfx;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;

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
    
    // Create Faculty Button Reference
    static void create(ArrayList<Faculty> faculty) {
    	// Create a window
    	// On button click, append new Faculty() to faculty
    	Stage stage = new Stage();
        
        stage.setTitle("Create Faculty");

        // Set Labels and texts 
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
        
        // Add and organize the labels and texts
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
        
        // Define action when the add faculty button is clicked
        btnAdd.setOnAction(e -> {
            // Get input values from text fields
            String name = txtName.getText();
            String email = txtEmail.getText();
            String building = txtBuilding.getText();
            int office = Integer.valueOf(txtOffice.getText());
            long phone = Long.valueOf(txtPhone.getText());
            String department = txtDepartment.getText();
            String position = txtPosition.getText();
            
            // Create a new Faculty object with input values
            Faculty fac = new Faculty(name, email, building, office, phone, department, position);
            // Add the new faculty object ot the faculty list
            faculty.add(fac);
            stage.close();
            
            
        });
        
        Scene scene = new Scene(grid, 300, 300);
        stage.setScene(scene);
        stage.show();
        
        
    }
    
    static void edit(ArrayList<Faculty> faculties) {
    	// Create a window with data fields filled
    	// On button click, iterate through each field and set each
    	Stage stage = new Stage();
        
        var facultys = new Object() {Faculty facu = faculties.get(0);}; // Define a variable to hold the seleceted faculty
        ComboBox<Faculty> targeter = new ComboBox<Faculty>();
        
        for (Faculty f: faculties) {
            targeter.getItems().add(f); // Populate the dropdown menu with available faculty
        }
        
        stage.setTitle("Edit Faculty");
        
        

        // Labels and Texts
        Label lblName = new Label("Full Name:");
            TextField txtName = new TextField(facultys.facu.getName());
        Label lblEmail = new Label("Email:");
            TextField txtEmail = new TextField(facultys.facu.getEmail());
        Label lblBuilding = new Label("Building Name:");
            TextField txtBuilding = new TextField(facultys.facu.getBuilding());
        Label lblOffice = new Label("Office Number:");
            TextField txtOffice = new TextField(facultys.facu.getOffice() + "");
        Label lblPhone = new Label("Phone Number:");
            TextField txtPhone = new TextField(facultys.facu.getPhone() + "");
        Label lblDepartment = new Label("Department:");
            TextField txtDepartment = new TextField(facultys.facu.getDepartment());
        Label lblPosition = new Label("Position:");
            TextField txtPosition = new TextField(facultys.facu.getPosition());
        Label lblDropdown = new Label("Pick Faculty: ");
        Button btnAdd = new Button("Submit Edit");
        
        // Define action when a faculty is selected from the dropdown
        targeter.setOnAction (f -> {
            // Fill th text fields with selefted facultys data
            facultys.facu = targeter.getSelectionModel().getSelectedItem();
            txtName.setText(facultys.facu.getName());
            txtEmail.setText(facultys.facu.getEmail());
            txtBuilding.setText(facultys.facu.getBuilding());
            txtOffice.setText(String.valueOf(facultys.facu.getOffice()));
            txtPhone.setText(String.valueOf(facultys.facu.getPhone()));
            txtDepartment.setText(facultys.facu.getDepartment());
            txtPosition.setText(facultys.facu.getPosition());
             
        });
            
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
        grid.add(targeter, 1, 7);
        grid.add(lblDropdown, 0, 7);
        grid.add(btnAdd, 0, 8);
        
        grid.setAlignment(Pos.CENTER);
        
        // Define action when the submit edit button is clicked
        btnAdd.setOnAction(e -> {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String building = txtBuilding.getText();
            int office = Integer.valueOf(txtOffice.getText());
            int phone = Integer.valueOf(txtPhone.getText());
            String department = txtDepartment.getText();
            String position = txtPosition.getText();
            
            // Edit faculty data with input values
            facultys.facu.editFaculty(name, email, building, office, phone, department, position);
            stage.close();
            
            
        });
        
        Scene scene = new Scene(grid, 400, 400);
        stage.setScene(scene);
        stage.show();
            
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
    // Allows us update the values in faculty
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
    public String getBuilding(){
        return this.buildingName;
    }
    public int getOffice(){
        return this.officeNumber;
    }
    public String getDepartment(){
        return this.department;
    }
    public String getPosition(){
        return this.position;
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

    public String toString() {
        return this.name;
    }
}


