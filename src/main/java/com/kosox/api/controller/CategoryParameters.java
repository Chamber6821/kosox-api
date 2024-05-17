package com.kosox.api.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kosox.api.repository.ProductParameterRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin
public class CategoryParameters {

  private final ProductParameterRepository parameters;

  @GetMapping("/categories/{id}/parameters")
  public Object parameters(@PathVariable Long id) {
    return parameters.forCategory(id).stream()
        .collect(Collectors.toMap(
            x -> x.name(),
            x -> List.of(x.value()),
            (a, b) -> Stream.concat(a.stream(), b.stream()).toList()));
  }
}
