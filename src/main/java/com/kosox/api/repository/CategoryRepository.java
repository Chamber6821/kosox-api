package com.kosox.api.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.kosox.api.entity.Category;

@CrossOrigin
public interface CategoryRepository extends CrudRepository<Category, String> {
  @Query("""
      SELECT c FROM Category c
      JOIN c.subcategories s
      JOIN s.products ps
      JOIN ps.manufacturer psm
      WHERE psm.id = :manufacturerId
      GROUP BY c
      """)
  public Set<Category> findAllByManufacturer(Long manufacturerId);
}
