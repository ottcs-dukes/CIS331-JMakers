package com.jmakers.gui;
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

}