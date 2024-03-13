package com.kosox.api.v1;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.kosox.api.entities.Component;

public interface ComponentCrud extends PagingAndSortingRepository<Component, Long> {}
