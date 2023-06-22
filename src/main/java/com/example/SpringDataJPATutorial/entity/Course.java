package com.example.SpringDataJPATutorial.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@NamedQueries(value = { @NamedQuery(name = "query_get_all_courses", query = "select c from Course c"),
        @NamedQuery(name = "query_get_100_step_courses", query = "select c from Course c where c.id=1")
})

public class Course {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "fullname")
    private String name;

    public  Course(String name) {
        this.name = name;
    }
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;

    @CreationTimestamp
    private LocalDateTime createdDate;


    protected Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
