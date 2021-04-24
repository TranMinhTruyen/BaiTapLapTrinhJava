package com.example.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "thucan")
@JsonPropertyOrder({
        "id",
        "ten",
        "loai",
        "hinhAnh",
})
public class ThucAn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "TEN")
    private String ten;

    @JsonProperty("loai")
    @Column(name = "LOAI")
    private String loai;

    @JsonProperty("hinh_anh")
    @Column(name = "HINH_ANH")
    private String hinhAnh;

    @OneToMany(mappedBy = "thucAn", fetch = FetchType.LAZY)
    private List<MenuThucAn> menuthucAns = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public List<MenuThucAn> getMenuthucAns() {
        return menuthucAns;
    }

    public void setMenuthucAns(List<MenuThucAn> menuthucAns) {
        this.menuthucAns = menuthucAns;
    }
}
