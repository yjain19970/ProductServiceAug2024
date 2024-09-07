package com.yash.scaler.productservice8aug.scheduled;

import com.yash.scaler.productservice8aug.model.Product;
import com.yash.scaler.productservice8aug.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DbFetcherPerMinute {
    private ProductService productService;

    public DbFetcherPerMinute(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    // CRON EXPRESSION:
    @Scheduled(cron = "0 2 * * * *")
    public void execute() {
        Product product = productService.getProductById(1);
        System.out.println("Product Is: " + product.getId());
    }
}
