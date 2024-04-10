package com.kosox.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import java.util.List;

@Entity
@Getter
public class Parameter {
  @Id
  private Long id;
  private String name;
  @ManyToOne
  private Category category;
  @OneToMany(mappedBy = "parameter")
  private List<ParameterVariant> variants;
}
