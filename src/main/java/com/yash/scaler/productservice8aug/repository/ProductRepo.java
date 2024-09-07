package com.yash.scaler.productservice8aug.repository;

import com.yash.scaler.productservice8aug.model.Product;
import com.yash.scaler.productservice8aug.repository.projection.ProductProjection;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findAll(); // ACTION: find, WHAT: all()

    Product findProductById(Integer id); // find ; WHAT: byID

    Product findByDescription(String description);

    Product save(Product p);

    // SYNTAX FOR JOINS USING JPA METHODS
    List<Product> findAllByCategory_TitleEquals(String title);

    /**
     * Get a Product from id and a title.
     */
    @Query("select p from Product p where p.id = :id")
    Product getProductFromIdAndTitle(@Param("id") Integer id);

    /**
     * Get Title and Id
     * <p>
     * Return something called as Projection
     */
    @Query("select p.id as id, p.title as title, p.price as price from Product p where p.id = :id")
    ProductProjection getTitleAndPriceProductFromId(@Param("id") Integer id);

    @Query("select p.id as id,  p.price as price from Product p where p.title = :title")
    List<ProductProjection> getTitleAndPriceProductFromTitle(@Param("title") String title);

    /**
     * Way-1 Create your own method, (HQL) query which supports Pagination
     * This is your assignment
     */


    /*

        Way2: Make use of existing library/
        This is already supported.. woohoo!!
     */




}
