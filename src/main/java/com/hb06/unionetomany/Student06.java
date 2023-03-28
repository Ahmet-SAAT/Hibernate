package com.hb06.unionetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student06 {

    @Id
private int id;

    @Column(name="student_name",nullable = false)
    private  String name;

    private int grade;

    @OneToMany
    @JoinColumn
    private List<Book06> booklist=new ArrayList<>();
//iliskiyi buraya kurdum.Setleme de burada yapilir.
    //Dogru ilsiki bakimindan DB de fk Book06 classinda olmaliydi yapmadim.Hibernate DB de fk yi book06 ya ekler.
    //Ama java da iliskiyi student06dan kurar setlemeyi buradan yaparim.

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

    public List<Book06> getBooklist() {
        return booklist;
    }

  /*  public void setBooklist(List<Book06> booklist) {
        this.booklist = booklist;
    }*/

    @Override
    public String toString() {
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", booklist=" + booklist +
                '}';
    }
}
