package com.ido.service;

import com.ido.entity.Province;
import com.ido.repository.ProvinceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/province")
public class ProvinceResource {

    private ProvinceRepository provinceRepository;

    public ProvinceResource(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Province>> getAll() {
        List<Province> provinces = provinceRepository.findAll();
        return ResponseEntity.ok(provinces);
    }
}
