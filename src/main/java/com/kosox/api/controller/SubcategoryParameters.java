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
public class SubcategoryParameters {

  private final ProductParameterRepository parameters;

  @GetMapping("/subcategories/{id}/parameters")
  public Object parameters(@PathVariable String id) {
    return parameters.forSubcategory(id).stream()
        .collect(Collectors.toMap(
            x -> x.name(),
            x -> List.of(x.value()),
            (a, b) -> Stream.concat(a.stream(), b.stream()).toList()));
  }
}
