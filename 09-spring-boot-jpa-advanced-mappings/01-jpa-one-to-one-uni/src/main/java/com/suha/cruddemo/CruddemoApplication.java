package com.suha.cruddemo;

import com.suha.cruddemo.dao.AppDAO;
import com.suha.cruddemo.entity.Instructor;
import com.suha.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner -> {
			// createInstructor(appDAO);

			// findInstructor(appDAO);
			
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id: "+ theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetail only: "+ tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		/*
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Suha", "Son", "BlahBlah@mail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("https://www.youtube.com", "soccer");
		 */

		// create the instructor
		Instructor tempInstructor =
				new Instructor("johns", "debby", "carabian@mail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("https://www.ships.com", "sailing");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE: this will ALSO save the details obejct
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
}
