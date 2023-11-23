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
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(teacher);
        session.save(student);
        transaction.commit();

        Teacher teacher1 = session.get(Teacher.class, 1);
        Student student1 = session.get(Student.class, 1);

        System.out.println(teacher1.getName());

        // If below code is commented and FetchType is lazy, Join Statement or Associate Table would not be accessed
        for (Student s: teacher1.getStudents()){
            System.out.println(teacher1.getName() + " teaches " + s.getName());
        }

        for (Teacher t: student1.getTeachers()){
            System.out.println(t.getName() + " teaches " + student1.getName());
        }
    }
}
