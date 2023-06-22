package com.example.SpringDataJPATutorial;

import com.example.SpringDataJPATutorial.entity.Course;
import com.example.SpringDataJPATutorial.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class JPQLTests {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;

	@Test
	public void findById_basic() {
		List resultList = entityManager.createNamedQuery("query_get_all_courses").getResultList();
		logger.info("SELECT c from course c -> {}", resultList);
	}

	@Test
	public void findById_typed() {
		TypedQuery<Course> query = entityManager.createNamedQuery("query_get_100_step_courses", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("SELECT c from course c -> {}", resultList);
	}

}
