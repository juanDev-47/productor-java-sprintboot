package com.api.productor.persistence.impl;

import com.api.productor.entities.Product;
import com.api.productor.persistence.IProductDAO;
import com.api.productor.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDAOImpl implements IProductDAO {


    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    public List<Product> findByPriceInRange(BigDecimal min, BigDecimal max) {
        return (List<Product>) productRepository.findByPriceBetween(min, max);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }
}
