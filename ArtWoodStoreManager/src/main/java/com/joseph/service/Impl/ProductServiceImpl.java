package com.joseph.service.Impl;

import com.joseph.entity.Product;
import com.joseph.repository.ProductRepository;
import com.joseph.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        // Assuming productRepository is an instance of JpaRepository or a similar interface
        return productRepository.findAll();
    }
    @Override
    public List<Product> getProductsByIds(List<Long> productIds) {
        // Filter products based on the given product IDs
        return productRepository.findAllById(productIds);
    }


}
