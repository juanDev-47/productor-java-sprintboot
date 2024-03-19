package com.api.productor.persistence;

import com.api.productor.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductDAO {
    Optional<Product> findById(long id);
    List<Product> findAll();
    List<Product> findByPriceInRange(BigDecimal min, BigDecimal max);
    void save(Product product);
    void deleteById(long id);
}
