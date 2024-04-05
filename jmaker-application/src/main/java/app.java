
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author user
 */
public class app {

    // INPUT HANDLING AND PROMPTING
    private static Scanner in;

    private static String promptStr(String str) {
        System.out.print(str);
        return in.nextLine();
    }

    private static int promptInt(String str) {
        System.out.print(str);
        int response = in.nextInt();
        in.nextLine();
        return response;
    }

    private static long promptLng(String str) {
        System.out.print(str);
        long response = in.nextLong();
        in.nextLine();
        return response;
    }

    private static double promptDbl(String str) {
        System.out.print(str);
        double response = in.nextDouble();
        in.nextLine();
        return response;
    }

    private static String[] promptStrArr(String num, String per) {
        String[] response = new String[promptInt(num)];
        for (int i = 0; i < response.length; i++) {
            response[i] = promptStr("[" + i + "] " + per);
        }
        return response;
    }

    // SEMESTERS
    private static ArrayList<Semester> semesters;

    private static void createSemester() {
        semesters.add(new Semester(
                promptStr("Enter semester season. (Winter, Spring, Summer, Fall): "),
                promptInt("Enter semester year: ")
        ));
    }

    private static Semester requestSemester() {
        for (int s = 0; s < semesters.size(); s++) {
            System.out.println(s + ". " + semesters.get(s).toString());
        }
        return semesters.get(promptInt("Select a semester: "));
    }

    private static void editSemester() {
        Semester target = requestSemester();
        target.editSemester(
                promptStr("Enter semester season. (Winter, Spring, Summer, Fall): "),
                promptInt("Enter semester year: ")
        );
    }

    // STUDENT
    private static ArrayList<Student> students;

    private static void createStudent() {
        students.add(new Student(
                promptStr("Student Full Name: "),
                promptStr("Student Address: "),
                promptStr("Student Email: "),
                promptDbl("Student GPA: "),
                promptInt("Student SSN: ")
        ));
    }

    private static Student requestStudent() {
        for (int s = 0; s < students.size(); s++) {
            System.out.println(s + ". " + students.get(s).getFullName());
        }
        return students.get(promptInt("Select a student: "));
    }

    private static void editStudent() {
        Student target = requestStudent();
        target.editStudent(
                promptStr("Student Full Name: "),
                promptStr("Student Address: "),
                promptStr("Student Email: "),
                promptDbl("Student GPA: ")
        );
    }

    // FACULTY
    private static ArrayList<Faculty> faculty;

    private static void createFaculty() {
        faculty.add(new Faculty(
                promptStr("Faculty Name: "),
                promptStr("Faculty Email: "),
                promptStr("Building Name: "),
                promptInt("Office Number: "),
                promptLng("Phone Number: "),
                promptStr("Department: "),
                promptStr("Position: ")
        ));
    }

    private static Faculty requestFaculty() {
        for (int s = 0; s < faculty.size(); s++) {
            System.out.println(s + ". " + faculty.get(s).getName());
        }
        return faculty.get(promptInt("Select a faculty member: "));
    }

    private static void editFaculty() {
        Faculty target = requestFaculty();
        target.editFaculty(
                promptStr("Faculty Name: "),
                promptStr("Faculty Email: "),
                promptStr("Building Name: "),
                promptInt("Office Number: "),
                promptLng("Phone Number: "),
                promptStr("Department: "),
                promptStr("Position: ")
        );
    }
    // COURSE
    private static ArrayList<Course> courses;

    private static void createCourse() {
        courses.add(new Course(
                promptStr("Course Prefix: "),
                promptInt("Course Number: "),
                promptStr("Course Name: "),
                promptStrArr("How many days per week is this course taught? ", "Which day? "),
                promptStr("Start Time: "),
                promptStr("End Time: "),
                promptInt("Credit Hours: "),
                requestSemester()
        ));
    }

    private static Course requestCourse() {
        for (int s = 0; s < courses.size(); s++) {
            System.out.println(s + ". " + courses.get(s).getName());
        }
        return courses.get(promptInt("Select a course: "));
    }

    private static Course requestCourse(Semester exclude) {
        for (int s = 0; s < courses.size(); s++) {
            if (exclude.equals(courses.get(s).getSemester())) {
                System.out.println(s + ". " + courses.get(s).getName());
            }
        }
        return courses.get(promptInt("Select a course: "));
    }

    private static void editCourse() {
        Course target = requestCourse();
        target.editCourse(
                promptStr("Course Name: "),
                promptStrArr("How many days per week is this course taught? ", "Which day? "),
                promptStr("Start Time: "),
                promptStr("End Time: "),
                promptInt("Credit Hours: "),
                requestSemester()
        );
    }

