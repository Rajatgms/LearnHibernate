package com.example.LearnHibernate.Relationship;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    private List<Teacher> teachers;

    public Student() {

    }

    public Student(String name, List<Teacher> teachers) {
        this.name = name;
        this.teachers = teachers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeacher(List<Teacher> teacher) {
        this.teachers = teachers;
    }
}
