// GUI Application
// Cooper Ott, Ryan Curran, Ethan Fannon

package com.mycompany.testfx;

import java.util.ArrayList;

import com.mycompany.testfx.SystemInfo;
import com.mycompany.testfx.Course;
import com.mycompany.testfx.Enrollment;
import com.mycompany.testfx.Faculty;
import com.mycompany.testfx.Schedule;
import com.mycompany.testfx.Semester;
import com.mycompany.testfx.Student;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


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
        
        GridPane pane = new GridPane();
        var scene = new Scene(pane, 640, 480);
        
        Label createLabel = new Label("Create...");
        pane.add(createLabel,0,0);
        
        Button createSemester = new Button("Semester");
        createSemester.setOnAction(e -> {Semester.create(semesters);});
        pane.add(createSemester,0,1);
        
        Button createFaculty = new Button("Faculty");
        createFaculty.setOnAction(e -> {Faculty.create(faculty);});
        pane.add(createFaculty,0,2);
        
        Button createStudent = new Button("Student");
        createStudent.setOnAction(e -> {Student.create(students);});
        pane.add(createStudent,0,3);
        
        Button createCourse = new Button("Course");
        createCourse.setOnAction(e -> {Course.create(courses);});
        pane.add(createCourse,0,4);
        
        Label editLabel = new Label("Edit...");
        pane.add(editLabel,1,0);
        
        Button editSemester = new Button("Semester");
        editSemester.setOnAction(e -> {Semester.edit(null);});
        pane.add(editSemester,1,1);
        
        Button editFaculty = new Button("Faculty");
        editFaculty.setOnAction(e -> {Faculty.edit(null);});
        pane.add(editFaculty,1,2);
        
        Button editStudent = new Button("Student");
        editStudent.setOnAction(e -> {Student.edit(null);});
        pane.add(editStudent,1,3);
        
        Button editCourse = new Button("Course");
        editCourse.setOnAction(e -> {Course.edit(null);});
        pane.add(editCourse,1,4);
        
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