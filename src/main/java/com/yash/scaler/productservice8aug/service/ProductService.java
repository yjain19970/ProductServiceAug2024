package com.yash.scaler.productservice8aug.service;

import com.yash.scaler.productservice8aug.model.Product;

/**
 * This will only have func declaration.
 */
public interface ProductService {

    public Product getProductById(Long id);

    public void createProduct();
}
