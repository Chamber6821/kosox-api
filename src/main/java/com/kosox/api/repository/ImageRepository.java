package com.kosox.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.kosox.api.entity.Image;

@CrossOrigin
public interface ImageRepository extends JpaRepository<Image, Long> {
}
