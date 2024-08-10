package com.yash.scaler.productservice8aug.service;

import com.yash.scaler.productservice8aug.model.Product;

/**
 * This will only have func declaration.
 */
public interface ProductService {

    public Product getProductById(Long id);

    public Product createProduct(String title,
                              String description,
                              String category,
                              String price,
                              String image);
}
