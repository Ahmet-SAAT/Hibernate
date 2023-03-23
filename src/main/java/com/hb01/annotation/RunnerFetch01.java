package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch01 {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        SessionFactory sF = con.buildSessionFactory();
        Session session = sF.openSession();
        Transaction tx = session.beginTransaction();
/*
       --DB`den bilgi almanin 3 yolu var
       1-get()
       2-SQL
       3-HQL
 */
/*
        //1.YOL get()*****************************************
        //her runda DB ye gider memoryi yorabilir.Ama onun da cozumu var.
        Student01 student1 = session.get(Student01.class, 1001);
        System.out.println(student1);*/
/*

        //2.YOL SQL*************************************
        String sqlQuery = "Select * from t_student01";
        List<Object[]> resultlist = session.createSQLQuery(sqlQuery).getResultList();
        for (Object[] w : resultlist) {
            System.out.println(Arrays.toString(w));
        }
*/

//3.YOL HQL************************************
        //trick HQL fromdan sonra java sinif ismi kullanilmalidir.
        String hqlQuery = "from Student01";
        List<Student01> resultlist2 = session.createQuery(hqlQuery, Student01.class).getResultList();
        for (Student01 student01 : resultlist2) {
            System.out.println(student01);
        }
/*
            **********Yukaridaki 3 methodu kiyaslayalim.**********8
        1--ucude ayni isi yapiyorsa 1.yol daha iyidir.Cunku methodlarla calisir ve cte verir.
           -Digerleri string bir query ile calistigi icin rte ihtimali fazladir.
        2--1.yoldaki methodlar isimizi gormuyorsa HQL ile calismaliyiz.Nicin SQL degil ?
           --Sql firmasi degisirse kod patlayabilir.HQL de ortak kodlar vardir.
        3--SQL en son care olarak kullanilmalidir.
        */

        //-Donecek kaydin tek bir tane oldugundan eminsen uniqueResult methodum var.Kullanilabilir.
        //SQL
        // String sqlQuery2 = "select from t_student01 where student_name='Ahmet Saat'";
        //   Object[] uniqueResult1 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
        // System.out.println(Arrays.toString(uniqueResult1));

        //HQL ile
        String hqLQuery2 = "from Student01 where name='Fatih Kul'";
        Student01 student01 = session.createQuery(hqLQuery2, Student01.class).uniqueResult();
        System.out.println(student01);

        //Yukaridaki sorguyu hql alias kullanarak yapalim
        String hqlQuery3 = "From Student01 std where std.name='Ahmet Saat'";
        Student01 Result = session.createQuery(hqlQuery3, Student01.class).uniqueResult();
        System.out.println(Result);


        // !!! HQL ile grade degeri 90 olan ogrenciyi getirelim
        String hqlQuery4 = "From Student01 std where std.grade=90";
        List<Student01> Result2 = session.createQuery(hqlQuery4, Student01.class).getResultList();
        System.out.println(Result2);
        //2.yol
        String hqlQuery5 = "SELECT s.id, s.name FROM Student01 s WHERE s.grade=90";
        List<Object[]> resultList5 = session.createQuery(hqlQuery5).getResultList();
        for (Object[] object : resultList5) {
            System.out.println(Arrays.toString(object));


            tx.commit();

            session.close();
            sF.close();

        }
    }
}
