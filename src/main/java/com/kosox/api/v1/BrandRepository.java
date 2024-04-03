package com.kosox.api.v1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.kosox.api.entities.Brand;

@CrossOrigin
public interface BrandRepository extends JpaRepository<Brand, Long> {
}