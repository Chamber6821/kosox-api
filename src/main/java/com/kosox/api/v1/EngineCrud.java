package com.kosox.api.v1;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.kosox.api.entities.Engine;

public interface EngineCrud extends PagingAndSortingRepository<Engine, Long> {}
