package com.mycompany.testfx;

import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Schedule {

    private Course course;
    private Faculty faculty;

    public Schedule(Course course, Faculty faculty) {
        this.course = course;
        this.faculty = faculty;
    }

    public Course getCourse() {
        return this.course;
    }

    public Faculty getFaculty() {
        return this.faculty;
    }

    public void editSchedule(Semester sem, Course course, Faculty fac) {
        this.course = course;
        this.faculty = fac;
    }

    public boolean equals(Schedule schedule) {
        return this.course.equals(schedule.getCourse()) && 
            this.faculty.equals(schedule.getFaculty());
    }
    
    public static void assign(ArrayList<Faculty> faculty, ArrayList<Course> courses,
            ArrayList<Schedule> schedules) {
        Stage stage = new Stage();
        
        stage.setTitle("Assign a Faculty to a Course");
        
        Label lblChooseFac = new Label("Choose a faculty");
        lblChooseFac.setMinWidth(100);
        ComboBox<Faculty> cmboChooseFac = new ComboBox<>();
        cmboChooseFac.setStyle("-fx-font-family: monospace");
        Label lblChooseCourse = new Label("Choose a course");
        lblChooseCourse.setMinWidth(100);
        ComboBox<Course> cmboChooseCourse = new ComboBox<>();
        cmboChooseCourse.setStyle("-fx-font-family: monospace");
        Button btnAdd = new Button("Add faculty to course");
        btnAdd.setMinWidth(100);
        
                
        GridPane grid = new GridPane();
        grid.add(lblChooseFac, 0, 0);
        grid.add(cmboChooseFac, 1, 0);
        grid.add(lblChooseCourse, 0, 1);
        grid.add(cmboChooseCourse, 1, 1);
        grid.add(btnAdd, 0, 2);
        
        grid.setAlignment(Pos.CENTER);
        
        for (Faculty fac : faculty) {
	    cmboChooseFac.getItems().add(fac);
	}
        
        for (Course course : courses) {
            cmboChooseCourse.getItems().add(course);
        }

        var fac = new Object() {
            Faculty prof = null;
        };
        cmboChooseFac.setOnAction(e -> {
            fac.prof = cmboChooseFac.getSelectionModel().getSelectedItem();
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
            Schedule schedule = new Schedule(course.co, fac.prof);
            schedules.add(schedule);
            stage.close();
        });
    }
    
    @Override
    public String toString() {
    	return this.course.toString() + " by " + this.faculty.toString();
    }

}