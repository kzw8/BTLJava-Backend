package com.kzw.qlchitieucanhan.repository;

import com.kzw.qlchitieucanhan.model.ChuyenTien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChuyenTienRepository extends JpaRepository<ChuyenTien, Integer> {

    // Lấy danh sách chuyển tiền theo mã người dùng
    List<ChuyenTien> findByMaNguoiDung(Integer maNguoiDung);
}
