package com.kosox.api.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;

@Entity
@Getter
public class Product {
  @Id
  private Long id;
  private String name;
  private String description;
  private String iconUrl;
  @ManyToOne
  private Brand brand;
  @ManyToOne
  private Category category;
  @OneToMany(mappedBy = "product")
  private List<Image> images;
}