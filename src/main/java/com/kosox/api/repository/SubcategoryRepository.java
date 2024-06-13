package com.kosox.api.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.kosox.api.entity.Subcategory;

@CrossOrigin
public interface SubcategoryRepository extends JpaRepository<Subcategory, String> {
  @Query("""
      SELECT c FROM Subcategory c
      JOIN c.products pc
      JOIN pc.manufacturer pcm
      WHERE pcm.id = :manufacturerId
      GROUP BY c
      """)
  public Set<Subcategory> findAllByManufacturer(Long manufacturerId);
}
