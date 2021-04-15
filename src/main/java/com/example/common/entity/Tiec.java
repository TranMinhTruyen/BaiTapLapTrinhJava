package com.example.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;


@Entity
@Table(name = "tiec")
public class Tiec implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @JsonProperty("ThoiGian")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    @Column(name = "THOIGIAN")
    private Time thoiGianBatDau;

    @JsonProperty("NgayToChuc")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "NGAYTOCHUC")
    private Date ngayBatDau;

    @JsonProperty("Loai")
    @Column(name = "LOAI")
    private String loai;

    @JsonProperty("Sanh")
    @ManyToOne()
    @JoinColumn(name = "ID_SANH", nullable = true)
    private Sanh sanh;

    @JsonProperty("ThongTinKhachHang")
    @ManyToOne()
    @JoinColumn(name = "ID_KHACHHANG", nullable = true)
    private KhachHang khachHang;

    @JsonProperty("TrangThai")
    @Column(name = "TRANGTHAI")
    private String trangThai;

    @JsonProperty("PhanHoi")
    @OneToMany(mappedBy="tiec", fetch = FetchType.LAZY)
    private List<PhanHoi> phanHoiList;

    @JsonProperty("CaLamViec")
    @ManyToOne()
    @JoinColumn(name = "ID_CALAMVIEC")
    private CaLamViec caLamViec;

    @JsonProperty("TenMenu")
    @ManyToOne()
    @JoinColumn(name = "ID_MENU")
    private Menu menu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Time thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public Sanh getSanh() {
        return sanh;
    }

    public void setSanh(Sanh sanh) {
        this.sanh = sanh;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public List<PhanHoi> getPhanHoiList() {
        return phanHoiList;
    }

    public void setPhanHoiList(List<PhanHoi> phanHoiList) {
        this.phanHoiList = phanHoiList;
    }

    public CaLamViec getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(CaLamViec caLamViec) {
        this.caLamViec = caLamViec;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
