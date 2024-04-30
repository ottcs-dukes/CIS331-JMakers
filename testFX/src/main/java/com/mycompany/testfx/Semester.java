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

public class Semester {

    private String period;
    private int year;
    
    // Create a Semester
    static void create(ArrayList<Semester> semesters) {
    	// Create a window
    	// On button click, append new Semester() to semesters
    	Stage stage = new Stage();
        
        stage.setTitle("Create Semester");

        
        Label lblPeriod = new Label("Semester: ");
            TextField txtPeriod = new TextField();
        Label lblYear = new Label("Year: ");
            TextField txtYear = new TextField();
        Button btnAdd = new Button("Create Semester");
        
        
        GridPane grid = new GridPane();
        
        grid.add(lblPeriod, 0, 0);
        grid.add(txtPeriod, 1, 0);
        grid.add(lblYear, 0, 1);
        grid.add(txtYear, 1, 1);
        grid.add(btnAdd, 0, 2);
        
        grid.setAlignment(Pos.CENTER);
        
        btnAdd.setOnAction(e -> {
            String period = txtPeriod.getText();
            int year = Integer.valueOf(txtYear.getText());
            
            Semester sem = new Semester(period, year);
            semesters.add(sem);
            stage.close();
        });
        
        Scene scene = new Scene(grid, 300, 200);
        stage.setScene(scene);
        stage.show();
        
    }
    
    // Edit a Semester
    static void edit(ArrayList <Semester> semesters) {
    	// Create a window with data fields filled
    	// On button click, iterate through each field and set each
    	Stage stage = new Stage();
        
        var semester = new Object() {Semester sem = semesters.get(0);};
        ComboBox<Semester> targeter = new ComboBox<Semester>();
        
        for (Semester s: semesters) {
            targeter.getItems().add(s);
        }
        targeter.getSelectionModel().selectFirst();
        
        stage.setTitle("Edit Semester");

        
        
        Label lblPeriod = new Label("Semester: ");
            TextField txtPeriod = new TextField(semester.sem.getPeriod());
        Label lblYear = new Label("Year: ");
            TextField txtYear = new TextField(semester.sem.getYear()+ "");
        Label lblSemes = new Label("Pick Semester: ");
        Button btnAdd = new Button("Submit Edit");
        
        targeter.setOnAction(f -> {
            semester.sem = targeter.getSelectionModel().getSelectedItem();
            txtPeriod.setText(semester.sem.getPeriod());
            txtYear.setText(String.valueOf(semester.sem.getYear()));
        });
        
        
        GridPane grid = new GridPane();
        
        grid.add(lblPeriod, 0, 0);
        grid.add(txtPeriod, 1, 0);
        grid.add(lblYear, 0, 1);
        grid.add(txtYear, 1, 1);
        grid.add(lblSemes, 0, 2);
        grid.add(targeter, 1, 2);
        grid.add(btnAdd, 0, 3);
        
        grid.setAlignment(Pos.CENTER);
        
        btnAdd.setOnAction(e -> {
            String period = txtPeriod.getText();
            int year = Integer.valueOf(txtYear.getText());
            
            semester.sem.editSemester(period, year);
            stage.close();
        });
        
        Scene scene = new Scene(grid, 300, 200);
        stage.setScene(scene);
        stage.show();
        
    
    }

    public Semester(String period, int year) {
        this.period = period;
        this.year = year;
    }

    public void editSemester(String period, int year) {
        this.period = period;
        this.year = year;
    }

    public String getPeriod() {
        return this.period;
    }

    public int getYear() {
        return this.year;
    }

    public boolean equals(Semester sem) {
        return this.period.equals(sem.getPeriod()) && this.year == sem.getYear();
    }

    public String toString() {
        return this.period + " " + this.year;
    }

}
