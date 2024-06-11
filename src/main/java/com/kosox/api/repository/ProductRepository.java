package com.kosox.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.kosox.api.entity.Product;

@CrossOrigin
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
  public Page<Product> findBySubcategoryId(String subcategory, Pageable pageable);

  @Query("""
      SELECT p FROM Product p
      JOIN p.manufacturer b
      JOIN p.subcategory c
      JOIN p.parameters pps
      WHERE
        lower(p.name) LIKE concat('%', lower(:fragment), '%')
        OR lower(b.name) LIKE concat('%', lower(:fragment), '%')
        OR lower(c.name) LIKE concat('%', lower(:fragment), '%')
        OR lower(pps.name) LIKE concat('%', lower(:fragment), '%')
        OR lower(pps.value) LIKE concat('%', lower(:fragment), '%')
      GROUP BY p
      ORDER BY p.name
      """)
  Page<Product> search(String fragment, Pageable pageable);
}
