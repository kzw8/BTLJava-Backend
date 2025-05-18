package com.kzw.qlchitieucanhan.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "GiaoDich")
public class GiaoDich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaGiaoDich")
    private Long id;

    @Column(name = "MaNguoiDung")
    private Integer maNguoiDung;

    @Column(name = "MaVi")
    private Integer maVi;

    @Column(name = "MaDanhMuc")
    private Integer maDanhMuc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "MaDanhMuc",
            insertable = false,
            updatable = false
    )
    private DanhMuc danhMuc;

    @Column(name = "SoTien")
    private Integer soTien;

    @Column(name = "Loai")
    private String loai;  // "thu" hoặc "chi"

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "NgayGiaoDich")
    private LocalDate ngayGiaoDich;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Transient
    private String tenDanhMuc;

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    // ===== Getters và Setters =====
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(Integer maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public Integer getMaVi() {
        return maVi;
    }

    public void setMaVi(Integer maVi) {
        this.maVi = maVi;
    }

    public Integer getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(Integer maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public Integer getSoTien() {
        return soTien;
    }

    public void setSoTien(Integer soTien) {
        this.soTien = soTien;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public LocalDate getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(LocalDate ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }
}
