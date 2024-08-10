package com.yash.scaler.productservice8aug.service;

import com.yash.scaler.productservice8aug.dto.FakeStoreProductDTO;
import com.yash.scaler.productservice8aug.model.Category;
import com.yash.scaler.productservice8aug.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service // that this is a special class
public class FakeStoreService implements ProductService {


    private RestTemplate restTemplate;

    public FakeStoreService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public Product getProductById(Long id) {
        System.out.println("I am Inside ProductService and calling FkStore..");
        //s1. Call the FakeStore API
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.
                getForEntity("https://api.escuelajs.co/api/v1/products/" + id,
                        FakeStoreProductDTO.class);

        if (response.getBody() == null) {
            // throw exception.
            System.out.println("Product Body is Null");
        }

        // S2 Get the Body from response Entity
        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();

        //S3: Finally return the Model
        return mapToProduct(fakeStoreProductDTO);
    }

    private Product mapToProduct(FakeStoreProductDTO dto) {
        Product product = new Product();

        Category category = new Category();
        category.setTitle(dto.getCategory().getTitle());
        category.setId(dto.getCategory().getId());


        product.setCategory(category);
        product.setTitle(dto.getTitle());
        product.setId(dto.getId());
        product.setImageURL(dto.getImages().get(0));
        product.setPrice(Double.valueOf(dto.getPrice()));
        product.setDescription(dto.getDescription());
        return product;
    }

    @Override
    public Product createProduct(String title, String description, String category, String price, String image) {

        // 1. Call the fakestore API requestDTO
        FakeStoreProductDTO requestBody = new FakeStoreProductDTO();


        restTemplate.postForObject("", requestBody, FakeStoreProductDTO.class);

        return null;
    }
}
