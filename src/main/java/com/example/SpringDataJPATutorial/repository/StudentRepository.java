package com.example.SpringDataJPATutorial.repository;

import com.example.SpringDataJPATutorial.entity.Passport;
import com.example.SpringDataJPATutorial.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentRepository {
    @Autowired
    EntityManager entityManager;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }
    public void deleteById(Long id) {
        Student student = findById(id);
        entityManager.remove(student);
    }
    public Student save(Student student) {
        if(student.getId() == null) {
            entityManager.persist(student);
        }
        else {
            entityManager.merge(student);
        }
        return student;
    }
    public void playWithEntityManager() {
        logger.info("play with entity manager");
        Student student = new Student("kasem");
        entityManager.persist(student);

        Student student1 = new Student("nobin");
        entityManager.persist(student1);

        entityManager.flush();

        entityManager.refresh(student);
        entityManager.refresh(student1);
        //entityManager.clear();

        student.setName("helal - updated");
        //entityManager.flush();

        student1.setName("arnob - updated");
        //entityManager.flush();
    }
    public void saveStudentPassport() {
        Passport passport = new Passport("T4323");
        entityManager.persist(passport);

        Student student = new Student("Mike");
        student.setPassport(passport);
        entityManager.persist(student);
    }

}
