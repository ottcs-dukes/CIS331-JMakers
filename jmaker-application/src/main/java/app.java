
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
    private static double promptDbl(String str) {
        System.out.print(str);
        double response = in.nextDouble();
        in.nextLine();
        return response;
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
    
    // COURSE
    private static ArrayList<Course> courses;
    private static void createCourse() {
        String[] dow = new String[promptInt("How many days of the week is this course taught? ")];
        for (int i = 0; i < dow.length; i++) {
            dow[i] = promptStr("What is day " + i + "? ");
        }
        courses.add(new Course(
                promptStr("Course Prefix: "),
                promptInt("Course Number: "),
                promptStr("Course Name: "),
                dow,
                promptStr("Start Time: "),
                promptStr("End Time: "),
                promptInt("Credit Hours: "),
                null// Semester semester
        ));
    }
    
    // SEMESTERS
    private static ArrayList<Semester> semesters;

    public static void main(String[] args) {

        in = new Scanner(System.in);
        
        students = new ArrayList<Student>();
        faculty = new ArrayList<Faculty>();
        courses = new ArrayList<Course>();
        semesters = new ArrayList<Semester>();

        String[] menuName = {
            "Exit JMaker", // 0
            "Main Menu", // 1
            "Manage Semesters", // 2
            "Manage Faculty", // 3
            "Manage Students", // 4
            "Manage Courses", // 5
            "Create Semester", // 6
            "Edit Semester", // 7
            "Create Faculty", // 8
            "Edit Faculty", // 9
            "Create Student", // 10
            "Edit Student", // 11
            "Create Course", // 12
            "Edit Course", // 13
            "Assign Faculty to Course", // 14
            "Enroll Student in Course", // 15
        };

        int[][] menuFSM = {
            {}, // Exit Program, placeholder
            {0, 2, 3, 4, 5}, // Main Menu
            {1, 6, 7}, // Manage Semesters
            {1, 8, 9, 14}, // Manage Faculty
            {1, 10, 11, 15}, // Manage Students
            {1, 12, 13, 14, 15}, // Manage Courses
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
                    case 6: // Create Semester
                        System.out.println("Enter semester season. (Winter, Spring, Summer, Fall)");
                        String period = in.nextLine();
                        System.out.println("Enter semester year.");
                        int year = in.nextInt();
                        Semester sem = new Semester(period, year);
                        break;
                    case 7: // Edit Semester
                        break;
                    case 8: // Create Faculty
                        break;
                    case 9: // Edit Faculty
                        break;
                    case 10: // Create Student
                        createStudent();
                        break;
                    case 11: // Edit Student
                        editStudent();
                        break;
                    case 12: // Create Course
                        createCourse();
                        break;
                    case 13: // Edit Course
                        break;
                    case 14: // Assign Faculty to Course
                        break;
                    case 15: // Enroll Student in Course
                        break;
                }
                
                // Jump back to main menu on completion
                state = 1;
            }
        }
        System.out.println("JMaker terminated!");
    }
}
