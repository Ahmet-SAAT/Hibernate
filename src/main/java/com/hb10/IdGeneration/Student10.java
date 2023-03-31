package com.hb10.IdGeneration;


import javax.persistence.*;

@Entity
public class Student10 {
  /*  Oracle DB - PostgreSQL ---> Sequence ( kontrolü developera bırakır, Id üretilirken
         başlangıç değeri veya kaç tane id cachelenecek bu gibi bilgileri developer setliyebilir)
    MySQL - Microsoft SQL   ---> IDENTITY ( kontrol DB de , kendi yapısına göre ıd oluşturur,
                                            içlerindeki en basitidir)
    GenerationType.AUTO ---> Hibernate otomatik olarak kullanilan DB ye gore stratejiyi belirler
    GenerationType.TABLE ---> En yavaşı , oyüzden çok kullanılmıyor, çünkü id
    üretmek için ekstra tablo oluşturuyor*/




   @GeneratedValue(generator ="sequence",strategy= GenerationType.SEQUENCE)//id tipini belirledik
   @SequenceGenerator(name = "sequence",//ayni ismi yukarida generator kismina yazmaliyiz
   sequenceName="student_seq",//db de olusacak olan sequence ismi
           initialValue = 1000,//baslamadegeri
           allocationSize = 10//casleme mekanzmasinda 10 adet id hazir bekletilsin
   )
    @Id
    private int id;
    @Column(name = "student_name", nullable = false)
    private String name;
    private int grade;

    // !!! gETTER-sETTER
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    // !!! ToString()
    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}