package com.example.SpringDataJPATutorial;

import com.example.SpringDataJPATutorial.entity.Course;
import com.example.SpringDataJPATutorial.repository.CourseRepository;
import com.example.SpringDataJPATutorial.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaTutorialApplication implements CommandLineRunner {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaTutorialApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Course course = courseRepository.findById(3L);
		logger.info("Course 1001{}", course);
		//courseRepository.deleteById(2l);
		courseRepository.save(new Course("dalal"));
		studentRepository.saveStudentPassport();
	}
}
