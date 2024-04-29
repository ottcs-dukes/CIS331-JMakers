// GUI Application
// Cooper Ott, Ryan Curran, Ethan Fannon

package com.mycompany.testfx;

import java.util.ArrayList;

import com.mycompany.testfx.SystemInfo;
import com.mycompany.testfx.Course;
import com.mycompany.testfx.Enrollment;
import com.mycompany.testfx.Faculty;
import com.mycompany.testfx.Schedule;
import com.mycompany.testfx.Semester;
import com.mycompany.testfx.Student;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	private static ArrayList<Semester> semesters;
	private static ArrayList<Student> students;
	private static ArrayList<Faculty> faculty;
	private static ArrayList<Course> courses;
	private static ArrayList<Schedule> schedules;
	private static ArrayList<Enrollment> enrollments;

	// REPORTS
	private static void coursesInSemester() {
		Stage stage = new Stage();

		stage.setTitle("JMakers | Generate Report");

		ComboBox<Semester> cmboSemesters = new ComboBox<Semester>();
		cmboSemesters.setStyle("-fx-font-family: monospace");

		TextArea textArea = new TextArea();

		for (Semester sem : semesters) {
			cmboSemesters.getItems().add(sem);
		}

		var semester = new Object() {
			Semester sem = null;
		};
		cmboSemesters.setOnAction(f -> {
			semester.sem = cmboSemesters.getSelectionModel().getSelectedItem();
			textArea.clear();
			textArea.appendText("Generating Report...\n");
			for (Course c : courses) {
				if (c.getSemester().equals(semester.sem)) {
					textArea.appendText(c.toString() + "\n");
				}
			}
			textArea.appendText("Done.\n");
		});

		GridPane grid = new GridPane();

		grid.add(cmboSemesters, 0, 0);
		grid.add(textArea, 0, 1);

		grid.setAlignment(Pos.CENTER);

		Scene scene = new Scene(grid, 300, 200);
		stage.setScene(scene);
		stage.show();
	}

	private static void coursesByFaculty() {
		Stage stage = new Stage();

		stage.setTitle("JMakers | Generate Report");

		ComboBox<Semester> cmboSemesters = new ComboBox<Semester>();
		cmboSemesters.setStyle("-fx-font-family: monospace");

		for (Semester sem : semesters) {
			cmboSemesters.getItems().add(sem);
		}

		ComboBox<Faculty> cmboFaculty = new ComboBox<Faculty>();
		cmboFaculty.setStyle("-fx-font-family: monospace");

		for (Faculty fac : faculty) {
			cmboFaculty.getItems().add(fac);
		}

		TextArea textArea = new TextArea();

		var selection = new Object() {
			Semester sem = null;
			Faculty fac = null;
		};

		cmboSemesters.setOnAction(f -> {
			selection.sem = cmboSemesters.getSelectionModel().getSelectedItem();
			textArea.clear();
			textArea.appendText("Generating Report...\n");
			if (selection.sem != null && selection.fac != null) {
				for (Schedule s : schedules) {
					if (s.getFaculty().equals(selection.fac) && s.getCourse().getSemester().equals(selection.sem)) {
						textArea.appendText(s.getCourse().toString() + "\n");
					}
				}
			}
			textArea.appendText("Done.\n");
		});

		cmboFaculty.setOnAction(f -> {
			selection.fac = cmboFaculty.getSelectionModel().getSelectedItem();
			textArea.clear();
			textArea.appendText("Generating Report...\n");
			if (selection.sem != null && selection.fac != null) {
				for (Schedule s : schedules) {
					if (s.getFaculty().equals(selection.fac) && s.getCourse().getSemester().equals(selection.sem)) {
						textArea.appendText(s.getCourse().toString() + "\n");
					}
				}
			}
			textArea.appendText("Done.\n");
		});

		GridPane grid = new GridPane();

		grid.add(cmboSemesters, 0, 0);
		grid.add(cmboFaculty, 1, 0);
		grid.add(textArea, 0, 1, 2, 1);

		grid.setAlignment(Pos.CENTER);

		Scene scene = new Scene(grid, 300, 200);
		stage.setScene(scene);
		stage.show();
	}

	private static void coursesOfStudent() {
		Stage stage = new Stage();

		stage.setTitle("JMakers | Generate Report");

		ComboBox<Semester> cmboSemesters = new ComboBox<Semester>();
		cmboSemesters.setStyle("-fx-font-family: monospace");

		for (Semester sem : semesters) {
			cmboSemesters.getItems().add(sem);
		}

		ComboBox<Student> cmboStudent = new ComboBox<Student>();
		cmboStudent.setStyle("-fx-font-family: monospace");

		for (Student stu : students) {
			cmboStudent.getItems().add(stu);
		}

		TextArea textArea = new TextArea();

		var selection = new Object() {
			Semester sem = null;
			Student stu = null;
		};

		cmboSemesters.setOnAction(f -> {
			selection.sem = cmboSemesters.getSelectionModel().getSelectedItem();
			textArea.clear();
			textArea.appendText("Generating Report...\n");
			if (selection.sem != null && selection.stu != null) {
				for (Enrollment e : enrollments) {
					if (e.getStudent().equals(selection.stu) && e.getCourse().getSemester().equals(selection.sem)) {
						textArea.appendText(e.getCourse().toString() + "\n");
					}
				}
			}
			textArea.appendText("Done.\n");
		});

		cmboStudent.setOnAction(f -> {
			selection.stu = cmboStudent.getSelectionModel().getSelectedItem();
			textArea.clear();
			textArea.appendText("Generating Report...\n");
			if (selection.sem != null && selection.stu != null) {
				for (Enrollment e : enrollments) {
					if (e.getStudent().equals(selection.stu) && e.getCourse().getSemester().equals(selection.sem)) {
						textArea.appendText(e.getCourse().toString() + "\n");
					}
				}
			}
			textArea.appendText("Done.\n");
		});

		GridPane grid = new GridPane();

		grid.add(cmboSemesters, 0, 0);
		grid.add(cmboStudent, 1, 0);
		grid.add(textArea, 0, 1, 2, 1);

		grid.setAlignment(Pos.CENTER);

		Scene scene = new Scene(grid, 300, 200);
		stage.setScene(scene);
		stage.show();
	}

	private static void studentsInCourse() {
		Stage stage = new Stage();

		stage.setTitle("JMakers | Generate Report");

		ComboBox<Course> cmboCourses = new ComboBox<Course>();
		cmboCourses.setStyle("-fx-font-family: monospace");

		TextArea textArea = new TextArea();

		for (Course crs : courses) {
			cmboCourses.getItems().add(crs);
		}

		var select = new Object() {
			Course crs = null;
		};
		cmboCourses.setOnAction(f -> {
			select.crs = cmboCourses.getSelectionModel().getSelectedItem();
			textArea.clear();
			textArea.appendText("Generating Report...\n");
			for (Enrollment e : enrollments) {
				if (e.getCourse().equals(select.crs)) {
					textArea.appendText(e.getStudent().toString() + "\n");
				}
			}
			textArea.appendText("Done.\n");
		});

		GridPane grid = new GridPane();

		grid.add(cmboCourses, 0, 0);
		grid.add(textArea, 0, 1);

		grid.setAlignment(Pos.CENTER);

		Scene scene = new Scene(grid, 300, 200);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("JMakers | Main Menu");

		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		var scene = new Scene(pane, 640, 480);

		Label createLabel = new Label("Create...");
		createLabel.setMinWidth(300);
		pane.add(createLabel, 0, 0);

		Button createSemester = new Button("Semester");
		createSemester.setMinWidth(300);
		createSemester.setOnAction(e -> {
			Semester.create(semesters);
		});
		pane.add(createSemester, 0, 1);

		Button createFaculty = new Button("Faculty");
		createFaculty.setMinWidth(300);
		createFaculty.setOnAction(e -> {
			Faculty.create(faculty);
		});
		pane.add(createFaculty, 0, 2);

		Button createStudent = new Button("Student");
		createStudent.setMinWidth(300);
		createStudent.setOnAction(e -> {
			Student.create(students);
		});
		pane.add(createStudent, 0, 3);

		Button createCourse = new Button("Course");
		createCourse.setMinWidth(300);
		createCourse.setOnAction(e -> {
			Course.create(courses, semesters);
		});
		pane.add(createCourse, 0, 4);

		Label editLabel = new Label("Edit...");
		editLabel.setMinWidth(300);
		pane.add(editLabel, 1, 0);

		Button editSemester = new Button("Semester");
		editSemester.setMinWidth(300);
		editSemester.setOnAction(e -> {
			Semester.edit(semesters);
		});
		pane.add(editSemester, 1, 1);

		Button editFaculty = new Button("Faculty");
		editFaculty.setMinWidth(300);
		editFaculty.setOnAction(e -> {
			Faculty.edit(faculty);
		});
		pane.add(editFaculty, 1, 2);

		Button editStudent = new Button("Student");
		editStudent.setMinWidth(300);
		editStudent.setOnAction(e -> {
			Student.edit(students);
		});
		pane.add(editStudent, 1, 3);

		Button editCourse = new Button("Course");
		editCourse.setMinWidth(300);
		editCourse.setOnAction(e -> {
			Course.edit(courses, semesters);
		});
		pane.add(editCourse, 1, 4);

		Label lblAssign = new Label("Assign...");
		lblAssign.setMinWidth(600);
		pane.add(lblAssign, 0, 5, 2, 1);

		Button btnStuToCourse = new Button("Student to Course");
		btnStuToCourse.setMinWidth(600);
		btnStuToCourse.setOnAction(e -> {
			Enrollment.assign(students, courses, enrollments);
		});
		pane.add(btnStuToCourse, 0, 6, 2, 1);

		Button btnFacultyToCourse = new Button("Faculty to Course");
		btnFacultyToCourse.setMinWidth(600);
		btnFacultyToCourse.setOnAction(e -> {
			Schedule.assign(faculty, courses, schedules);
		});
		pane.add(btnFacultyToCourse, 0, 7, 2, 1);

		Label lblReport = new Label("Generate Report");
		lblReport.setMinWidth(600);
		pane.add(lblReport, 0, 8, 2, 1);

		Button btnCIS = new Button("Courses Taught In <Semester>");
		btnCIS.setMinWidth(300);
		btnCIS.setOnAction(e -> {
			coursesInSemester();
		});
		pane.add(btnCIS, 0, 9);

		Button btnCTF = new Button("Courses Taught by <Faculty>");
		btnCTF.setMinWidth(300);
		btnCTF.setOnAction(e -> {
			coursesByFaculty();
		});
		pane.add(btnCTF, 1, 9);

		Button btnCSS = new Button("Courses Enrolled by <Student>");
		btnCSS.setMinWidth(300);
		btnCSS.setOnAction(e -> {
			coursesOfStudent();
		});
		pane.add(btnCSS, 0, 10);

		Button btnCAA = new Button("Students Enrolled in <Course>");
		btnCAA.setMinWidth(300);
		btnCAA.setOnAction(e -> {
			studentsInCourse();
		});
		pane.add(btnCAA, 1, 10);

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		semesters = new ArrayList<Semester>();
		students = new ArrayList<Student>();
		faculty = new ArrayList<Faculty>();
		courses = new ArrayList<Course>();
		schedules = new ArrayList<Schedule>();
		enrollments = new ArrayList<Enrollment>();
		launch();
	}

}