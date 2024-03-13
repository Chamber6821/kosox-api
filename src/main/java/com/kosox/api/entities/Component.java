package com.kosox.api.entities;

import com.fasterxml.jackson.annotation.JsonRawValue;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Component {
  @Id
  private Long id;
  private String title;
  private String description;
  @JsonRawValue
  private String details;
  private String image;
}