    // SCHEDULES
    private static ArrayList<Schedule> schedules;

    private static void createSchedule() {
        schedules.add(new Schedule(
                requestSemester(),
                requestCourse(),
                requestFaculty()
        ));
    }

    // LAST SIX FUNCTIONALITY
    private static void coursesInSemester() {
        Semester target = requestSemester();
        for (Course c : courses) {
            if (c.getSemester().equals(target)) {
                System.out.println(c.getPrefix() + " " + c.getNumber());
            }
        }
    }

    private static void coursesByFaculty() {
        Semester sTarget = requestSemester();
        Faculty fTarget = requestFaculty();

        for (Schedule s : schedules) {
            if (s.getSemester().equals(sTarget) && s.getFaculty().equals(fTarget)) {
                System.out.println(s.getCourse().getPrefix() + " " + s.getCourse().getNumber());
            }
        }
    }

    private static void studentSemesterCourses() {
        System.out.println(requestStudent().getCourses(requestSemester()));
    }

    private static void studentsInCourse() {
        Semester semestertarget = requestSemester();
        String targetPrefix = promptStr("What is the course prefix? ");
        int targetNumber = promptInt("What is the course number? ");
        for (Course c : courses) {
            if (c.getNumber() == targetNumber && c.getPrefix().equals(targetPrefix)) {
                c.printStudents(semestertarget);
            }
        }
    }

    // APP
    public static void main(String[] args) {

        in = new Scanner(System.in);

        students = new ArrayList<Student>();
        faculty = new ArrayList<Faculty>();
        courses = new ArrayList<Course>();
        semesters = new ArrayList<Semester>();
        schedules = new ArrayList<Schedule>();

        String[] menuName = {
            "Exit JMaker", // 0
            "Main Menu", // 1
            "Manage Semesters", // 2
            "Manage Faculty", // 3
            "Manage Students", // 4
            "Manage Courses", // 5
            "Generate Reports", // 6
            "Create Semester", // 7
            "Edit Semester", // 8
            "Create Faculty", // 9
            "Edit Faculty", // 10
            "Create Student", // 11
            "Edit Student", // 12
            "Create Course", // 13
            "Edit Course", // 14
            "Assign Faculty to Course", // 15
            "Enroll Student in Course", // 16
            "Courses in a Semester", // 17
            "Courses taught by a Faculty Member", // 18
            "Courses a Student is Enrolled in", // 19
            "Students Enrolled in a Course" // 20
        };

        int[][] menuFSM = {
            {}, // Exit Program, placeholder
            {0, 2, 3, 4, 5, 6}, // Main Menu
            {1, 7, 8}, // Manage Semesters
            {1, 9, 10, 15}, // Manage Faculty
            {1, 11, 12, 16}, // Manage Students
            {1, 13, 14, 15, 16}, // Manage Courses
            {1, 17, 18, 19, 20} // Generate Reports
        };

        int state = 1;
        while (state > 0) { // State 0 exits

            // Print the current state, and a bar
            System.out.println(menuName[state] + "\n===========================");

            // Check if the current location has options
            if (state < menuFSM.length) {

                // Print all of the options for the current state
                for (int option = 0; option < menuFSM[state].length; option++) {
                    System.out.println("[" + option + "] " + menuName[menuFSM[state][option]]);
                }

                // Get user's choice for where to go
                state = menuFSM[state][in.nextInt()];
                in.nextLine();

            } else {

                // No options, just functionality to call
                switch (state) {
                    case 7: // Create Semester
                        createSemester();
                        break;
                    case 8: // Edit Semester
                        editSemester();
                        break;
                    case 9: // Create Faculty
                        createFaculty();
                        break;
                    case 10: // Edit Faculty
                        editFaculty();
                        break;
                    case 11: // Create Student
                        createStudent();
                        break;
                    case 12: // Edit Student
                        editStudent();
                        break;
                    case 13: // Create Course
                        createCourse();
                        break;
                    case 14: // Edit Course
                        editCourse();
                        break;
                    case 15: // Assign Faculty to Course
                        createSchedule();
                        break;
                    case 16: // Enroll Student in Course
                        requestStudent().addCourse(requestCourse(requestSemester()));
                        break;
                    case 17: // Courses in a Semester
                        coursesInSemester();
                        break;
                    case 18: // Courses taught by a Faculty Member
                        coursesByFaculty();
                        break;
                    case 19: // Courses a Student is Enrolled in
                        studentSemesterCourses();
                        break;
                    case 20: // Students Enrolled in a Course
                        studentsInCourse();
                        break;
                }

                // Jump back to main menu on completion
                state = 1;
            }
        }
        System.out.println("JMaker terminated!");
    }
}
