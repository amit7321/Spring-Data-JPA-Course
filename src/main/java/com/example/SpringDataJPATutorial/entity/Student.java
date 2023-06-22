package com.example.SpringDataJPATutorial.entity;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "fullname")
    private String name;
    public Student(String name) {
        this.name = name;
    }
    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;

    protected Student() {
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

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
