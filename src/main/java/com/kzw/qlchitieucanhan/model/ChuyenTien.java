package com.kzw.qlchitieucanhan.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ChuyenTien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChuyenTien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaChuyenTien")
    private Integer maChuyenTien;

    @Column(name = "MaNguoiDung", nullable = false)
    private Integer maNguoiDung;

    @Column(name = "TuVi", nullable = false)
    private Integer tuVi;

    @Column(name = "DenVi", nullable = false)
    private Integer denVi;

    @Column(name = "SoTien", nullable = false)
    private Double soTien;

    @Column(name = "NgayChuyen", nullable = false)
    private LocalDate ngayChuyen;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;
}
