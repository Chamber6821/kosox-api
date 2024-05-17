package com.kosox.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.kosox.api.entity.Product;

@CrossOrigin
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
  public Page<Product> findByCategoryId(Long category, Pageable pageable);
}
