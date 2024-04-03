package com.kosox.api.v1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.kosox.api.entities.Product;

@CrossOrigin
public interface ProductRepository extends JpaRepository<Product, Long> {
}
