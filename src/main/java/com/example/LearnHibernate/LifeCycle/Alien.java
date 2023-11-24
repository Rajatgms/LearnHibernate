package com.example.LearnHibernate.LifeCycle;

import com.example.LearnHibernate.Basic.AlienName;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
//@Table(name="Alien_Table")
public class Alien {
    @Id
//    @GeneratedValue (strategy = GenerationType.IDENTITY)
//    @Column(nullable = false)
    private int id;

//    @Transient
    private String name;

//    @Column(name = "Alien_Color")
    private String color;

    public Alien() {
    }

    public Alien(int id, String name, String color) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
