package com.kosox.api.v1;

import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kosox.api.entities.Category;
import com.kosox.api.entities.Parameter;
import com.kosox.api.entities.ParameterVariant;
import com.kosox.api.entities.Product;
import com.kosox.api.entities.ProductParameter;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController
@AllArgsConstructor
@CrossOrigin
public class ProductFilterController {
  private final ProductRepository products;

  @GetMapping("/categories/{id}/products/filtered")
  public Object findAll(
      @PathVariable("id") Long categoryId,
      @RequestParam MultiValueMap<String, String> filters,
      Pageable pageable) {
    var pageableParams = List.of("page", "size", "sort");
    return products.findAll(
        (Specification<Product>) ((product, query, builder) -> builder.and(
            fromCategory(product, builder, categoryId),
            withFilters(product, builder,
                filters.entrySet().stream().filter(entry -> !pageableParams.contains(entry.getKey()))))),
        pageable).map(StrictProduct::new);
  }

  private Predicate withFilters(Root<Product> product, CriteriaBuilder builder,
      Stream<Entry<String, List<String>>> filters) {
    return builder.and(filters
        .map((entry) -> builder.and(
            builder.equal(
                product
                    .join(Product.Fields.parameters)
                    .join(ProductParameter.Fields.parameter)
                    .get(Parameter.Fields.name),
                entry.getKey()),
            product
                .join(Product.Fields.parameters)
                .join(ProductParameter.Fields.variant)
                .get(ParameterVariant.Fields.value)
                .in(entry.getValue())))
        .toArray(Predicate[]::new));
  }

  private Predicate fromCategory(Root<Product> product, CriteriaBuilder builder, Long categoryId) {
    return builder.equal(product.join(Product.Fields.category).get(Category.Fields.id), categoryId);
  }

  @Getter
  public static class StrictProduct {
    private final Long id;
    private final String name;
    private final String description;
    private final String icon;
    private final String brandName;
    private final String brandIcon;

    public StrictProduct(Product product) {
      id = product.getId();
      name = product.getName();
      description = product.getDescription();
      icon = product.getIconUrl();
      brandName = product.getBrand().getName();
      brandIcon = product.getBrand().getIconUrl();
    }
  }
}
