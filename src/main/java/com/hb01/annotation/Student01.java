package com.hb01.annotation;

import javax.persistence.*;

@Entity//DB ye gider bu sinif db de bir tabloya karsilik gider.Kullanilmak zorundadir.
@Table(name = "t_student01")//dbde tablo ismini degistirebiliriz.Ihtiyaridir.dbde tablo olusturmassam class adi olur
//java kodu icinde bu clasa ulasirken Student01 ile sql ile ulasirken t_student01 ile cagirmam lazim
public class Student01 {
   @Id//primary key olmasini sagladim.idler artik unique olmali
   //kendinden sonra gelen ilk variable primary key olur.
   //@entity olan classda !Id de olmak zorundadir


   //@column olmasa da olur.Column ile kisisellestirme yapiyoruz.Kisitlamalar,isim verme vs
  // @Column(name="std_id")//ismi sql de degistirebiliriz.
   private int id;
   @Column(name="student_name",length = 100,nullable = false,unique = false)
    private String name;
    //@Transient//bu annotation variablenin DB de olusmasini engeller.Kendinden sonra ilk gelen tabi
    private int grade;
    /*
    @Lob//large object yani bu verinin boyutu buyuk diyoruz.
    private byte[] image;
    */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
