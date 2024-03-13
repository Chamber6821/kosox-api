package com.kosox.api.v1;

import org.springframework.data.repository.CrudRepository;

import com.kosox.api.entities.Engine;

public interface EngineCrud extends CrudRepository<Engine, Long> {}
