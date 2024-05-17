package com.kosox.api.v1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.kosox.api.entities.ProductParameter;

@CrossOrigin
public interface ProductParameterRepository extends JpaRepository<ProductParameter, Long> {
	@Query("""
				SELECT new com.kosox.api.v1.ProductParameterRepository$Parameter(pp.name, pp.value)
				FROM ProductParameter pp
				JOIN pp.product ppp
				JOIN ppp.category c
				WHERE c.id = :categoryId
				GROUP BY pp.name, pp.value
				ORDER BY pp.name, pp.value
			""")
	public List<Parameter> forCategory(Long categoryId);

	public record Parameter(String name, String value) {
	}
}
