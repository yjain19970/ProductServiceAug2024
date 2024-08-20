package com.yash.scaler.productservice8aug.controller;

import com.yash.scaler.productservice8aug.builder.ProductMapper;
import com.yash.scaler.productservice8aug.dto.CreateProductRequestDTO;
import com.yash.scaler.productservice8aug.dto.ProductResponseDTO;
import com.yash.scaler.productservice8aug.exception.InvalidProductIdException;
import com.yash.scaler.productservice8aug.exception.ProductNotFoundException;
import com.yash.scaler.productservice8aug.model.Product;
import com.yash.scaler.productservice8aug.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    private ProductMapper mapper;


    // Injecting ProductService in Controller
    public ProductController(@Qualifier("selfProductService") ProductService svc, ProductMapper mapper) {
        this.productService = svc;
        this.mapper = mapper;
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
    public ProductResponseDTO getProductById(@PathVariable("id") Integer id)
            throws InvalidProductIdException, ProductNotFoundException {
        if (id == null) {
            throw new InvalidProductIdException("some message");
        }

        // S1. call to service layer.
        Product product = productService.getProductById(id);
        if (product == null) {
            throw new ProductNotFoundException();
        }
        // S2. Map to ResponseDTO
        ProductResponseDTO response = mapper.convertToProductResponseDTO(product);
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
    public ProductResponseDTO createProduct(@RequestBody CreateProductRequestDTO dto) {
        // S1. Validate -- Add the validation by yourself.

        // S2. Call ProductService
        Product productResp = productService.createProduct(dto.getTitle(),
                dto.getDescription(),
                dto.getImage(),
                dto.getPrice(),
                dto.getCategory());


        // S3. convert this to DTO and return.
        return mapper.convertToProductResponseDTO(productResp);
    }

    @GetMapping("/products")
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> productList = productService.getAllProduct();
        if (productList == null || productList.size() == 0) {
            return null;
        }

        List<ProductResponseDTO> response = new ArrayList<>();

        // converting models to dtolist
        for (Product p : productList) {
            response.add(mapper.convertToProductResponseDTO(p));
        }

        return response;
    }


    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {

    }


}
