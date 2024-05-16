package com.kosox.api.v1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.kosox.api.entities.ProductParameter;

interface ProductParameterRepository
    extends JpaRepository<ProductParameter, Long>, JpaSpecificationExecutor<ProductParameter> {
}
