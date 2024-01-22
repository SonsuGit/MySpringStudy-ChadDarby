package com.suha.cruddemo;

import com.suha.cruddemo.dao.StudentDAO;
import com.suha.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// 파라미터에 String[] args를 넣으라 했지만 넣으면 오류
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudent(studentDAO);
			// queryForStudentByLastname(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted rows count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentID = 3;
		System.out.println("Deleting student id: "+ studentID);
		studentDAO.delete(studentID);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retreive student based on the id: pk
		int studentID = 1;
		System.out.println("Getting student with id: " + studentID);
		Student myStudent = studentDAO.findById(studentID);

		// change first name to "Scooby"
		System.out.println("Updating student...");
		myStudent.setFirstName("Scooby");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentByLastname(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudent = studentDAO.findByLastName("park");
		// display list of students
		for(Student tempStudent: theStudent){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		// get a list of student
		List<Student> theStudent = studentDAO.findAll();

		// display list of student
		for(Student tempStudent: theStudent){
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daft", "Punk", "email@email.com");

		// save the student
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("id of student: " + tempStudent.getId());

		// retrieve student based on the id: primary key
		System.out.println("Retreving student with id " + tempStudent.getId());
		Student myStudent = studentDAO.findById(tempStudent.getId());

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating 3 student object ...");
		Student tempStudent1 = new Student("Suha", "Son", "blahblah@gmail.com");
		Student tempStudent2 = new Student("hasu", "park", "hasupark@naver.com");
		Student tempStudent3 = new Student("doja", "cat", "doja@gmail.com");

		// save the student objects
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3 );
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Suha", "Son", "blahblah@gmail.com");

		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: "+ tempStudent.getId());
	}

}
