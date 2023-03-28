package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RunnerFetch04 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
      //belli idli bir student alalim
        Student04 student =session.get(Student04.class,1001);
        //diary getirelim
        Diary04 diary=session.get(Diary04.class,101);
        System.out.println(student);
        System.out.println("*******************");
        System.out.println(diary);//diaryde student gozukmeyecek tostringde sildim ve steakoverflows hatasini iptal ettim.

        System.out.println("Diary uzerinden student objesine ulasalim"+ diary.getStudent());
        System.out.println("************************************");
        System.out.println("Student uzerinde diary objesine ulasalim " + student.getDiary());
        //mappedBy in katkisi burada.Student Tablosunda diary columu yok ama javada cagirabiliyoruz.

        //!!!TAK : Kesisim kumesini getirelim()
        String hqlQuery="select s.name,d.name from Student04 s inner join fetch Diary04 d on s.id=d.student";
        //hql de sqlden farkli oarak bazen joinler ile fetch kullaniriz.
        //on dan sonraki esitleme de d.student a dikkat et.O fkdir.Student.id yazsak da olur.Ama gerek yok.
        List<Object[]> resultList =session.createQuery(hqlQuery).getResultList();//mapleme yapamadik
        // cunku 2 farkli sinif var.Hangisini yapacagiz
        for (Object[] object:resultList){
            System.out.println(Arrays.toString(object));
        }
       //lambda ile
//        resultList.forEach(t->{
//            System.out.println(Arrays.toString(t));
//        });

        //hql ile left join yapalim
        String hql2="select s.name,d.name from Student04 s righ join fetch Diary04 d on s.id=d.student";
        //hem soldaki student classinin hepsin hepte bu classta diary varsa onlari da getir.Iki class join
        List<Object[]> resultList2 =session.createQuery(hql2).getResultList();
        resultList2.forEach(t->{
           System.out.println(Arrays.toString(t));
        });

       //Butun gunlukler ve varsa gunlugu olan ogrenciler gesin
        String hql3="select s.name,d.name from Student04 s righ join fetch Diary04 d on s.id=d.student";
        List<Object[]> resultList3=session.createQuery(hql3).getResultList();
        resultList3.forEach(oa->{
            System.out.println(Arrays.toString(oa));
        });
//Butun student ce diary bilgilerini getirin
        String hql4="select s.name,d.name from Student04 s full join fetch Diary04 d on s.id=d.student";
        List<Object[]> resultList4=session.createQuery(hql4).getResultList();
        resultList4.forEach(oa->{
            System.out.println(Arrays.toString(oa));
        });


        tx.commit();
        session.close();
        sf.close();


    }
}
