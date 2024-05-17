package com.kosox.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.kosox.api.entity.Brand;

@CrossOrigin
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
