package com.yash.scaler.productservice8aug.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;

    private String title;
    private String description;
    private double price;
    private String imageURL;


    private Category category;
}
