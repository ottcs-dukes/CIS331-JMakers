package com.jmakers.gui;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.collections.*;

/**
 * JavaFX App
 */
public class App extends Application {
	
    private static ArrayList<Semester> semesters;
    private static ArrayList<Student> students;
    private static ArrayList<Faculty> faculty;
    private static ArrayList<Course> courses;
    private static ArrayList<Schedule> schedules;
    private static ArrayList<Enrollment> enrollments;

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        
        stage.setTitle("JMakers | Main Menu");
        
        GridPane primaryPane = new GridPane();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(primaryPane, 640, 480);
        
        Button createStudent = new Button("Create Student");
        createStudent.setOnAction(e -> {Student.create(students);});
        primaryPane.add(createStudent,0,0);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        semesters = new ArrayList<Semester>();
        students = new ArrayList<Student>();
        faculty = new ArrayList<Faculty>();
        courses = new ArrayList<Course>();
        schedules = new ArrayList<Schedule>();
        enrollments = new ArrayList<Enrollment>();
        launch();
    }

}