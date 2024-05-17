package com.kosox.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.experimental.FieldNameConstants;

@Entity
@Getter
@FieldNameConstants
public class ProductParameter {
  @Id
  private Long id;
  @ManyToOne
  private Product product;
  private String name;
  private String value;
}
