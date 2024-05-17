package com.kosox.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.kosox.api.entity.SuperCategory;

@CrossOrigin
public interface SuperCategoryRepository
                                extends CrudRepository<SuperCategory, Long> {
}
