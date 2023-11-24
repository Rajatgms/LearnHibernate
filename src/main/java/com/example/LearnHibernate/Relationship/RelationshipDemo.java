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

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(teacher);
        session.save(student);

        Query query = session.createQuery("FROM Teacher WHERE id=1");
        teacher = (Teacher) query.uniqueResult();

        Query listQuery = session.createQuery("FROM Teacher");
        List<Teacher> teacherList = listQuery.list();

        Query listNameQuery = session.createQuery("SELECT name FROM Teacher");
        List<String> teacherNames = listNameQuery.list();

        Query listIDNameQuery = session.createQuery("SELECT id, name FROM Teacher");
        List<Object[]> teacherIDNames = listIDNameQuery.list();


        Query listInputQuery = session.createQuery("SELECT id, name FROM Teacher t WHERE t.id =:id");
        listInputQuery.setParameter("id", 1);

        List<Object[]> teacherWithInput = listInputQuery.list();


        transaction.commit();
        session.close();

        System.out.println(teacher.getName());

        for (Teacher t: teacherList) {
            System.out.println(t.getName());
        }

        for (String tName: teacherNames) {
            System.out.println(tName);
        }

        for (Object[] tIdName: teacherIDNames) {
            System.out.println(tIdName[1]);
        }

        for (Object[] tIdName: teacherWithInput) {
            System.out.println(tIdName[1]);
        }

    }
}
