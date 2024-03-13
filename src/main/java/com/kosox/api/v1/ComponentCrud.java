package com.kosox.api.v1;

import org.springframework.data.repository.CrudRepository;

import com.kosox.api.entities.Component;

public interface ComponentCrud extends CrudRepository<Component, Long> {}
