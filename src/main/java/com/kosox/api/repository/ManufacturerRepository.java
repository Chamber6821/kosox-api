package com.kosox.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.kosox.api.entity.Manufacturer;

@CrossOrigin
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}
