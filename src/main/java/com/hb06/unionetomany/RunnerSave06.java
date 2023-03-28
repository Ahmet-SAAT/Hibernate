package com.hb06.unionetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave06 {
    public static void main(String[] args) {
        Student06 student1=new Student06();
        student1.setId(1001);
        student1.setName("Fatih");
        student1.setGrade(65);

        Student06 student2=new Student06();
        student2.setId(1002);
        student2.setName("Cemil");
        student2.setGrade(75);

        Student06 student3=new Student06();
        student3.setId(1003);
        student3.setName("Ahmet");
        student3.setGrade(90);

        Book06 book1=new Book06();
        book1.setId(101);
        book1.setName("Math");

        Book06 book2=new Book06();
        book2.setId(102);
        book2.setName("Art");

        Book06 book3=new Book06();
        book3.setId(103);
        book3.setName("Law");

        student1.getBooklist().add(book1);
        student2.getBooklist().add(book2);
        student3.getBooklist().add(book3);

        Configuration con=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);
          SessionFactory sf =con.buildSessionFactory();
          Session session =sf.openSession();
          Transaction tx =session.beginTransaction();
          session.save(book1);
          session.save(book2);
          session.save(book3);

          session.save(student1);
          session.save(student2);
          session.save(student3);


          tx.commit();
          session.close();
          sf.close();

    }
}
