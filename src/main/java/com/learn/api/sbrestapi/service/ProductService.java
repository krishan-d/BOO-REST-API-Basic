package com.learn.api.sbrestapi.service;

import java.util.List;

import com.learn.api.sbrestapi.model.Product;

public interface ProductService {
    
    Product create(Product product);

    Product update(Product product, int prodId);

    void delete(int prodId);

    Product getById(int prodId);

    List<Product> getAll();
}
