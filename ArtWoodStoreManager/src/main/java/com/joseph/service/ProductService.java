package com.joseph.service;

import com.joseph.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Product getProduct(Long id);

    void saveProduct(Product product);

    void deleteProduct(Long id);

    List<Product> getAllProducts();
    List<Product> getProductsByIds(List<Long> productIds);

}
