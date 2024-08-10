package com.yash.scaler.productservice8aug.dto;

import com.yash.scaler.productservice8aug.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private Integer id;
    private String title;
    private String description;
    private double price;
    private String imageURL;
    private Category category;
}
