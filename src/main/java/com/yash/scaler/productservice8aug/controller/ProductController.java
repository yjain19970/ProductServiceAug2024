package com.yash.scaler.productservice8aug.controller;

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
    public void createProduct() {
        // call this method.

    }

    @GetMapping("/products")
    public void getAllProducts() {

    }

    /**
     * lets start with this API.
     *
     * @param id
     */
    @GetMapping("/product/{id}")
    public void getProductById(@PathVariable("id") Long id) {

        // validations
        if (id == null) {
            // throw an exception.
        }

        // call to service layer.
        Product product = svc.getProductById(id);
        // model to dto conversion in controller.


    }

    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {

    }

}
