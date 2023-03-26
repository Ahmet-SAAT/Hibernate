package com.hb03.uni_onetoone;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

//Embadabble ile onetoone da ki fark yeni tablo olusumunudur.Embedablede bir entity ve bir tablo vardir.
//Onetoone da iki entity ve 2 tablo vardi.Tablonun birine joincolumn ile fk eklenir.
//Hibernate kullaniliyorsa her toplada pk olmak zorundadir.SL de zorunlu degildi.
@Entity
public class Diary {

    @Id
    private int id;

    private String name;

    @OneToOne
    @JoinColumn(name="std_id")//std_id adinda bir column olusturur.Bu fkdir.
    private Student03 student; // name yazmasak fk student_id olurdu

        // !!! Getter-Setter

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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

        //!!! toString()

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}