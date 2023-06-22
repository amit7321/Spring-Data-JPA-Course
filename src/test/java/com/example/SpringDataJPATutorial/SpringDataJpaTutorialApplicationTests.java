package com.example.SpringDataJPATutorial;

import com.example.SpringDataJPATutorial.entity.Course;
import com.example.SpringDataJPATutorial.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class SpringDataJpaTutorialApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Test
	public void findById_basic(Long id) {
		Course course = courseRepository.findById(1L);
		assertEquals("Jpa in 50 st steps", course.getName());
	}

	@Test
	@DirtiesContext
	public void deleteById_basic(){
		courseRepository.deleteById(1L);
		assertNull(courseRepository.findById(1L));
	}

	@Test
	@DirtiesContext
	public void save_basic() {
		Course course = courseRepository.findById(1L);
		assertEquals("Amit", course.getName());

		course.setName("kashem");
		courseRepository.save(course);

		Course course1 = courseRepository.findById(1L);
		assertEquals("kashem", course1.getName());
	}

	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		courseRepository.playWithEntityManager();
	}

}
