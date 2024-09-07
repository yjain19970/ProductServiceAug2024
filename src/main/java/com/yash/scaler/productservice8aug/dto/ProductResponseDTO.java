package com.yash.scaler.productservice8aug.dto;

import com.yash.scaler.productservice8aug.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductResponseDTO implements Serializable {
    public Integer id;
    private String title;
    private String description;
    private double price;
    private String imageURL;
    private Category category;
}
