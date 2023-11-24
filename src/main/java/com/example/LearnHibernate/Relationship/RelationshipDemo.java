package com.example.LearnHibernate.Relationship;

import net.sf.ehcache.search.expression.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.query.sql.internal.SQLQueryParser;

import java.sql.SQLData;
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

        NativeQuery query1 = session.createNativeQuery("SELECT * FROM Teacher");
        query1.addEntity(Teacher.class);
        List<Teacher> teacherList1 = query1.getResultList();

        NativeQuery query2 = session.createNativeQuery("SELECT id, name FROM Teacher");
        List<Object[]> teacherList2 = query2.getResultList();

        transaction.commit();
        session.close();

        System.out.println(teacher.getName());

        for (Teacher t : teacherList1) {
            System.out.println(t.getName());
        }

        for (Object[] o : teacherList2) {
            System.out.println(o[1]);
        }
    }
}
