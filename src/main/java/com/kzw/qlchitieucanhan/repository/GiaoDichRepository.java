package com.kzw.qlchitieucanhan.repository;

import com.kzw.qlchitieucanhan.model.GiaoDich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface GiaoDichRepository extends JpaRepository<GiaoDich, Long> {

    List<GiaoDich> findByNgayGiaoDichBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT COALESCE(SUM(g.soTien), 0) FROM GiaoDich g WHERE g.loai = 'chi'")
    BigDecimal getTongChi();

    @Query("SELECT COALESCE(SUM(g.soTien), 0) FROM GiaoDich g WHERE g.loai = 'thu'")
    BigDecimal getTongThu();

    @Query("SELECT COALESCE(SUM(g.soTien), 0) FROM GiaoDich g")
    BigDecimal getTotalSpending();

    // ==== Thống kê theo danh mục có lọc theo user ====
    @Query("""
      SELECT new map(
        dm.tenDanhMuc AS tenDanhMuc,
        SUM(g.soTien)   AS tong
      )
      FROM GiaoDich g
      JOIN g.danhMuc dm
      WHERE UPPER(g.loai) = UPPER(:loai)
        AND g.maNguoiDung = :maNguoiDung
      GROUP BY dm.tenDanhMuc
    """)
    List<Map<String, Object>> thongKeTheoDanhMuc(
            @Param("loai") String loai,
            @Param("maNguoiDung") Integer maNguoiDung
    );

    List<GiaoDich> findByMaNguoiDung(Integer maNguoiDung);

}
