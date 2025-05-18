package com.kzw.qlchitieucanhan.repository;

import com.kzw.qlchitieucanhan.model.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {
    Optional<NguoiDung> findByEmail(String email);
    Optional<NguoiDung> findByTenDangNhapAndMatKhau(String tenDangNhap, String matKhau);
    Optional<NguoiDung> findByTenDangNhap(String tenDangNhap);

}
