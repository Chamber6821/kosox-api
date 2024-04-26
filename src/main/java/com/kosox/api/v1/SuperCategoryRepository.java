package com.kosox.api.v1;

import com.kosox.api.entities.SuperCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface SuperCategoryRepository
    extends CrudRepository<SuperCategory, Long> {
}
