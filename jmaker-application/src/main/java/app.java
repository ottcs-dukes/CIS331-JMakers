
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author user
 */
public class app {

    public static void main(String[] args) {

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

        Scanner in = new Scanner(System.in);

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
                System.out.println("(We would actually call the specific \"" + menuName[state] + "\" function here, if we had one)");
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
                        break;
                    case 11: // Edit Student
                        break;
                    case 12: // Create Course
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
