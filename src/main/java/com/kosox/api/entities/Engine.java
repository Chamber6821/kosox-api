package com.kosox.api.entities;

import com.fasterxml.jackson.annotation.JsonRawValue;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Engine {
  @Id
  private Long id;
  private String title;
  private String image;
  private String description;
  private String rawDescription;
  private String brand;
  private String additionalImages;
  @JsonRawValue
  private String details;
}