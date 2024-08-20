package com.yash.scaler.productservice8aug.repository;

import com.yash.scaler.productservice8aug.model.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findAll(); // ACTION: find, WHAT: all()

    Product findProductById(Integer id); // find ; WHAT: byID

    Product findByDescription(String description);

    Product save(Product p);

}
