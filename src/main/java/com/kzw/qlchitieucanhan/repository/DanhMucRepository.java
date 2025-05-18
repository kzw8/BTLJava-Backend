package com.kzw.qlchitieucanhan.repository;

import com.kzw.qlchitieucanhan.model.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DanhMucRepository extends JpaRepository<DanhMuc, Integer> {
    List<DanhMuc> findByLoaiIgnoreCaseAndMaNguoiDung(String loai, Integer maNguoiDung);

    Optional<DanhMuc> findByTenDanhMucIgnoreCaseAndLoaiIgnoreCaseAndMaNguoiDung(String tenDanhMuc, String loai, Integer maNguoiDung);
}
