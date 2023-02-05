package com.learn.api.sbrestapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.api.sbrestapi.model.Product;
import com.learn.api.sbrestapi.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        Product p = productService.create(product);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable("productId") int id) {
        Product p = productService.update(product, id);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable("productId") int id) {
        productService.delete(id);
        Map<String, String> map = Map.of("message", "product is deleted successfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable("productId") int id) {
        Product p = productService.getById(id);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllProducts() {
        List<Product> list = productService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
