package com.kzw.qlchitieucanhan.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "NguoiDung")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NguoiDung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNguoiDung")
    private Integer maNguoiDung;

    @Column(name = "TenDangNhap", nullable = false)
    private String tenDangNhap;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "MatKhau", nullable = false)
    private String matKhau;

    @Column(name = "HoTen")
    private String hoTen;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;
}
