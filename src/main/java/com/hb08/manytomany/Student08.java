package com.hb08.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student08 {
    @Id
    private int id;
    @Column(name="student_name", nullable = false)
    private String name;
    private int grade;

    @ManyToMany
     @JoinTable(//tablo olusturuldu
             name="student08_book08",
             joinColumns = {@JoinColumn(name="std_id")},//icinde bulundugum classin idsi ile sutun olustu
             inverseJoinColumns = {@JoinColumn(name="book_id")}//diger classin idsi ile sutun olustu
     )
    //3. bir tablo olusturuyorum.Hem student hem book bilgisi tutacak
    private List<Book08> booklist=new ArrayList<>();

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

    public List<Book08> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<Book08> booklist) {
        this.booklist = booklist;
    }

    @Override
    public String toString() {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", booklist=" + booklist +
                '}';
    }
}
