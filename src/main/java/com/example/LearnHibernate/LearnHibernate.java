package com.example.LearnHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LearnHibernate {
    public static void main(String[] args) {
        Alien alien = new Alien();
        alien.setId(101);
        alien.setName(new AlienName("Rajat", "", "Sharma"));
        alien.setColor("Green");

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(alien);
        alien = (Alien) session.get(Alien.class, 101);
        transaction.commit();

        System.out.println(alien);
    }
}
