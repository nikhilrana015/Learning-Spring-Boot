package com.nikhilrana.jpa.advanced.mappings;

import com.nikhilrana.jpa.advanced.mappings.Dao.AppDao;
import com.nikhilrana.jpa.advanced.mappings.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
			findCourseAndReview(appDao, 10);
		};
	}

	private void findCourseAndReview(AppDao appDao, int id) {

		Course course = appDao.findCourseAndReviewsByCourseId(id);
		System.out.println(course);
	}

	private void createCourseAndReviews(AppDao appDao) {

		// creating the course
		Course course = new Course("Golang Bootcamp");

		// adding the reviews
		course.addReview(new Review("Wonderful and detailed course"));
		course.addReview(new Review("Detailed explaination"));
		course.addReview(new Review("Great course... loved it!"));



		appDao.save(course);

	}

	private void deleteCourse(AppDao appDao, int id) {
		System.out.println("Deleting the course with id: " + id);
		appDao.deleteCourseById(id);
		System.out.println("Done");
	}

	private void updateCourse(AppDao appDao, int id) {

		Course course = appDao.findCourseById(id);
		course.setTitle("Python Bootcamp");

		appDao.update(course);
	}

	private void updateInstructor(AppDao appDao, int id) {

		System.out.println("Finding the instructor");
		Instructor instructor = appDao.findInstructorById(id);

		System.out.println("Updating the instructor");
		instructor.setEmail("nikhil.rana@outlook.com");

		appDao.update(instructor);

		System.out.println("Done");
	}

	private void findInstructorWithCoursesUsingJoinFetch(AppDao appDao, int id) {

		Instructor instructor = appDao.findInstructorWithCoursesUsingJoinFetch(id);
		System.out.println(instructor);
	}

	private void findInstructorWithCourses(AppDao appDao, int id) {

		// Fetching the instructor with id
		Instructor instructor = appDao.findInstructorById(id);

//		if(instructor.getCourses()==null || instructor.getCourses().size()==0)
//			System.out.println("Null");
//		else
//			System.out.println("Null nhi hai");

		// Fetching the courses with instructor id
		List<Course>courses = appDao.findCoursesWithInstructorId(id);

		instructor.setCourses(courses);

		System.out.println("Instructor: \n" + instructor);
		System.out.println("Courses: \n" + instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDao appDao) {

		// creating the instructor
		System.out.println("Creating the instructor");
		Instructor instructor = new Instructor("Nikhil", "Rana", "nikhil.XYZ@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail(
				"https://youtube.com/nikhil",
				"Luv to play cricket"
		);

		instructor.setInstructorDetail(instructorDetail);

		// creating the courses
		System.out.println("Creating the courses");
		Course course_1 = new Course("Java-The Ultimate Guide");
		Course course_2 = new Course("Docker and Kubernetes");

		instructor.add(course_1);
		instructor.add(course_2);

		// saving the instructor and courses
		System.out.println("Instructor: " + instructor);
		System.out.println("Courses are: \n" + instructor.getCourses());

		appDao.save(instructor);

		System.out.println("Save the instructor");


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
