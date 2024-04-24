package com.mycompany.testfx;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Student {
    
    private int studentID;
    private String fullName;;
    private String Address;
    private String email;
    private double gpa;
    private int ssn; // did not include emergency contact for now
    private static int prevStuID = 199;
    private ArrayList<Course> courses = new ArrayList<>();
    
    static void create(ArrayList<Student> students) {
    	// Create a window
        Stage stage = new Stage();
        
        Label lblName = new Label("Full Name:");
        TextField txtName = new TextField();
        Label lblAddress = new Label("Address:");
        TextField txtAddress = new TextField();
        Label lblEmail = new Label("Email:");
        TextField txtEmail = new TextField();
        Label lblGpa = new Label("GPA:");
        TextField txtGpa = new TextField();
        Label lblSsn = new Label("SSN:");
        TextField txtSsn = new TextField();
        Button btnAdd = new Button("Add Student");
                
        GridPane grid = new GridPane();
        grid.add(lblName, 0, 0);
        grid.add(txtName, 1, 0);
        grid.add(lblAddress, 0, 1);
        grid.add(txtAddress, 1, 1);
        grid.add(lblEmail, 0, 2);
        grid.add(txtEmail, 1, 2);
        grid.add(lblGpa, 0, 3);
        grid.add(txtGpa, 1, 3);
        grid.add(lblSsn, 0, 4);
        grid.add(txtSsn, 1, 4);
        grid.add(btnAdd, 0, 5);
        
        grid.setAlignment(Pos.CENTER);
        
    	// On button click, append new Student() to students
        btnAdd.setOnAction(e -> {
            String name = txtName.getText();
            String address = txtAddress.getText();
            String email = txtEmail.getText();
            double gpa = Double.valueOf(txtGpa.getText());
            int ssn = Integer.valueOf(txtSsn.getText());
            
            Student stu = new Student(name, address, email, gpa, ssn);
            students.add(stu);
            stage.close();
        });
        
        Scene scene = new Scene(grid, 300, 200);
        stage.setScene(scene);
        stage.show();
        
    }
    
    static void edit(Student target) {
    	// Create a window with data fields filled
    	// On button click, iterate through each field and set each
    	System.out.println("Edit Student");
    }
        
    public Student(String fullName, String Address, 
                String email, double gpa, int ssn){
        this.studentID = studentID;
        this.fullName = fullName;
        this.Address = Address;
        this.email = email;
        this.gpa = gpa;
        this.ssn = ssn; // did not include the this.stuIDs
        
    }    

    public void editStudent(String fullName, String Address, 
                String email, double gpa){
        this.fullName = fullName;
        this.Address = Address;
        this.email = email;
        this.gpa = gpa;
    }
    
    public String getFullName(){
        return this.fullName;
    }   

    public Double getGPA(){
        return this.gpa;
    }   
        
    public int getSSN(){
        return this.ssn;
    }    

    public String getAddress(){
        return this.Address;
    }

    public int getStuID(){
        
        return this.studentID;
        
    }

    // Override
    public boolean equals(Student stu) {
        return this.fullName.equals(stu.fullName);
    }

    private static int getNewID() {
        int newID = prevStuID++;
        return newID;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public String getCourses(Semester sem) {
        String str = "";
        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            if (c.getSemester().equals(sem)) {
                str += c.getPrefix() + " " + c.getNumber() + "\n";
            }
        }
        return str;
    }

}