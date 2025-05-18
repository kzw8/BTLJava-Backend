package com.kzw.qlchitieucanhan.service;

import com.kzw.qlchitieucanhan.dto.GiaoDichFilterDTO;
import com.kzw.qlchitieucanhan.model.GiaoDich;

import java.util.List;

public interface GiaoDichService {
    List<GiaoDich> filter(GiaoDichFilterDTO f);
    List<GiaoDich> getAll();
}
