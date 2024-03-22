package com.api.productor.service.impl;

import com.api.productor.entities.Product;
import com.api.productor.persistence.IProductDAO;
import com.api.productor.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDAO productDAO;

    @Override
    public Optional<Product> findById(long id) {
        return Optional.of(productDAO.findById(id).get());
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal min, BigDecimal max) {
        return productDAO.findByPriceInRange(min, max);
    }

    @Override
    public void save(Product product) {
        productDAO.save(product);
    }

    @Override
    public void deleteById(long id) {
        productDAO.deleteById(id);
    }
}
