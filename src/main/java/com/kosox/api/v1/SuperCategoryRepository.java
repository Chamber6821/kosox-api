package com.kosox.api.v1;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosox.api.entities.SuperCategory;

public interface SuperCategoryRepository extends JpaRepository<SuperCategory, Long> {
}