package com.learn.webservices.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomGlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> customHandleNotValid(MethodArgumentNotValidException ex, WebRequest request) {
        List<ApiError> apiErrors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.toString(), error.getDefaultMessage());
            apiErrors.add(apiError);
        });

        ErrorResponse errorResponse = new ErrorResponse(apiErrors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
