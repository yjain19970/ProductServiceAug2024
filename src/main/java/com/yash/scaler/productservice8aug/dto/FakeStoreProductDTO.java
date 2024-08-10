package com.yash.scaler.productservice8aug.dto;

import com.yash.scaler.productservice8aug.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FakeStoreProductDTO {
    private int id;
    private String title;
    private String description;
    private String price;
    private List<String> images;
    private Category category;

}
