package com.example.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author yuriismac on 2020-07-16.
 * @project demo
 */
@RestControllerAdvice
public class ErrorHandlingController {

    @ExceptionHandler({ResponseStatusException.class})
    public ResponseEntity<ErrorResponse> handleResponseStatusException(ResponseStatusException  ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getReason());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        //works only for cases when error is in one field
        FieldError fieldError = ex.getBindingResult()
                .getFieldError();
        String message = "object" +
                fieldError.getObjectName() +
                ", field" +
                fieldError.getField() +
                " - " +
                fieldError.getDefaultMessage();
        ErrorResponse errorResponse = new ErrorResponse(message);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @Data
    @AllArgsConstructor
    private static class ErrorResponse{
        private String message;
    }

}
