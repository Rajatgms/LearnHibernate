package com.example.LearnHibernate.LifeCycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AlienDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Alien transient State
        Alien alien = new Alien();
        alien.setId(101);
        alien.setName("Rajat");
        alien.setColor("Green");

        // Transaction 1
        Transaction transaction = session.beginTransaction();

        // Alien persistent State.
        session.save(alien);
        alien.setColor("Blue");
        transaction.commit();

        // Transaction 2
        transaction = session.beginTransaction();
        // Alien persistent state.
        alien.setColor("Pink");
        transaction.commit();

        // Transaction 3
        transaction = session.beginTransaction();
        // Alien detached state.
        session.detach(alien);
        alien.setColor("Red");

        transaction.commit();

//        // Transaction 4
//        transaction = session.beginTransaction();
//        // Alien detached state.
//        session.remove(alien);
//        alien.setColor("Red");
//
//        transaction.commit();

        alien = session.get(Alien.class, 101);
        Alien alienLoad = session.load(Alien.class, 101);

//        System.out.println(alien);
//        System.out.println(alienLoad);
    }
}
