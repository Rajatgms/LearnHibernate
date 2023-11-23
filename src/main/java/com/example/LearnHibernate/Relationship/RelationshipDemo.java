package com.example.LearnHibernate.Relationship;

import com.example.LearnHibernate.Basic.Alien;
import com.example.LearnHibernate.Basic.AlienName;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RelationshipDemo {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Daniel Peter", null);
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher);

        Student student = new Student("Rajat Sharma", teachers);

        List<Student> students = new ArrayList<>();
        students.add(student);
        teacher.setStudents(students);

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Teacher.class).addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Teacher teacher1 = null;

        Session session1 = sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();
        session1.save(teacher);
        session1.save(student);
        transaction1.commit();

        // Session 1 get Teacher 1 detail
        teacher1 = session1.get(Teacher.class, 1);
//        session1.close();

        Session session2 = sessionFactory.openSession();
        Transaction transaction2 = session2.beginTransaction();

        // Session 2 get Teacher 1 detail
        teacher1 = session2.get(Teacher.class, 1);
        transaction2.commit();

        Session session3 = sessionFactory.openSession();
        Transaction transaction3 = session2.beginTransaction();

        // Session 3 two time get Teacher 1 detail
        teacher1 = session3.get(Teacher.class, 1);
        teacher1 = session3.get(Teacher.class, 1);
        transaction2.commit();

        System.out.println(teacher1.getName());
    }
}
