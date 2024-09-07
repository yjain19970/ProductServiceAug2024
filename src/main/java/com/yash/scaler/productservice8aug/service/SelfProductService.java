package com.yash.scaler.productservice8aug.service;

import com.yash.scaler.productservice8aug.model.Category;
import com.yash.scaler.productservice8aug.model.Product;
import com.yash.scaler.productservice8aug.repository.CategoryRepo;
import com.yash.scaler.productservice8aug.repository.ProductRepo;
import com.yash.scaler.productservice8aug.repository.projection.ProductProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService {
    private ProductRepo productRepo;
    private CategoryRepo categoryRepo; // REMOVE THIS FROM HERE ONCE CAT_SERVICE IS CREATED.

    /**
     * Injected Using DI
     *
     * @param productRepo
     * @param categoryRepo
     */
    public SelfProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Product getProductById(Integer id) {
        Product product = productRepo.findProductById(id);
        return product;
    }

    @Override
    public Product createProduct(String title, String description,
                                 String categoryTitle, String price, String imageURL) {

        // s1. FindCategory by title
        Category existingCategory = categoryRepo.findByTitle(categoryTitle);
        if (existingCategory == null) {
            // there are 2 things now. Either create one OR throw an exception.
            existingCategory = new Category();
            existingCategory.setTitle(categoryTitle);
            existingCategory.setCreatedAt(new Date());
            existingCategory.setLastUpdatedAt(new Date());
            existingCategory.setDeleted(false);

            existingCategory = categoryRepo.save(existingCategory);
            System.out.println("Category is created....");
        }

        // S2. Created the Product Model
        Product product = new Product();
        product.setCategory(existingCategory);
        product.setDescription(description);
        product.setTitle(title);
        product.setCreatedAt(new Date());
        product.setLastUpdatedAt(new Date());
        product.setImageURL(imageURL);
        product.setPrice(Double.valueOf(price));
        product.setDeleted(false);

        // S3.
        Product returnedProduct = productRepo.save(product);
        return returnedProduct;
    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Page<Product> getPaginatedProducts(int pageNo, int pageSize) {
        String sortBy = "name";

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.Direction.ASC, sortBy);

        Page<Product> productPage = productRepo.findAll(pageable);
        return productPage;
    }


    @Override
    public Product getProductByIdAndTitle(Integer id) {
        Product product = productRepo.getProductFromIdAndTitle(id);
        ProductProjection productProjection = productRepo.getTitleAndPriceProductFromId(id);
        return product;
    }
}

/**
 * detached entity passed to persist:
 * com.example.productservice.model.Category.did you get to know what would be the error
 */