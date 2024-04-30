package com.mycompany.database;

import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Enrollment {

    private Course course;
    private Student student;

    public Enrollment(Course course, Student student) {
        this.course = course;
        this.student = student;
    }

    public Course getCourse() {
        return this.course;
    }

    public Student getStudent() {
        return this.student;
    }

    public void edit(Course course, Student student) {
        this.course = course;
        this.student = student;
    }

    public boolean equals(Enrollment schedule) {
        return this.course.equals(schedule.getCourse()) && 
            this.student.equals(schedule.getStudent());
    }
    
    public static void assign(ArrayList<Student> students, ArrayList<Course> courses,
        ArrayList<Enrollment> enrollments) {
        Stage stage = new Stage();
        
        stage.setTitle("Assign a Student to a Course");
        
        Label lblChooseStu = new Label("Choose a student");
        lblChooseStu.setMinWidth(100);
        ComboBox<Student> cmboChooseStu = new ComboBox<>();
        cmboChooseStu.setStyle("-fx-font-family: monospace");
        Label lblChooseCourse = new Label("Choose a course");
        lblChooseCourse.setMinWidth(100);
        ComboBox<Course> cmboChooseCourse = new ComboBox<>();
        cmboChooseCourse.setStyle("-fx-font-family: monospace");
        Button btnAdd = new Button("Add student to course");
        
                
        GridPane grid = new GridPane();
        grid.add(lblChooseStu, 0, 0);
        grid.add(cmboChooseStu, 1, 0);
        grid.add(lblChooseCourse, 0, 1);
        grid.add(cmboChooseCourse, 1, 1);
        grid.add(btnAdd, 0, 2);
        
        grid.setAlignment(Pos.CENTER);
        
        for (Student stu : students) {
	    cmboChooseStu.getItems().add(stu);
	}
        
        for (Course course : courses) {
            cmboChooseCourse.getItems().add(course);
        }

        var student = new Object() {
            Student stu = null;
        };
        cmboChooseStu.setOnAction(e -> {
            student.stu = cmboChooseStu.getSelectionModel().getSelectedItem();
        });
        
        var course = new Object() {
            Course co = null;
        };
        cmboChooseCourse.setOnAction(e -> {
            course.co = cmboChooseCourse.getSelectionModel().getSelectedItem();
        });
        
        Scene scene = new Scene(grid, 300, 200);
        stage.setScene(scene);
        stage.show();
        
        btnAdd.setOnAction(e -> {
            Enrollment enrollment = new Enrollment(course.co, student.stu);
            enrollments.add(enrollment);
            stage.close();
        });
    }

}