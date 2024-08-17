package com.yash.scaler.productservice8aug.advise;

import com.yash.scaler.productservice8aug.dto.ErrorDTO;
import com.yash.scaler.productservice8aug.exception.InvalidProductIdException;
import com.yash.scaler.productservice8aug.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ErrorDTO> handleInvalidProductIdException(InvalidProductIdException e) {
        ErrorDTO dto = new ErrorDTO();
        dto.setCode("some_status_code"); // this is not HTTP status code.
        dto.setMessage(e.getMessage());

        return new ResponseEntity<>(dto, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(ProductNotFoundException exception) {
        ErrorDTO dto = new ErrorDTO();
        dto.setCode("some_status_code"); // this is not HTTP status code.
        dto.setMessage("Product Not Found..");
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

}
