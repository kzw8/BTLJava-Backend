package com.kzw.qlchitieucanhan.controller;

import com.kzw.qlchitieucanhan.dto.GiaoDichFilterDTO;
import com.kzw.qlchitieucanhan.model.DanhMuc;
import com.kzw.qlchitieucanhan.model.GiaoDich;
import com.kzw.qlchitieucanhan.repository.DanhMucRepository;
import com.kzw.qlchitieucanhan.repository.GiaoDichRepository;
import com.kzw.qlchitieucanhan.service.GiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/giaodich")
@CrossOrigin(origins = "*")
public class GiaoDichController {

    @Autowired
    private GiaoDichRepository giaoDichRepository;

    @Autowired
    private DanhMucRepository danhMucRepository;

    @Autowired
    private GiaoDichService giaoDichService;

    //  Thêm giao dịch
    @PostMapping("/them-giaodich")
    public GiaoDich create(@RequestBody GiaoDich gd) {
        if (gd.getDanhMuc() != null) {
            String tenDanhMuc = gd.getDanhMuc().getTenDanhMuc();
            Integer maNguoiDung = gd.getMaNguoiDung();
            String loai = gd.getLoai();

            if (tenDanhMuc != null && maNguoiDung != null && loai != null) {
                Optional<DanhMuc> existing = danhMucRepository.findByTenDanhMucIgnoreCaseAndLoaiIgnoreCaseAndMaNguoiDung(
                        tenDanhMuc, loai, maNguoiDung
                );
                DanhMuc danhMuc = existing.orElseGet(() -> {
                    DanhMuc dm = new DanhMuc();
                    dm.setTenDanhMuc(tenDanhMuc);
                    dm.setLoai(loai);
                    dm.setMaNguoiDung(maNguoiDung);
                    return danhMucRepository.save(dm);
                });
                gd.setMaDanhMuc(danhMuc.getMaDanhMuc());
            }
        }

        gd.setNgayTao(LocalDateTime.now());
        return giaoDichRepository.save(gd);
    }

//    // Lọc nâng cao
//    @GetMapping("/filter")
//    public List<GiaoDich> locNangCaoGet(
//            @RequestParam(required=false) String loai,
//            @RequestParam Integer maNguoiDung,
//            @RequestParam(required=false) Integer maDanhMuc
//            // … các param khác …
//    ) {
//        GiaoDichFilterDTO dto = new GiaoDichFilterDTO(  );
//        return giaoDichService.filter(dto);
//    }
    @PostMapping("/filter")
    public List<GiaoDich> locNangCao(@RequestBody GiaoDichFilterDTO filterDTO) {
    return giaoDichService.filter(filterDTO);
    }

    //  Lọc theo ngày
    @GetMapping("/theo-ngay")
    public List<GiaoDich> filterByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return giaoDichRepository.findByNgayGiaoDichBetween(startDate, endDate);
    }

    // Tổng chi tiêu
    @GetMapping("/tong")
    public BigDecimal getTotalSpending() {
        return giaoDichRepository.getTotalSpending();
    }

    // Tổng thu
    @GetMapping("/tong-thu")
    public BigDecimal getTongThu() {
        return giaoDichRepository.getTongThu();
    }

    // Tổng chi
    @GetMapping("/tong-chi")
    public BigDecimal getTongChi() {
        return giaoDichRepository.getTongChi();
    }

    // Thống kê theo người dùng
    @GetMapping("/nguoidung/{id}")
    public List<GiaoDich> getByNguoiDung(@PathVariable Integer id) {
        return giaoDichRepository.findByMaNguoiDung(id);
    }

    // Cập nhật
    @PutMapping("/{id}")
    public GiaoDich update(
            @PathVariable Long id,
            @RequestBody GiaoDich updated
    ) {
        GiaoDich old = giaoDichRepository.findById(id).orElseThrow();
        old.setMaDanhMuc(updated.getMaDanhMuc());
        old.setLoai(updated.getLoai());
        old.setSoTien(updated.getSoTien());
        old.setMoTa(updated.getMoTa());
        old.setNgayGiaoDich(updated.getNgayGiaoDich());
        return giaoDichRepository.save(old);
    }


    // Xóa
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        giaoDichRepository.deleteById(id);
    }

    // Thống kê danh mục
    @GetMapping("/thongke-theo-danhmuc")
    public List<Map<String, Object>> thongKeTheoDanhMuc(
            @RequestParam String loai,
            @RequestParam Integer maNguoiDung
    ) {
        return giaoDichRepository.thongKeTheoDanhMuc(loai, maNguoiDung);
    }

}
