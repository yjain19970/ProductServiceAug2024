package com.yash.scaler.productservice8aug.service;

import com.yash.scaler.productservice8aug.builder.ProductMapper;
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
        //s1. Call the FakeStore API
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.
                getForEntity("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDTO.class);

        if (response.getBody() == null) {
            // throw exception.
            System.out.println("Product Body is Null");
        }

        // S2 Get the Body from response Entity
        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();

        //S3: Finally return the Model
        return ProductMapper.mapToProduct(fakeStoreProductDTO);
    }


    /**
     * Steps:
     * <p>
     * 1. Create Object to call FakeStoreAPI
     * 2. Call FakeStore API
     * 3. Get response and convert that to FakeStoreResponse
     * 4. Map it to our Model
     * 5. Return Model from serviceLayer
     *
     * @param title
     * @param description
     * @param category
     * @param price
     * @param image
     * @return
     */
    @Override
    public Product createProduct(String title, String description, String category, String price, String image) {
        // S1. Create FakeStore DTO Object
        FakeStoreProductDTO requestBody = new FakeStoreProductDTO();
        requestBody.setTitle(title);
        requestBody.setDescription(description);
        requestBody.setImage(image);
        requestBody.setPrice(String.valueOf(price));

        // S2. Call FakeStore API
        FakeStoreProductDTO response = restTemplate.postForObject("https://fakestoreapi.com/products",
                requestBody, FakeStoreProductDTO.class);


        // S3. Get ProductModel
        Product product = ProductMapper.mapToProduct(response);

        // S4. Return Product
        return product;
    }
}
