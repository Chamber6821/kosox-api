package com.kosox.api.v1;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosox.api.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}