package com.kzw.qlchitieucanhan.service.impl;

import com.kzw.qlchitieucanhan.model.NguoiDung;
import com.kzw.qlchitieucanhan.repository.NguoiDungRepository;
import com.kzw.qlchitieucanhan.service.NguoiDungService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {

    private final NguoiDungRepository nguoiDungRepository;

    public NguoiDungServiceImpl(NguoiDungRepository nguoiDungRepository) {
        this.nguoiDungRepository = nguoiDungRepository;
    }

    @Override
    public List<NguoiDung> getAll() {
        return nguoiDungRepository.findAll();
    }

    @Override
    public NguoiDung getById(Integer id) {
        return nguoiDungRepository.findById(id).orElse(null);
    }

    @Override
    public NguoiDung create(NguoiDung nguoiDung) {
        return nguoiDungRepository.save(nguoiDung);
    }

    @Override
    public NguoiDung update(Integer id, NguoiDung nguoiDung) {
        nguoiDung.setMaNguoiDung(id);
        return nguoiDungRepository.save(nguoiDung);
    }

    @Override
    public void delete(Integer id) {
        nguoiDungRepository.deleteById(id);
    }

    @Override
    public NguoiDung getByEmail(String email) {
        return nguoiDungRepository.findByEmail(email).orElse(null);
    }
}
