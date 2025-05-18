package com.kzw.qlchitieucanhan.dto;

import java.time.LocalDate;

public class GiaoDichFilterDTO {

    private String loai;             // "thu" hoặc "chi"
    private String moTa;             // từ khóa ghi chú
    private LocalDate fromDate;      // từ ngày
    private LocalDate toDate;        // đến ngày
    private Integer minSoTien;       // từ số tiền
    private Integer maxSoTien;       // đến số tiền
    private Integer maDanhMuc;       // mã danh mục
    private Integer maNguoiDung;     // mã người dùng

    public GiaoDichFilterDTO() {
        // default constructor
    }

    // === Getters & Setters ===

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

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Integer getMinSoTien() {
        return minSoTien;
    }

    public void setMinSoTien(Integer minSoTien) {
        this.minSoTien = minSoTien;
    }

    public Integer getMaxSoTien() {
        return maxSoTien;
    }

    public void setMaxSoTien(Integer maxSoTien) {
        this.maxSoTien = maxSoTien;
    }

    public Integer getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(Integer maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public Integer getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(Integer maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }
}
