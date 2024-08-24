package com.yash.scaler.productservice8aug.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Category extends BaseModel implements Serializable {
    private String title;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    List<Product> products; // CATEGORY <> PRODUCT
}




