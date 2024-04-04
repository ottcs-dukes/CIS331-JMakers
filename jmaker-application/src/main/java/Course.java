public class Course {

    public String prefix;
    public int number;
    public String name;
    public String[] days;
    public String startTime;
    public String endTime;
    public int creditHours;
    public Student[] enrollment;
    public Semester semester;

    public Course(String prefix, int number, String name, String[] days, String startTime,
        String endTime, int creditHours, Semester semester) {

        this.prefix = prefix;
        this.number = number;
        this.name = name;
        this.days = days;
        this.startTime = startTime;
        this.endTime = endTime;
        this.creditHours = creditHours;
        this.enrollment = enrollment;
        this.semester = semester;
    }

    public void addStudent(Student stu) {
        for (int i = 0; i < enrollment.length; i++) {
            if (enrollment[i] == null) {
                enrollment[i] = stu;
                return;
            }
        }
        System.out.println("No available seats.");
    }

    public void removeStudent(Student stu) {
        for (int i = 0; i < enrollment.length; i++) {
            if (enrollment[i].equals(stu)) {
                enrollment[i] = null;
                return;
            }
        }
        System.out.println("No student found.");
    }

}