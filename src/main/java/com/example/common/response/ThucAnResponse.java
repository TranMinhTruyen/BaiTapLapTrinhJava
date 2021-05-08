package com.example.common.response;

public class ThucAnResponse {
    private Integer id;
    private String ten;
    private String loai;
    private String hinhAnh;

    public ThucAnResponse(Integer id, String ten, String loai, String hinhAnh) {
        this.id = id;
        this.ten = ten;
        this.loai = loai;
        this.hinhAnh = hinhAnh;
    }

    public ThucAnResponse(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
