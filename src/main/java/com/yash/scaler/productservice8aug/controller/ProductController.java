package com.yash.scaler.productservice8aug.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {


    @PostMapping("/product")
    public void createProduct() {
        // call this method.


        /**
         *
         *{
         *  "title" : "yash",
         *  "description" : "some description",
         *  "price" : 101.1
         * }
         */
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

        /**
         *
         *  int id
         *  string title
         *  string description
         *
         *
         * {
         *  "id" : 1,
         *  "title" : "any title",
         *  "description" : "any description"
         * }
         *
         */
    }

    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {

    }


    /**
     * DataTransferObject (DTO)
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
}
