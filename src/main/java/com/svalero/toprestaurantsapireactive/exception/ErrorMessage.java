package com.svalero.toprestaurantsapireactive.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    private int code;
    private  String message;
    private Map<String, String> errors;


    public ErrorMessage(int code, String message) {
        this.code = code;
        this.message = message;
        errors = new HashMap<>();
    }
}
