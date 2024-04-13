package com.kosox.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Entity
@IdClass(ProductParameter.PId.class)
@Getter
@FieldNameConstants
public class ProductParameter {
  @Id
  @ManyToOne
  private Product product;
  @Id
  @ManyToOne
  private Parameter parameter;
  @ManyToOne
  private ParameterVariant variant;

  @Getter
  @NoArgsConstructor
  public static class PId {
    private Product product;
    private Parameter parameter;
  }
}
