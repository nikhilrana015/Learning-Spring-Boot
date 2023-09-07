package com.nikhilrana.cruddemo;

import com.nikhilrana.cruddemo.dao.StudentDao;
import com.nikhilrana.cruddemo.dao.StudentDaoImpl;
import com.nikhilrana.cruddemo.entity.Student;
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

	// This will executed after the creation of all beans
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			createStudent(studentDao);
			//findStudent(studentDao);
			//readAllStudents(studentDao);
			//findByLastName(studentDao);
			//updateStudent(studentDao);
			//removeStudent(studentDao);
			//removeAllStudents(studentDao);
		};
	}

	private void removeAllStudents(StudentDao studentDao) {
		System.out.println("Deleting all the students ...");
		int recordsDeleted = studentDao.deleteAll();
		System.out.println("No of records successfully deleted are: " + recordsDeleted);
	}

	private void removeStudent(StudentDao studentDao) {
		System.out.println("Removing student ... ");
		studentDao.delete(Integer.valueOf(3));
		System.out.println("Student deleted from the record");
	}

	private void updateStudent(StudentDao studentDao) {
		System.out.println("Finding the student ....");
		Student student = studentDao.findById(Integer.valueOf(2));
		System.out.println("Updating the student ....");
		student.setEmail("myCar@gmail.com");
		studentDao.update(student);
		System.out.println("Student updated");

	}

	private void readAllStudents(StudentDao studentDao) {
		System.out.println("Fetching the list of all students ...");
		List<Student> allStudents = studentDao.findAll();
		System.out.println("Students list are ...");
		for (Student student: allStudents) {
			System.out.println(student);
		}
	}

	private void findByLastName(StudentDao studentDao) {
		System.out.println("Finding the student with last-name " + "rana");
		List<Student>allStudents = studentDao.findByLastName("Rana");
		System.out.println("Students list are ...");
		for (Student student: allStudents) {
			System.out.println(student);
		}
	}

	private void findStudent(StudentDao studentDao) {
		System.out.println("Finding the student id: ");
		Student student = studentDao.findById(Integer.valueOf(3));
		System.out.println("Id of the student is: " + student);
	}


	private void createStudent(StudentDao studentDao) {
		System.out.println("Creating new student object ...");
		Student student = new Student("ajay", "sharma", "ajay.XYZ@gmail.com");
		System.out.println("Saving the student ...");
		studentDao.save(student);
		System.out.println("Saved the student. Id of student is: " + student.getId());
	}

}
