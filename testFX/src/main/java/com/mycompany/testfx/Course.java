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

public class Course {

    private String prefix;
    private int number;
    private String name;
    private String[] days;
    private String startTime;
    private String endTime;
    private int creditHours;
    private Student[] enrollment;
    private Semester semester;

    static void create(ArrayList<Course> courses, ArrayList<Semester> semesters) {
	// Create a window
	// On button click, append new Course() to courses
	Stage stage = new Stage();

	stage.setTitle("Create Course");

	Label lblPrefix = new Label("Course Prefix: ");
	TextField txtPrefix = new TextField();
	Label lblNumber = new Label("Course Number: ");
	TextField txtNumber = new TextField();
	Label lblName = new Label("Course Name: ");
	TextField txtName = new TextField();
	Label lblDay = new Label("Days Taught (comma, separated, days): ");
	TextField txtDay = new TextField();
	Label lblStart = new Label("Start Time: ");
	TextField txtStart = new TextField();
	Label lblEnd = new Label("End Time: ");
	TextField txtEnd = new TextField();
	Label lblCredit = new Label("Credit Hours: ");
	TextField txtCredit = new TextField();
	Label lblSemester = new Label("Semester Taught: ");
	ComboBox<Semester> cmboSemesters = new ComboBox<>();
	Button btnAdd = new Button("Add Course");

	GridPane grid = new GridPane();

	grid.add(lblPrefix, 0, 0);
	grid.add(txtPrefix, 1, 0);
	grid.add(lblNumber, 0, 1);
	grid.add(txtNumber, 1, 1);
	grid.add(lblName, 0, 2);
	grid.add(txtName, 1, 2);
	grid.add(lblDay, 0, 3);
	grid.add(txtDay, 1, 3);
	grid.add(lblStart, 0, 4);
	grid.add(txtStart, 1, 4);
	grid.add(lblEnd, 0, 5);
	grid.add(txtEnd, 1, 5);
	grid.add(lblCredit, 0, 6);
	grid.add(txtCredit, 1, 6);
	grid.add(lblSemester, 0, 7);
	grid.add(cmboSemesters, 1, 7);
	grid.add(btnAdd, 0, 8);

	grid.setAlignment(Pos.CENTER);
	cmboSemesters.setStyle("-fx-font-family: monospace");

	for (Semester sem : semesters) {
	    cmboSemesters.getItems().add(sem);
	}

	var semester = new Object() {
	    Semester sem = null;
	};
	cmboSemesters.setOnAction(f -> {
	    semester.sem = cmboSemesters.getSelectionModel().getSelectedItem();
	});

	btnAdd.setOnAction(e -> {
	    String prefix = txtPrefix.getText();
	    int number = Integer.valueOf(txtNumber.getText());
	    String name = txtName.getText();
	    String[] days = txtDay.getText().split(", ");
	    String start = txtStart.getText();
	    String end = txtEnd.getText();
	    int credit = Integer.valueOf(txtCredit.getText());

	    Course course = new Course(prefix, number, name, days, start, end, credit, semester.sem);
	    courses.add(course);
	    stage.close();
	});

	Scene scene = new Scene(grid, 400, 400);
	stage.setScene(scene);
	stage.show();

    }

