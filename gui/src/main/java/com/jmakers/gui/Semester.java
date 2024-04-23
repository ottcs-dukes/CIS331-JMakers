package com.jmakers.gui;

import java.util.ArrayList;

public class Semester {

    private String period;
    private int year;
    
    static void create(ArrayList<Semester> semesters) {
    	// Create a window
    	// On button click, append new Semester() to semesters
    	System.out.println("Create Student");
    }
    
    static void edit(Semester semester) {
    	// Create a window with data fields filled
    	// On button click, iterate through each field and set each
    	System.out.println("Edit Semester");
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
