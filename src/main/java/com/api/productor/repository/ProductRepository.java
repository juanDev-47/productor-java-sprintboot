package com.api.productor.repository;

import com.api.productor.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
}
