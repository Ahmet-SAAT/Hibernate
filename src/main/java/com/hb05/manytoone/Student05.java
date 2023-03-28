package com.hb05.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Student05 {

    @Id
    private int id;

    @Column(name="std_name",nullable = false)
    private String name;

    private int grade;

    private LocalDateTime creation;//databaseye kayit tarihini tutmak istiyorum.Persist edilme zamanini istiyorum
    //Asagida @PrePersist annotation ile buna yaptik.Obje session.save edildiginde DByekaydedildigi anda bu prepersist calisir.
    //Sonra altindaki method calisir.

     @ManyToOne
     @JoinColumn
     private University university;

     @PrePersist //student objesinin persist(kalici) edilme zamanini cretion degiskenine atiyoruz.
    public void prePesist(){
         creation=LocalDateTime.now();
     }

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

    public LocalDateTime getCreation() {
        return creation;
    }

   /* public void setCreation(LocalDateTime creation) {
        this.creation = creation;
    }*/

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", creation=" + creation +
                ", university=" + university +
                '}';
    }
}
