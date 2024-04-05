public class Course {

    private String prefix;
    private int number;
    private String name;
    private String[] days;
    private String startTime;
    private String endTime;
    private int creditHours;
    private Student[] enrollment;
    private Semester semester;

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

    
    public void editCourse( String name, String[] days, String startTime,
        String endTime, int creditHours, Semester semester) {

        this.name = name;
        this.days = days;
        this.startTime = startTime;
        this.endTime = endTime;
        this.creditHours = creditHours;
        this.semester = semester;
    }
    
    public String getPrefix(){
        return this.prefix;
    }
    public int getNumber(){
        return this.number;
    }
    public String getName(){
        return this.name;
    }
    public String[] getDays(){
        return this.days;
    }
    public String getStartTime(){
        return this.startTime;
    }
    public String getEndTime(){
        return this.endTime;
    }
    public int getCreditHours(){
        return this.creditHours;
    }
    public Student[] getEnrollment(){
        return this.enrollment;
    }
    public Semester getSemester(){
        return this.semester;
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
    
   public String printStudents(Semester sem) {
        if (this.semester.equals(sem)) {
            String str = "";
            if (enrollment != null) {
                for (Student stu : enrollment) {
                    if (stu != null) {
                        str += stu.getFullName() + "\n";
                    }
                    return str;
                }
            }
        } else {
            return "";
        }
        return "";
   }

   public boolean equals(Course course) {
        return this.prefix.equals(course.getPrefix()) && this.number == course.getNumber();
   }

}