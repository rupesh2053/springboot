package com.rupesh.app;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rupesh.app.beans.Student;
import com.rupesh.app.service.StudentService;

@SpringBootApplication
public class SpringBootSmsThymeleafCrudAppApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSmsThymeleafCrudAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//createStudents();
	}

	private void createStudents() {
		studentService.createStudents(Arrays.asList(
				new Student("Rupesh Dulal", "dulalrupesh76.cs@gmail.com", "BCA"),
				new Student("Akash Gurung", "gurungakash98.cs@gmail.com", "BCA"),
				new Student("Pasang Theeng","theengpasang87.cs@gmail.com","BCA"),
				new Student("Manoj Ghimire","GhimireManoj087.cs@gmail.com","BCA")
			));
	}

}
