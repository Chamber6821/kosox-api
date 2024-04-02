package com.kosox.api.v1;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosox.api.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