    static void edit(ArrayList<Course> courses, ArrayList<Semester> semesters) {
	// Create a window
	// On button click, append new Course() to courses
	Stage stage = new Stage();

	var course = new Object() {
	    Course crs = courses.get(0);
	};
	ComboBox<Course> targeter = new ComboBox<Course>();

	for (Course c : courses) {
	    targeter.getItems().add(c);
	}

	stage.setTitle("Edit Course");

	Label lblName = new Label("Course Name: ");
	TextField txtName = new TextField(course.crs.getName());
	Label lblDay = new Label("Days Taught (comma, separated, days): ");
	TextField txtDay = new TextField(String.join(", ", course.crs.getDays()));
	Label lblStart = new Label("Start Time: ");
	TextField txtStart = new TextField(course.crs.getStartTime());
	Label lblEnd = new Label("End Time: ");
	TextField txtEnd = new TextField(course.crs.getEndTime());
	Label lblCredit = new Label("Credit Hours: ");
	TextField txtCredit = new TextField(course.crs.getCreditHours() + "");
	Label lblSemester = new Label("Semester Taught: ");
	ComboBox<Semester> cmboSemesters = new ComboBox<>();
        Label lblCourse = new Label("Courses");
	Button btnAdd = new Button("Submit Edit");

	targeter.setOnAction(f -> {
	    course.crs = targeter.getSelectionModel().getSelectedItem();
	    txtName.setText(course.crs.getName());
	    txtDay.setText(String.join(", ", course.crs.getDays()));
	    txtStart.setText(course.crs.getStartTime());
	    txtEnd.setText(course.crs.getEndTime());
	    txtCredit.setText(course.crs.getCreditHours() + "");
	});

	GridPane grid = new GridPane();
	grid.add(lblName, 0, 2);
	grid.add(txtName, 1, 2);
	grid.add(lblDay, 0, 3);
	grid.add(txtDay, 1, 3);
	grid.add(lblStart, 0, 4);
	grid.add(txtStart, 1, 4);
	grid.add(lblEnd, 0, 5);
	grid.add(txtEnd, 1, 5);
	grid.add(lblCredit, 0, 6);
	grid.add(txtCredit, 1, 6);
	grid.add(lblSemester, 0, 7);
	grid.add(cmboSemesters, 1, 7);
	grid.add(lblCourse, 0, 8);
        grid.add(targeter, 1, 8);
        grid.add(btnAdd, 0, 9);


	grid.setAlignment(Pos.CENTER);
	cmboSemesters.setStyle("-fx-font-family: monospace");

	for (Semester sem : semesters) {
	    cmboSemesters.getItems().add(sem);
	}

	var semester = new Object() {
	    Semester sem = null;
	};
	cmboSemesters.setOnAction(e -> {
	    semester.sem = cmboSemesters.getSelectionModel().getSelectedItem();
	});

	btnAdd.setOnAction(e -> {
	    String name = txtName.getText();
	    String[] days = txtDay.getText().split(",");
	    String start = txtStart.getText();
	    String end = txtEnd.getText();
	    int credit = Integer.valueOf(txtCredit.getText());

	    course.crs.editCourse(name, days, start, end, credit, semester.sem);
	    stage.close();
	});

	Scene scene = new Scene(grid, 400, 400);
	stage.setScene(scene);
	stage.show();
	
    }

    public Course(String prefix, int number, String name, String[] days, String startTime, String endTime,
	    int creditHours, Semester semester) {

	this.prefix = prefix;
	this.number = number;
	this.name = name;
	this.days = days;
	this.startTime = startTime;
	this.endTime = endTime;
	this.creditHours = creditHours;
	this.enrollment = enrollment;
	this.semester = semester;
    }

    public void editCourse(String name, String[] days, String startTime, String endTime, int creditHours,
	    Semester semester) {

	this.name = name;
	this.days = days;
	this.startTime = startTime;
	this.endTime = endTime;
	this.creditHours = creditHours;
	this.semester = semester;
    }

    public String getPrefix() {
	return this.prefix;
    }

    public int getNumber() {
	return this.number;
    }

    public String getName() {
	return this.name;
    }

    public String[] getDays() {
	return this.days;
    }

    public String getStartTime() {
	return this.startTime;
    }

    public String getEndTime() {
	return this.endTime;
    }

    public int getCreditHours() {
	return this.creditHours;
    }

    public Student[] getEnrollment() {
	return this.enrollment;
    }

    public Semester getSemester() {
	return this.semester;
    }

    public void addStudent(Student stu) {
	for (int i = 0; i < enrollment.length; i++) {
	    if (enrollment[i] == null) {
		enrollment[i] = stu;
		return;
	    }
	}
	System.out.println("No available seats.");
    }

    public void removeStudent(Student stu) {
	for (int i = 0; i < enrollment.length; i++) {
	    if (enrollment[i].equals(stu)) {
		enrollment[i] = null;
		return;
	    }
	}
	System.out.println("No student found.");
    }

    public String printStudents(Semester sem) {
	if (this.semester.equals(sem)) {
	    String str = "";
	    if (enrollment != null) {
		for (Student stu : enrollment) {
		    if (stu != null) {
			str += stu.getFullName() + "\n";
		    }
		    return str;
		}
	    }
	} else {
	    return "";
	}
	return "";
    }

    public boolean equals(Course course) {
	return this.prefix.equals(course.getPrefix()) && this.number == course.getNumber();
    }
    
    public String toString() {
        return prefix + " " + number;
    }
    
}