package com.kosox.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class ParameterVariant {
  @Id
  private Long id;
  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "filter_id")
  private Parameter parameter;
  private String value;
}
