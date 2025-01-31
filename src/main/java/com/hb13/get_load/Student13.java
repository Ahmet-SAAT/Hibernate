package com.hb13.get_load;

import javax.persistence.*;

@Entity
public class Student13 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="Student_name",nullable = false)
    private String name;

    private int mathGrade;

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int grade) {
        this.mathGrade = grade;
    }

    @Override
    public String toString() {
        return "Student13{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + mathGrade +
                '}';
    }
}
