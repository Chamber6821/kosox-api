package com.kosox.api.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

@Entity
@Getter
public class Brand {
  @Id
  private Long id;
  private String name;
  private String description;
  private String iconUrl;
  @OneToMany(mappedBy = "brand")
  private List<Product> products;
}
