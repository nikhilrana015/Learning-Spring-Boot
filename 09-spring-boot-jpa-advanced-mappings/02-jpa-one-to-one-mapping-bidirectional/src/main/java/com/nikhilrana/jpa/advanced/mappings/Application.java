package com.nikhilrana.jpa.advanced.mappings;

import com.nikhilrana.jpa.advanced.mappings.Dao.AppDao;
import com.nikhilrana.jpa.advanced.mappings.entity.Instructor;
import com.nikhilrana.jpa.advanced.mappings.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
			//createInstructor(appDao);
			//findInstructor(appDao, 1);
			//deleteInstructor(appDao, 3);
			//findInstructorDetail(appDao, 5);
			deleteInstructorDetail(appDao, 5);
		};
	}

	private void deleteInstructorDetail(AppDao appDao, int id) {
		System.out.println("Deleting the instructor detail of id: " + id);
		appDao.deleteInstructorDetailById(id);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDao appDao, int id) {

		InstructorDetail instructorDetail = appDao.findInstructorDetailById(id);
		System.out.println(instructorDetail.toString());
		System.out.println(instructorDetail.getInstructor().toString());
	}

	private void deleteInstructor(AppDao appDao, int id) {
		appDao.deleteInstructorById(id);
		return;
	}

	private void findInstructor(AppDao appDao, int id) {
		Instructor instructor = appDao.findInstructorById(id);
		System.out.println(instructor.toString());
	}

	private void createInstructor(AppDao appDao) {

		Instructor instructor = new Instructor("Nikhil", "Rana", "nikhil.XYZ@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail(
				"https://youtube.com/nikhil",
				"Luv to play cricket"
		);

		instructor.setInstructorDetail(instructorDetail);

		System.out.println(instructor.toString());
		System.out.println(instructorDetail.toString());

		appDao.save(instructor);

		System.out.println("Done");

	}

}
