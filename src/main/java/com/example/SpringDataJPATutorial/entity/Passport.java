package com.example.SpringDataJPATutorial.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Passport {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String number;

    public Passport(String number) {
        this.number = number;
    }

    protected Passport() {
    }

    public String getName() {
        return number;
    }

    public void setName(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
