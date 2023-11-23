package com.example.LearnHibernate;

import jakarta.persistence.*;

@Entity
//@Table(name="Alien_Table")
public class Alien {
    @Id
//    @GeneratedValue (strategy = GenerationType.IDENTITY)
//    @Column(nullable = false)
    private int id;

//    @Transient
    private AlienName name;

//    @Column(name = "Alien_Color")
    private String color;

    public Alien() {
    }

    public Alien(int id, AlienName name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AlienName getName() {
        return name;
    }

    public void setName(AlienName name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Alien{" + "id=" + id + ", name='" + name + ", color='" + color + '}';
    }
}
