package com.jmakers.gui;
public class Schedule {

    private Semester semester;
    private Course course;
    private Faculty faculty;

    public Schedule(Semester semester, Course course, Faculty faculty) {
        this.semester = semester;
        this.course = course;
        this.faculty = faculty;
    }

    public Semester getSemester() {
        return this.semester;
    }

    public Course getCourse() {
        return this.course;
    }

    public Faculty getFaculty() {
        return this.faculty;
    }

    public void editSchedule(Semester sem, Course course, Faculty fac) {
        this.semester = sem;
        this.course = course;
        this.faculty = fac;
    }

    public boolean equals(Schedule schedule) {
        return this.semester.equals(schedule.getSemester()) &&
            this.course.equals(schedule.getCourse()) && 
            this.faculty.equals(schedule.getFaculty());
    }

}