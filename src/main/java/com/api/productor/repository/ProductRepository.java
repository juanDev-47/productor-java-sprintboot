package com.api.productor.repository;

import com.api.productor.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    // find using queries
    @Query("SELECT p FROM Product p WHERE p.price >= :min AND p.price <= :max")
    List<Product> findProductByPriceInRange(BigDecimal min, BigDecimal max);

    // find using query methods
    List<Product> findProductByPriceBetween(BigDecimal min, BigDecimal max);
}
