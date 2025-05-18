package com.kzw.qlchitieucanhan.controller;

import com.kzw.qlchitieucanhan.model.DanhMuc;
import com.kzw.qlchitieucanhan.repository.DanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/danhmuc")
public class DanhMucController {

    @Autowired
    private DanhMucRepository danhMucRepository;

    @GetMapping
    public List<DanhMuc> getAll() {
        return danhMucRepository.findAll();
    }

    @GetMapping("/loai")
    public List<DanhMuc> getByLoaiVaNguoiDung(
            @RequestParam String loai,
            @RequestParam Integer maNguoiDung
    ) {
        return danhMucRepository.findByLoaiIgnoreCaseAndMaNguoiDung(loai, maNguoiDung);
    }

}
