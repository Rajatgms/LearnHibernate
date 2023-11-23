package com.example.LearnHibernate.Relationship;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
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

        Query query1 = session1.createQuery("FROM Teacher WHERE id=1");
        query1.setCacheable(true);
        teacher1 = (Teacher) query1.uniqueResult();

        transaction1.commit();
        session1.close();

        Session session2 = sessionFactory.openSession();
        Transaction transaction2 = session1.beginTransaction();

        Query query2 = session1.createQuery("FROM Teacher WHERE id=1");
        query2.setCacheable(true);
        teacher1 = (Teacher) query2.uniqueResult();
        
        transaction2.commit();
        session2.close();

        System.out.println(teacher1.getName());

    }
}
