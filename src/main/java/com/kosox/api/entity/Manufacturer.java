package com.kosox.api.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

@Entity
@Getter
public class Manufacturer {
  @Id
  private String id;
  private String name;
  private String description;
  private String iconUrl;
  @OneToMany(mappedBy = "manufacturer")
  private List<Product> products;
}
