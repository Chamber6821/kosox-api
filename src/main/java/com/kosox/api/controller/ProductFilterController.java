package com.kosox.api.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kosox.api.entity.Subcategory;
import com.kosox.api.entity.Product;
import com.kosox.api.entity.ProductParameter;
import com.kosox.api.repository.ProductRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@AllArgsConstructor
@CrossOrigin
public class ProductFilterController {
  private final ProductRepository products;

  @GetMapping("/subcategories/{id}/products/filtered")
  public Object findAll(
      @PathVariable("id") final String subcategoryId,
      @RequestParam final MultiValueMap<String, String> filters,
      final Pageable pageable) {
    final var pageableParams = List.of("page", "size", "sort");
    log.info("Pageable: {}", pageable);
    log.info("Filters: {}", filters);
    return products.findAll(
        (Specification<Product>) ((product, query, builder) -> builder.and(
            fromCategory(product, builder, subcategoryId),
            withFilters(product, builder,
                filters.entrySet().stream().filter(entry -> !pageableParams.contains(entry.getKey()))))),
        pageable).map(StrictProduct::new);
  }

  private Predicate withFilters(final Root<Product> product, final CriteriaBuilder builder,
      final Stream<Entry<String, List<String>>> filters) {
    return builder.and(filters
        .map((entry) -> builder.and(
            builder.equal(
                product
                    .join(Product.Fields.parameters)
                    .get(ProductParameter.Fields.name),
                entry.getKey()),
            product
                .join(Product.Fields.parameters)
                .get(ProductParameter.Fields.value)
                .in(entry.getValue())))
        .toArray(Predicate[]::new));
  }

  private Predicate fromCategory(final Root<Product> product, final CriteriaBuilder builder, final String categoryId) {
    return builder.equal(product.join(Product.Fields.subcategory).get(Subcategory.Fields.id), categoryId);
  }

  @Getter
  public static class StrictProduct {
    private final Long id;
    private final String name;
    private final String description;
    private final String icon;
    private final String brandName;
    private final String brandIcon;
    private final Map<String, String> parameters;

    public StrictProduct(final Product product) {
      id = product.getId();
      name = product.getName();
      description = product.getDescription();
      icon = product.getIconUrl();
      brandName = product.getManufacturer().getName();
      brandIcon = product.getManufacturer().getIconUrl();
      parameters = product.getParameters().stream()
          .collect(Collectors.toMap(ProductParameter::getName, ProductParameter::getValue));
    }
  }
}
