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
public class Subcategory {
  @Id
  private String id;
  private String name;
  private String iconUrl;
  @ManyToOne
  private Category category;
  @OneToMany(mappedBy = "subcategory")
  private List<Product> products;
}
