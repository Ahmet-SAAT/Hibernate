package com.hb09.Fetchtypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student09 {
    @Id
    private  int id;

    private int grade;

    @Column(name="student_name",nullable = false)
    private String name;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL/*,fetch = FetchType.EAGER*/)
    private List<Book09> booklist=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book09> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<Book09> booklist) {
        this.booklist = booklist;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", grade=" + grade +
                ", name='" + name + '\'' +
                ", booklist=" + booklist ;
    }
}
