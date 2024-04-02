package com.kosox.api.v1;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosox.api.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}