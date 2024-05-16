package com.kosox.api.entities;

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
public class Category {
  @Id
  private Long id;
  private String name;
  private String iconUrl;
  @ManyToOne
  private SuperCategory superCategory;
  @OneToMany(mappedBy = "category")
  private List<Product> products;
}
