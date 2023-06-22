package com.example.SpringDataJPATutorial;


import com.example.SpringDataJPATutorial.entity.Course;
import com.example.SpringDataJPATutorial.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
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
public class NativeQueriesTests {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    public void nativeQueriesBasic() {
        Query query = entityManager.createNativeQuery("select * from Course", Course.class);
        List resultList = query.getResultList();
        logger.info("SELECT c from course c -> {}", resultList);
    }

    @Test
    public void nativeQueriesBasicWithParameter() {
        Query query = entityManager.createNativeQuery("select * from Course where id = :id", Course.class);
        query.setParameter("id", 10001l);
        List resultList = query.getResultList();
        logger.info("SELECT c from course c -> {}", resultList);
    }

    @Test
    @Transactional
    public void nativeQueriesBasicUpdate() {
        Query query = entityManager.createNativeQuery("update Course set last_updated_date =  sysdate()", Course.class);
        int noOfRowsUpdated = query.executeUpdate();
        logger.info("SELECT c from course c -> {}", noOfRowsUpdated);
    }

}
