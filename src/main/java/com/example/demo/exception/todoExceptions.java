package com.example.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class todoExceptions extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;

    public todoExceptions(String message, HttpStatus httpStatus){
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
