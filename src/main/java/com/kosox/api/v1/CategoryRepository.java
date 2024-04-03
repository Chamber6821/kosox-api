package com.kosox.api.v1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.kosox.api.entities.Category;

@CrossOrigin
public interface CategoryRepository extends JpaRepository<Category, Long> {
}