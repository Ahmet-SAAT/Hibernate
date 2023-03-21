package com.hb01.annotation;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity//DB ye gider bu sinif db de bir tabloya karsilik gider.Kullnilmak zorundadir.
@Table(name = "t_student01")//dbde tablo ismini degistirebiliriz.Ihtiyaridir.dbde tablo olusturmassam class adi olur

public class Student01 {

    private int id;
    private String name;
    private int grade;

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
}
