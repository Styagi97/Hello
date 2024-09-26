/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.services.UserServices.exceptions;

import com.user.services.UserServices.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author admin
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
   
    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourcesNotFoundException(ResourcesNotFoundException exception){
        
        String message = exception.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
     
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
