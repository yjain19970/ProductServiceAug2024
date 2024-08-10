package com.yash.scaler.productservice8aug.service;

import com.yash.scaler.productservice8aug.model.Product;
import org.springframework.stereotype.Service;


@Service // that this is a special class
public class FakeStoreService implements ProductService {


    @Override
    public Product getProductById(Long id) {
        /**
         *
         * 1. call to fakestore api
         * 2. get the response
         * 3. map the response to our model
         * 4. return the model service layer
         *
         */

        //s1.


        return null;
    }

    @Override
    public void createProduct() {

    }
}
