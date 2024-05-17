package com.kosox.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Image {
  @Id
  private Long id;
  private String url;
  @ManyToOne
  private Product product;
}
