package com.yash.scaler.productservice8aug.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // this tells MYSQL that auto-increament
    private Integer id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private boolean isDeleted;

}
