package com.hb04.bi_onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student04 {
   @Id
    private  int id;

   @Column(name="std_name")
   private  String name;

   private  int grade;

   @OneToOne(mappedBy = "student")//student objesine sahip olan tarafda fk olussun.Bu classdabir column olusmaz ama
   //bu classtanda diger classa ulasabilir.Fakat set yapacaksak bu classin objesinden yaparsak fk null verebilir.
   //Setleme yapacaksak fk olan clasin objesinden yapmaliyiz.Bu classin objesinden set yapilmamalidir.
   //Cunku sql de bu classin icin bir column olusmuyor.Onu goremiyor.
   //Javada olusan sutun sql de olusmuyor.Bu classin objesi ile javada get yapabiliriz o zaman.
   //MappedBy yapmasaydim bu classda da bir column olustururdu.Bu sefer iki clasdandan setleme yapmak zorunda kalirdik.
   // sadece diary tablosunda iliski icin yeni bir column olusmasini sagliyoruz
   //yani student objesi hangi clasdaysa orada column olusturuyoruz.column istedigimiz classa joincolumn ekleriz.
   //Bu classda column olusmasini engeller ama bu tablodan da diger tabloya ulasabilirz artik.
   private Diary04 diary;//tabloda diary diye bir column yok ama obje.getdiary artik diyebiliriz.
    //iki taraftanda tablolara ulasabildigimiz icin bu iliskiye bi-direction onetoone denir.


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

    public Diary04 getDiary() {
        return diary;
    }

    public void setDiary(Diary04 diary) {
        this.diary = diary;
    }

    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", diary=" + diary +
                '}';
    }
}
