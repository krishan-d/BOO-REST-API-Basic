package com.learn.api.sbrestapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.api.sbrestapi.dao.ProductRepository;
import com.learn.api.sbrestapi.model.Product;
import com.learn.api.sbrestapi.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;

    @Override
    public Product create(Product product) {
        return repo.save(product);
    }

    @Override
    public void delete(int prodId) {
        Product p = repo.findById(prodId).orElseThrow(() -> new RuntimeException("Product 404"));
        repo.delete(p);
    }

    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }

    @Override
    public Product getById(int prodId) {
        Product p = repo.findById(prodId).orElseThrow(() -> new RuntimeException("Product 404"));
        return p;
    }

    @Override
    public Product update(Product product, int prodId) {
        Product p = repo.findById(prodId).orElseThrow(() -> new RuntimeException("Product 404"));
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setDescription(product.getDescription());
        return repo.save(p);
    }
    
    
}
