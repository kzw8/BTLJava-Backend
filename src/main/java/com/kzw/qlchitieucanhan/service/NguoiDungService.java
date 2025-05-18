package com.kzw.qlchitieucanhan.service;

import com.kzw.qlchitieucanhan.model.NguoiDung;

import java.util.List;

public interface NguoiDungService {
    List<NguoiDung> getAll();
    NguoiDung getById(Integer id);
    NguoiDung create(NguoiDung nguoiDung);
    NguoiDung update(Integer id, NguoiDung nguoiDung);
    void delete(Integer id);
    NguoiDung getByEmail(String email); // tuỳ chọn nếu có login sau này
}
