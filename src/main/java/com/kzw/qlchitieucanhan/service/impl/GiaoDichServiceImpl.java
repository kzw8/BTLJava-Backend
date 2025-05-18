package com.kzw.qlchitieucanhan.service.impl;

import com.kzw.qlchitieucanhan.dto.GiaoDichFilterDTO;
import com.kzw.qlchitieucanhan.model.GiaoDich;
import com.kzw.qlchitieucanhan.repository.GiaoDichRepository;
import com.kzw.qlchitieucanhan.service.GiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class GiaoDichServiceImpl implements GiaoDichService {

    private final GiaoDichRepository repository;

    @Autowired
    public GiaoDichServiceImpl(GiaoDichRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GiaoDich> filter(GiaoDichFilterDTO f) {
        return repository.findAll().stream()
                // 0) Lọc theo user
                .filter(g -> Objects.equals(g.getMaNguoiDung(), f.getMaNguoiDung()))

                // 1) Lọc theo loại (THU/CHI)
                .filter(g -> f.getLoai() == null
                        || f.getLoai().isBlank()
                        || (g.getLoai() != null
                        && g.getLoai().equalsIgnoreCase(f.getLoai()))
                )

                // 2) Lọc theo danh mục
                .filter(g -> f.getMaDanhMuc() == null
                        || Objects.equals(g.getMaDanhMuc(), f.getMaDanhMuc())
                )

                // 3) Lọc theo mô tả
                .filter(g -> f.getMoTa() == null
                        || f.getMoTa().isBlank()
                        || (g.getMoTa() != null
                        && g.getMoTa().toLowerCase()
                        .contains(f.getMoTa().toLowerCase()))
                )

                // 4) Lọc theo khoảng ngày
                .filter(g -> f.getFromDate() == null
                        || !g.getNgayGiaoDich().isBefore(f.getFromDate())
                )
                .filter(g -> f.getToDate() == null
                        || !g.getNgayGiaoDich().isAfter(f.getToDate())
                )

                // 5) Lọc theo khoảng số tiền
                .filter(g -> f.getMinSoTien() == null
                        || (g.getSoTien() != null
                        && g.getSoTien() >= f.getMinSoTien())
                )
                .filter(g -> f.getMaxSoTien() == null
                        || (g.getSoTien() != null
                        && g.getSoTien() <= f.getMaxSoTien())
                )

                .collect(Collectors.toList());
    }

    @Override
    public List<GiaoDich> getAll() {
        return repository.findAll();
    }
}
