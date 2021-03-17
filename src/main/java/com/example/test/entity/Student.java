package com.example.test.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sinhvien")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mssv;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "gender")
    private String gender;

    @ManyToOne()
    @JoinColumn(name = "khoa_id")
    private Khoa khoa;

    public long getMssv() {
        return mssv;
    }

    public void setMssv(long mssv) {
        this.mssv = mssv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getKhoa() {
        return khoa.getName();
    }

    public void setKhoa(long khoa) {
        this.khoa.setId(khoa) ;
    }
}
