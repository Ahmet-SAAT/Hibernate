package com.hb06.unionetomany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book06 {

    @Id
    private Integer id;
    //id gibi degerlerde wrapper yazmak daha iyidir
    // Cunku int default 0 hatar exception olabilir.Integer ise null atar o da kaydedilmez.

    private  String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
