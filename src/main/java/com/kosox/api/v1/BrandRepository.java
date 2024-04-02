package com.kosox.api.v1;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kosox.api.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}