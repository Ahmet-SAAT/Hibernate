package com.hb01.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {
        Student02 student1 = new Student02();
        student1.setId(1001);
        student1.setName("Ebu");
        student1.setGrade(75);

        Address address1 = new Address();
        address1.setStreet("Apple Street");
        address1.setCity("Van");
        address1.setContry("Turkey");
        address1.setZipCode("6555");

        student1.setAddress(address1);

        Address address2 = new Address();
        address2.setStreet("Orac Street");
        address2.setCity("Kars");
        address2.setContry("Turkey");
        address2.setZipCode("8555");

        Student02 student2 = new Student02();
        student2.setId(1002);
        student2.setName("Ali");
        student2.setGrade(90);
        student2.setAddress(address2);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student02.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        session.save(student1);
        session.save(student2);



        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
