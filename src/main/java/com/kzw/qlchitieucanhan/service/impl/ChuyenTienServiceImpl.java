package com.kzw.qlchitieucanhan.service.impl;

import com.kzw.qlchitieucanhan.model.ChuyenTien;
import com.kzw.qlchitieucanhan.repository.ChuyenTienRepository;
import com.kzw.qlchitieucanhan.service.ChuyenTienService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuyenTienServiceImpl implements ChuyenTienService {

    private final ChuyenTienRepository chuyenTienRepository;

    public ChuyenTienServiceImpl(ChuyenTienRepository chuyenTienRepository) {
        this.chuyenTienRepository = chuyenTienRepository;
    }

    @Override
    public List<ChuyenTien> getAll() {
        return chuyenTienRepository.findAll();
    }

    @Override
    public ChuyenTien getById(Integer id) {
        return chuyenTienRepository.findById(id).orElse(null);
    }

    @Override
    public ChuyenTien create(ChuyenTien chuyenTien) {
        return chuyenTienRepository.save(chuyenTien);
    }

    @Override
    public ChuyenTien update(Integer id, ChuyenTien chuyenTien) {
        chuyenTien.setMaChuyenTien(id);
        return chuyenTienRepository.save(chuyenTien);
    }

    @Override
    public void delete(Integer id) {
        chuyenTienRepository.deleteById(id);
    }

    @Override
    public List<ChuyenTien> getByMaNguoiDung(Integer maNguoiDung) {
        return chuyenTienRepository.findByMaNguoiDung(maNguoiDung);
    }
}
