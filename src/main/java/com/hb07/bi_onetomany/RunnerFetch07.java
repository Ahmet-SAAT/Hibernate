package com.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch07 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student07 student = session.get(Student07.class, 1001);
        System.out.println(student);

// !!! SQL ile öğrenci bilgilerini ( Inner Join )  alalım ( öğrenci ismi ve kitap ismi )

// !!! yukardaki sorguyu HQL ile yazalım

        //delete islemi
        // !!! Delete islemi SQL
       /* String sqlQuery1 = "DELETE FROM book07";
        int numOfDeletedRecords = session.createSQLQuery(sqlQuery1).executeUpdate();
        System.out.println("Silinen kayit sayisi : " + numOfDeletedRecords);*/

        /*String sqlQuery2 = "DELETE FROM student07";
        int numOfDeletedRecords2 = session.createSQLQuery(sqlQuery2).executeUpdate();
        System.out.println("Silinen kayit sayisi : " + numOfDeletedRecords2);*/
     //hql ile delete islemi
      /*  String hql1 = "Delete from Book07";
        int updated1 = session.createSQLQuery(hql1).executeUpdate();
        System.out.println(updated1);*/

       /* String hql2 = "Delete from Student07";
        int updated2 = session.createSQLQuery(hql2).executeUpdate();
        System.out.println(updated2);*/
//kitap ismi aA book olan kitabi hql ile sil
     /*   String hql3="Delete from Book07 b where b.name='A Book'";
        int updated3=session.createQuery(hql3).executeUpdate();
        System.out.println(updated3);*/
//kitap bilgisi olan ogrencileri sil
        //1. yol once book tablosunda iliskili olanlar silinir sonra studenttakile
        //2.yol student classina cascade ya da orphenremoval

        //1001 idli student objesini silelim

        Student07 student2= session.get(Student07.class,1001);
       session.delete(student2);

        student2.getBookList().set(0,null);

        //// !!! book ismi içinde "Book" geçen student kayıtlarını alalım ( HQL )
        String hql4="Select s from Student07 s join s.booklist b where b.name like '%Book%'";
        List<Student07> resultlist4 =session.createQuery(hql4, Student07.class).getResultList();
        for ( Student07 std:resultlist4){
            System.out.println(std);
        }

        tx.commit();
        session.close();
        sf.close();


    }
}
