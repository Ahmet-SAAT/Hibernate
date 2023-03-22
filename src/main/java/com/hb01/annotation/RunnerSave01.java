package com.hb01.annotation;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;//farkli configuratinlar var import ederken dikkat

public class RunnerSave01 {
    public static void main(String[] args) {
        Student01 student01 = new Student01();
        student01.setId(1001);
        student01.setName("Akin Yol");
        student01.setGrade(90);

        Student01 student02=new Student01();
        student02.setId(1002);
        student02.setName("Ahmet Saat");
        student02.setGrade(100);

        Student01 student03=new Student01();
        student03.setId(1003);
        student03.setName("Fatih Kul");
        student03.setGrade(80);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class);
//yukaridaki satirda hibernate e konfigurasyon dosyami ve Entity classimi bildirdim.
// Birden fazla entity class da bildirebilirim.
        //konfigurasyon dosyam resources icinde db bilgilerim var.Entity classim zaten Idede

        SessionFactory sF =con.buildSessionFactory();
         Session session =sF.openSession();


    Transaction tx =session.beginTransaction();
        //session.save(student01);
        //session.save(student02);
        session.save(student03);

        tx.commit();

    session.close();
    sF.close();

    }

}
