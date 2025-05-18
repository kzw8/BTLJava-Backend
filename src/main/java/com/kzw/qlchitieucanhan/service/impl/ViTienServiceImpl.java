package com.kzw.qlchitieucanhan.service.impl;

import com.kzw.qlchitieucanhan.model.ViTien;
import com.kzw.qlchitieucanhan.repository.ViTienRepository;
import com.kzw.qlchitieucanhan.service.ViTienService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViTienServiceImpl implements ViTienService {

    private final ViTienRepository viTienRepository;

    public ViTienServiceImpl(ViTienRepository viTienRepository) {
        this.viTienRepository = viTienRepository;
    }

    @Override
    public List<ViTien> getAll() {
        return viTienRepository.findAll();
    }

    @Override
    public ViTien getById(Integer id) {
        return viTienRepository.findById(id).orElse(null);
    }

    @Override
    public ViTien create(ViTien viTien) {
        return viTienRepository.save(viTien);
    }

    @Override
    public ViTien update(Integer id, ViTien viTien) {
        viTien.setMaVi(id);
        return viTienRepository.save(viTien);
    }

    @Override
    public void delete(Integer id) {
        viTienRepository.deleteById(id);
    }

    @Override
    public List<ViTien> getByMaNguoiDung(Integer maNguoiDung) {
        return viTienRepository.findByMaNguoiDung(maNguoiDung);
    }
}
