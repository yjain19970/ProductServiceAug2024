package com.yash.scaler.productservice8aug.repository;

import com.yash.scaler.productservice8aug.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

    Category findByTitle(String title);
}
