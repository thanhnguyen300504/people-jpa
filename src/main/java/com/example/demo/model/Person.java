package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Person")
@Table(name = "people")
public class Person {
    @Id
    @Column(
            nullable = false,
            unique = true
    )
    private Long id;

    @Column(nullable = false)
    private String firstName;

    public Person(Long id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
