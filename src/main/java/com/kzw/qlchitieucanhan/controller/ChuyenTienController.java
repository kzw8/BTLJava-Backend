package com.kzw.qlchitieucanhan.controller;

import com.kzw.qlchitieucanhan.model.ChuyenTien;
import com.kzw.qlchitieucanhan.service.ChuyenTienService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chuyentien")
@CrossOrigin(origins = "*")
public class ChuyenTienController {

    private final ChuyenTienService chuyenTienService;

    public ChuyenTienController(ChuyenTienService chuyenTienService) {
        this.chuyenTienService = chuyenTienService;
    }

    @GetMapping
    public List<ChuyenTien> getAll() {
        return chuyenTienService.getAll();
    }

    @GetMapping("/{id}")
    public ChuyenTien getById(@PathVariable Integer id) {
        return chuyenTienService.getById(id);
    }

    @GetMapping("/nguoidung/{maNguoiDung}")
    public List<ChuyenTien> getByNguoiDung(@PathVariable Integer maNguoiDung) {
        return chuyenTienService.getByMaNguoiDung(maNguoiDung);
    }

    @PostMapping
    public ChuyenTien create(@RequestBody ChuyenTien chuyenTien) {
        return chuyenTienService.create(chuyenTien);
    }

    @PutMapping("/{id}")
    public ChuyenTien update(@PathVariable Integer id, @RequestBody ChuyenTien chuyenTien) {
        return chuyenTienService.update(id, chuyenTien);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        chuyenTienService.delete(id);
    }
}
