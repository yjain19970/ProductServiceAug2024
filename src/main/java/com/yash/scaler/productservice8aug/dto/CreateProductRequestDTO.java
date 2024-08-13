package com.yash.scaler.productservice8aug.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDTO {
    private String title; // YES
    private String price; // YES
    private String category; // YES
    private String description; // YES
    private String image; // discuss this later on why to add (null)
}
