package com.kzw.qlchitieucanhan.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ViTien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ViTien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaVi")
    private Integer maVi;

    @Column(name = "MaNguoiDung", nullable = false)
    private Integer maNguoiDung;

    @Column(name = "TenVi", nullable = false)
    private String tenVi;

    @Column(name = "SoDu", nullable = false)
    private Double soDu;

    @Column(name = "DonViTienTe")
    private String donViTienTe;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;
}
