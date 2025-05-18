package com.kzw.qlchitieucanhan.repository;

import com.kzw.qlchitieucanhan.model.ViTien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViTienRepository extends JpaRepository<ViTien, Integer> {

    // Lấy danh sách ví theo mã người dùng
    List<ViTien> findByMaNguoiDung(Integer maNguoiDung);
}
