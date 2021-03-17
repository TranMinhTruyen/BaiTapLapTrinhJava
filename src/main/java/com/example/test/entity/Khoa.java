package com.example.test.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "khoa")
public class Khoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="khoa")
    private Set<Student> listSV;

    public Set<Student> getListSV() {
        return listSV;
    }

    public void setListSV(Set<Student> listSV) {
        this.listSV = listSV;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
