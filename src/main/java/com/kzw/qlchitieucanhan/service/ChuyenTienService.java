package com.kzw.qlchitieucanhan.service;

import com.kzw.qlchitieucanhan.model.ChuyenTien;

import java.util.List;

public interface ChuyenTienService {
    List<ChuyenTien> getAll();
    ChuyenTien getById(Integer id);
    ChuyenTien create(ChuyenTien chuyenTien);
    ChuyenTien update(Integer id, ChuyenTien chuyenTien);
    void delete(Integer id);
    List<ChuyenTien> getByMaNguoiDung(Integer maNguoiDung);
}
