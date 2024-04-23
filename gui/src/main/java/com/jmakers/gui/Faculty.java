package com.jmakers.gui;

import java.util.ArrayList;

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
    
    static void create(ArrayList<Faculty> faculty) {
    	// Create a window
    	// On button click, append new Faculty() to faculty
    	System.out.println("Create Faculty");
    }
    
    static void edit(Faculty faculty) {
    	// Create a window with data fields filled
    	// On button click, iterate through each field and set each
    	System.out.println("Edit Faculty");
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

}


