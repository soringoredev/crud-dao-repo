package pixel.academy.crud_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud_app.dao.StudentDAO;
import pixel.academy.crud_app.entity.Student;

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
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {

		// create an object of type Student

		// save the student in database

		// display the id of saved student

		// get student by Id (Primary Key)

		// display details of the student
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



}
