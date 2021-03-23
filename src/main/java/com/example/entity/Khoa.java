package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "khoa")
public class Khoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy="khoa")
    private List<Student> listSV;

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

    public List<Student> getListSV() {
        return listSV;
    }

    public void setListSV(List<Student> listSV) {
        this.listSV = listSV;
    }
}
