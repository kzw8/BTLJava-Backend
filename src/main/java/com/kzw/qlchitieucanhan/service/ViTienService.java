package com.kzw.qlchitieucanhan.service;

import com.kzw.qlchitieucanhan.model.ViTien;

import java.util.List;

public interface ViTienService {
    List<ViTien> getAll();
    ViTien getById(Integer id);
    ViTien create(ViTien viTien);
    ViTien update(Integer id, ViTien viTien);
    void delete(Integer id);
    List<ViTien> getByMaNguoiDung(Integer maNguoiDung);
}
