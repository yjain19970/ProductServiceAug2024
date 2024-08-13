package com.yash.scaler.productservice8aug.controller;

import com.yash.scaler.productservice8aug.builder.ProductMapper;
import com.yash.scaler.productservice8aug.dto.FakeStoreProductDTO;
import com.yash.scaler.productservice8aug.dto.ProductResponseDTO;
import com.yash.scaler.productservice8aug.model.Product;
import com.yash.scaler.productservice8aug.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private ProductService productService;

    // Injecting ProductService in Controller
    public ProductController(ProductService svc) {
        this.productService = svc;
    }


    /**
     * Controller: (Waiter)
     * <p>
     * Responsibility:
     * 1. Get the Request
     * 2. Validate the Request
     * 3. Call Chef(Service Layer)
     * 4. Get response from ServiceLayer
     * 5. ConvertResponse If needed.
     * 6. Return to Customer.
     *
     * @param id
     */
    @GetMapping("/product/{id}")
    public ProductResponseDTO getProductById(@PathVariable("id") Long id) {
        if (id == null) {
            System.out.println("id cannot be null.");
            return null;
        }

        // S1. call to service layer.
        Product product = productService.getProductById(id);
        // S2. Map to ResponseDTO
        ProductResponseDTO response = ProductMapper.convertToProductResponseDTO(product);
        // S3. Return
        return response;
    }

    /**
     * Responsibility:
     * 1. ValidateRequest
     * 2. Pass to ServiceLayer
     * 3. Get response from serviceLayer
     * 4. Convert to DTO if needed.
     * 5. Return data to client
     *
     * @param dto
     * @return
     */
    @PostMapping("/product")
    public ProductResponseDTO createProduct(@RequestBody FakeStoreProductDTO dto) {
        // S1. Validate -- Add the validation by yourself.

        // S2. Call ProductService
        Product productResp = productService.createProduct(dto.getTitle(),
                dto.getDescription(),
                dto.getImage(),
                dto.getPrice(), dto.getCategory());


        // S3. convert this to DTO and return.

        return ProductMapper.convertToProductResponseDTO(productResp);
    }

    @GetMapping("/products")
    public void getAllProducts() {
        // YOU WILL IMPLEMENT
    }


    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {

    }

}
