package com.learn.api.sbrestapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.api.sbrestapi.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
    // Product findById(int prodId);
}
