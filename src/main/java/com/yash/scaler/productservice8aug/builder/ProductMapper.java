package com.yash.scaler.productservice8aug.builder;

import com.yash.scaler.productservice8aug.dto.FakeStoreProductDTO;
import com.yash.scaler.productservice8aug.dto.ProductResponseDTO;
import com.yash.scaler.productservice8aug.model.Category;
import com.yash.scaler.productservice8aug.model.Product;

public class ProductMapper {
    /**
     * Converts the Incoming Object to ProductResponseDTO
     *
     * @param product
     * @return
     */
    public static ProductResponseDTO convertToProductResponseDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setCategory(product.getCategory());
        dto.setDescription(product.getDescription());
        dto.setId(product.getId());
        dto.setPrice(product.getPrice());
        dto.setTitle(product.getTitle());

        if (product.getId() != null) {
            dto.setId(product.getId());
        }

        return dto;
    }

    public static Product mapToProduct(FakeStoreProductDTO dto) {
        Product product = new Product();

        //set category
        Category category = new Category();
        category.setTitle(dto.getCategory());


        product.setCategory(category);
        product.setTitle(dto.getTitle());
        product.setId(dto.getId());
        product.setImageURL(dto.getImage());
        product.setPrice(Double.valueOf(dto.getPrice()));
        product.setDescription(dto.getDescription());
        return product;
    }
}
