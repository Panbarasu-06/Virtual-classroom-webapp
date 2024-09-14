package com.example.demo.model;

import jakarta.persistence.*;


@Entity
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "classroom_id") // Ensure this column matches the database schema
    private Classroom classEntity;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Classroom getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(Classroom classEntity) {
        this.classEntity = classEntity;
    }
}
