package com.yash.scaler.productservice8aug;

import com.yash.scaler.productservice8aug.model.Category;
import com.yash.scaler.productservice8aug.repository.CategoryRepo;
import com.yash.scaler.productservice8aug.repository.ProductRepo;
import com.yash.scaler.productservice8aug.repository.projection.ProductProjection;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductService8AugApplicationTests {
    @Autowired
    private ProductRepo productRepository;
    @Autowired
    private CategoryRepo catRepository;

    @Test
    @Transactional
    void testingQueries() {
//        List<ProductProjection> pros = productRepository.
//                getTitleAndPriceProductFromTitle("Test");
//        System.out.println(pros.get(0).getPrice());

        Category cat = catRepository.findByTitle("First Cat");
        System.out.println(cat);

        System.out.println("Doing getter...");
        cat.getProducts();
        System.out.println(cat);
    }

}
