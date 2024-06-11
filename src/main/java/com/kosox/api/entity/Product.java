package com.kosox.api.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.experimental.FieldNameConstants;

@Entity
@Getter
@FieldNameConstants
public class Product {
  @Id
  private Long id;
  private String name;
  private String description;
  private String iconUrl;
  @ManyToOne
  private Manufacturer manufacturer;
  @ManyToOne
  private Subcategory subcategory;
  @OneToMany(mappedBy = "product")
  private List<Image> images;
  @OneToMany(mappedBy = "product")
  private List<ProductParameter> parameters;
}
