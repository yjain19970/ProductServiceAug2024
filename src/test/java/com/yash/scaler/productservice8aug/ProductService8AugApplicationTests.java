package com.yash.scaler.productservice8aug;

import com.yash.scaler.productservice8aug.repository.CategoryRepo;
import com.yash.scaler.productservice8aug.repository.ProductRepo;
import com.yash.scaler.productservice8aug.repository.projection.ProductProjection;
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
    void testingQueries() {
        List<ProductProjection> pros = productRepository.
                getTitleAndPriceProductFromTitle("Samsung F11");
        System.out.println(pros.get(0).getPrice());


    }

}
