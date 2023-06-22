 package com.example.SpringDataJPATutorial;

import com.example.SpringDataJPATutorial.entity.Course;
import com.example.SpringDataJPATutorial.entity.Student;
import com.example.SpringDataJPATutorial.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;
	@Autowired
	StudentRepository studentRepository;

	@Test
	public void findById_basic() {
		Student student = entityManager.find(Student.class, 1);
		logger.info("Student -> {}", student);
	}

}
