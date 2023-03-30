package com.hb09.Fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
      /*  2.taraf Many ise default olarak Lazy , One ise default olarak EAGER yapar :
        OneToMany       --> LAZY
        ManyToMany      --> LAZY
        OneToOne        --> EAGER
        ManyToOne       --> EAGER
        */

        Student09 std1=session.get(Student09.class,1001);//student onetomany oldugu icin default lazy
        System.out.println(std1.getBooklist());

        Book09 book=session.get(Book09.class,101);//book manytoone oldugu icin default eager
        System.out.println(book);

        for (Book09 book2: std1.getBooklist()){//book2ler student classindan allindigi icin lazy
            System.out.println(book2);
        }

        tx.commit();
        session.close();

        //bu arada sorgu yazdigimizda eager olsa sorun olmazdi ama lazy olsa yeniden dbye gitmesi gerektigi icin sorun olurdu.
        sf.close();



    }
}
