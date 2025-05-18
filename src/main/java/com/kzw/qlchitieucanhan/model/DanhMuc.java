package com.kzw.qlchitieucanhan.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "DanhMuc")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DanhMuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDanhMuc")
    private Integer maDanhMuc;

    @Column(name = "TenDanhMuc")
    private String tenDanhMuc;

    @Column(name = "Loai")  // "thu" hoặc "chi"
    private String loai;
    @Column(name = "MaNguoiDung")
    private Integer maNguoiDung;

    public Integer getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(Integer maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    // ==== GETTERS & SETTERS ====
    public Integer getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(Integer maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

}
