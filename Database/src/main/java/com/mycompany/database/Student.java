package com.mycompany.database;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    
    // Create a Student
    static void create(ArrayList<Student> students) {
    	// Create a window
        Stage stage = new Stage();
        
        stage.setTitle("Create Student");
        
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
        
        Stage stagePopUp = new Stage();
        stagePopUp.setTitle("Error");
        GridPane gridPopUp = new GridPane();
        gridPopUp.setAlignment(Pos.CENTER);
        Label lblPopUp = new Label("");
        Button btnPopUp = new Button("Close");    
        gridPopUp.add(lblPopUp, 0, 0);
        gridPopUp.add(btnPopUp, 0, 1);
        Scene scenePopUp = new Scene(gridPopUp, 200, 100);
        stagePopUp.setScene(scenePopUp);
        
    	// On button click, append new Student() to students
        btnAdd.setOnAction(e -> {
            Student stu = null;
            String name = "";
            String address = "";
            String email = "";
            double gpa = -1;
            int ssn = -1;
            
            // Creates a pop up window specifying data needs to filled out - data validation
            if (txtName.getText().equals("")) {
                lblPopUp.setText("No entry for Student name");
                stagePopUp.show();
            } else if (txtAddress.getText().equals("")) {
                lblPopUp.setText("No entry for Student address");
                stagePopUp.show();
            } else if (txtEmail.getText().equals("")) {
                lblPopUp.setText("No entry for Student email");
                stagePopUp.show();
            } else if (txtGpa.getText().equals("")) {
                lblPopUp.setText("No entry for Student gpa");
                stagePopUp.show();
            } else if (txtSsn.getText().equals("")) {
                lblPopUp.setText("No entry for Student ssn");
                stagePopUp.show();
            } else { // if it isnt blank, then the input is set
                name = txtName.getText();
                address = txtAddress.getText();
                email= txtEmail.getText();
                gpa = Double.valueOf(txtGpa.getText());
                ssn = Integer.valueOf(txtSsn.getText());
                
                stu = new Student(name, address, email, gpa, ssn);
                students.add(stu);
                stage.close();
            }
            
        });
        
        btnPopUp.setOnAction(e -> {
            stagePopUp.close();
        });
        
        Scene scene = new Scene(grid, 300, 200);
        stage.setScene(scene);
        stage.show();
        
    }
    
    // Edit Student
    static void edit(ArrayList<Student> students) {
    	
    	// Create a window
        Stage stage = new Stage();
        
        var student = new Object(){Student stu = students.get(0);};
        ComboBox<Student> targeter = new ComboBox<Student>();
        
        for (Student s : students) {
            targeter.getItems().add(s);
        }
        targeter.getSelectionModel().selectFirst();
        
        stage.setTitle("Edit Student");
        
        Label lblName = new Label("Full Name:");
        TextField txtName = new TextField(student.stu.getFullName());
        Label lblAddress = new Label("Address:");
        TextField txtAddress = new TextField(student.stu.getAddress());
        Label lblEmail = new Label("Email:");
        TextField txtEmail = new TextField(student.stu.getEmail());
        Label lblGpa = new Label("GPA:");
        TextField txtGpa = new TextField(student.stu.getGPA() + "");
        Label lblDropdown = new Label ("Pick Student: ");
        Button btnAdd = new Button("Submit Edit");

        targeter.setOnAction(f -> {
                student.stu = targeter.getSelectionModel().getSelectedItem();
                txtName.setText(student.stu.getFullName());
                txtAddress.setText(student.stu.getAddress());
                txtEmail.setText(student.stu.getEmail());
                txtGpa.setText(String.valueOf(student.stu.getGPA()));
        });
                
        GridPane grid = new GridPane();
        grid.add(lblName, 0, 0);
        grid.add(txtName, 1, 0);
        grid.add(lblAddress, 0, 1);
        grid.add(txtAddress, 1, 1);
        grid.add(lblEmail, 0, 2);
        grid.add(txtEmail, 1, 2);
        grid.add(lblGpa, 0, 3);
        grid.add(txtGpa, 1, 3);
        grid.add(lblDropdown, 0, 4);
        grid.add(targeter, 1, 4);
        grid.add(btnAdd, 0, 5);
        
        grid.setAlignment(Pos.CENTER);
        
    	// On button click, submit change
        btnAdd.setOnAction(e -> {
            String name = txtName.getText();
            String address = txtAddress.getText();
            String email = txtEmail.getText();
            double gpa = Double.valueOf(txtGpa.getText());
            
            student.stu.editStudent(name, address, email, gpa);

            stage.close();
        });
        
        Scene scene = new Scene(grid, 300, 300);
        stage.setScene(scene);
        stage.show();
    }

    public Student(String fullName, String Address, 
                String email, double gpa, int ssn){
        this.studentID = getNewID();
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
    
    public String getEmail() {
    	return this.email;
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
    
    @Override
    public String toString() {
    	return this.fullName;
    }

}
