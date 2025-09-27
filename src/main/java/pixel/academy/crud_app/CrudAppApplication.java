package pixel.academy.crud_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud_app.dao.StudentDAO;
import pixel.academy.crud_app.entity.Student;

import java.util.List;

@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			// queryForStudents(studentDAO);

			queryForStudentsByLastName(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {

		// create an object of type Student
		System.out.println("Creating new student object ...");
		Student newStudent = new Student("Mircea", "Popescu", "mirceap@pixel.academy");

		// save the student in database
		System.out.println("Saving the student ...");
		studentDAO.save(newStudent);

		// display the id of saved student
		int theId = newStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// get student by Id (Primary Key)
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display details of the student
		System.out.println("Found the student: " + myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create object Student
		System.out.println("Creating new student object ...");
		Student newStudent = new Student("John", "Doe", "john@pixelacademy.md");

		// save object Student in DB using DAO
		System.out.println("Saving the student ...");
		studentDAO.save(newStudent);

		// display ID of saved student
		System.out.println("Saved student. Generated id: " + newStudent.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create more students
		System.out.println("Creating 3 student object ...");
		Student newStudent1 = new Student("Andrei", "Munteanu", "andrei@pixelacademy.md");
		Student newStudent2 = new Student("Iulian", "Vataman" , "iulic@pixelacademy.md");
		Student newStudent3 = new Student("Maria" , "Mirabela", "mira@pixelacademy.md");

		// save objects student in database
		System.out.println("Saving the students ...");
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// obtain / get students list
		List<Student> theStudents = studentDAO.findAll();

		// display students list
		for(Student newStudent : theStudents) {
			System.out.println(newStudent);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// return student list
		List<Student> theStudent = studentDAO.findNyLastName("Popescu");

		// display student list
		for (Student newStudent : theStudent) {
			System.out.println(newStudent);
		}
	}




}
