package com.yash.scaler.productservice8aug.controller;

import com.yash.scaler.productservice8aug.dto.FakeStoreProductDTO;
import com.yash.scaler.productservice8aug.dto.ProductResponseDTO;
import com.yash.scaler.productservice8aug.model.Product;
import com.yash.scaler.productservice8aug.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService svc;

    // Injecting ProductService in Controller
    public ProductController(ProductService svc) {
        this.svc = svc;
    }

    @PostMapping("/product")
    public ProductResponseDTO createProduct(@RequestBody FakeStoreProductDTO dto) {

        // S1. Validate the request

        //S2.


        // convert this to DTO and return.
        return null;
    }

    @GetMapping("/products")
    public void getAllProducts() {
        // YOU WILL IMPLEMENT
    }

    /**
     * lets start with this API.
     *
     * @param id
     */
    @GetMapping("/product/{id}")
    public ProductResponseDTO getProductById(@PathVariable("id") Long id) {
        validateRequestParam(id);

        // S1. call to service layer.
        Product product = svc.getProductById(id);
        // S2. Map to ResponseDTO
        ProductResponseDTO response = convertToProductResponseDTO(product);
        // S3. Return
        return response;
    }

    private void validateRequestParam(Long id) {
        // validations
        if (id == null) {
            // throw an exception.
        }
    }

    private ProductResponseDTO convertToProductResponseDTO(Product product) {
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

    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {

    }

}
