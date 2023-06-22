package com.example.SpringDataJPATutorial.repository;

import com.example.SpringDataJPATutorial.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseRepository {
    @Autowired
    EntityManager entityManager;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }
    public void deleteById(Long id){
        Course course = findById(id);
        entityManager.remove(course);
    }
    public Course save(Course course) {
        if(course.getId() == null) {
            entityManager.persist(course);
        }
        else {
            entityManager.merge(course);
        }
        return course;
    }
    public void playWithEntityManager() {
        logger.info("play with entity manager");
        Course course = new Course("kasem");
        entityManager.persist(course);

        Course course1 = new Course("nobin");
        entityManager.persist(course1);

        entityManager.flush();

        entityManager.refresh(course);
        entityManager.refresh(course1);
        //entityManager.clear();

        course.setName("helal - updated");
        //entityManager.flush();

        course1.setName("arnob - updated");
        //entityManager.flush();


    }

}
