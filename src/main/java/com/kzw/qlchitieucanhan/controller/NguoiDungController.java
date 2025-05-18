package com.kzw.qlchitieucanhan.controller;

import com.kzw.qlchitieucanhan.model.NguoiDung;
import com.kzw.qlchitieucanhan.repository.NguoiDungRepository;
import com.kzw.qlchitieucanhan.service.NguoiDungService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nguoidung")
@CrossOrigin(origins = "*")
public class NguoiDungController {

    private final NguoiDungService nguoiDungService;
    private final NguoiDungRepository nguoiDungRepository;

    public NguoiDungController(NguoiDungService nguoiDungService, NguoiDungRepository nguoiDungRepository) {
        this.nguoiDungService = nguoiDungService;
        this.nguoiDungRepository = nguoiDungRepository;
    }

    // ================== Đăng nhập ==================
    @PostMapping("/login")
    public NguoiDung login(@RequestBody LoginRequest request) {
        Optional<NguoiDung> user = nguoiDungRepository.findByTenDangNhapAndMatKhau(
                request.getTenDangNhap(), request.getMatKhau()
        );
        return user.orElseThrow(() -> new RuntimeException("Sai tài khoản hoặc mật khẩu"));
    }

    // ================== Đăng ký ==================
    @PostMapping("/register")
    public NguoiDung register(@RequestBody NguoiDung nguoiDung) {
        Optional<NguoiDung> existing = nguoiDungRepository.findByTenDangNhap(nguoiDung.getTenDangNhap());
        if (existing.isPresent()) {
            throw new RuntimeException("Tên đăng nhập đã tồn tại.");
        }
        return nguoiDungService.create(nguoiDung);
    }

    // ================== CRUD thông thường ==================
    @GetMapping
    public List<NguoiDung> getAll() {
        return nguoiDungService.getAll();
    }

    @GetMapping("/{id}")
    public NguoiDung getById(@PathVariable Integer id) {
        return nguoiDungService.getById(id);
    }

    @GetMapping("/email")
    public NguoiDung getByEmail(@RequestParam String email) {
        return nguoiDungService.getByEmail(email);
    }

    @PostMapping
    public NguoiDung create(@RequestBody NguoiDung nguoiDung) {
        return nguoiDungService.create(nguoiDung);
    }

    @PutMapping("/{id}")
    public NguoiDung update(@PathVariable Integer id, @RequestBody NguoiDung nguoiDung) {
        return nguoiDungService.update(id, nguoiDung);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        nguoiDungService.delete(id);
    }

    // ======= DTO nội bộ cho đăng nhập =======
    public static class LoginRequest {
        private String tenDangNhap;
        private String matKhau;

        public String getTenDangNhap() {
            return tenDangNhap;
        }

        public void setTenDangNhap(String tenDangNhap) {
            this.tenDangNhap = tenDangNhap;
        }

        public String getMatKhau() {
            return matKhau;
        }

        public void setMatKhau(String matKhau) {
            this.matKhau = matKhau;
        }
    }
}
