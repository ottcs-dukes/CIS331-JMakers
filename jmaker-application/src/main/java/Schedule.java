public class Schedule {

    public Semester semester;
    public Course course;
    public Faculty faculty;

    public Schedule(Semester semester, Course course, Faculty faculty) {
        this.semester = semester;
        this.course = course;
        this.faculty = faculty;
    }

}