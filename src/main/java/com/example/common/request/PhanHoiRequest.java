package com.example.common.request;

public class PhanHoiRequest {
    private int id;
    private String noiDung;
    private int idTiec;
    private int idKhachHang;

    public PhanHoiRequest() {
    }

    public PhanHoiRequest(int id, String noiDung, int idTiec, int idKhachHang) {
        this.id = id;
        this.noiDung = noiDung;
        this.idTiec = idTiec;
        this.idKhachHang = idKhachHang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getIdTiec() {
        return idTiec;
    }

    public void setIdTiec(int idTiec) {
        this.idTiec = idTiec;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }
}
