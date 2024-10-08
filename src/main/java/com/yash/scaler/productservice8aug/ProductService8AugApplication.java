package com.yash.scaler.productservice8aug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class ProductService8AugApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductService8AugApplication.class, args);
    }

}
