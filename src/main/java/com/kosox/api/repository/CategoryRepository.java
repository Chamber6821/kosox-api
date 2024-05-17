package com.kosox.api.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.kosox.api.entity.Category;

@CrossOrigin
public interface CategoryRepository extends JpaRepository<Category, Long> {
              @Query("""
                                            SELECT c FROM Category c
                                            JOIN c.products pc
                                            JOIN pc.brand pcb
                                            WHERE pcb.id = :brandId
                                            GROUP BY c
                                          """)
              public Set<Category> findAllByBrand(Long brandId);
}
