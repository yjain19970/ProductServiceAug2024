package com.yash.scaler.productservice8aug.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
    private String message;
    private String code;

    public ErrorDTO() {

    }
}
