package com.example.ToDoAppPost.Controller;

import com.example.ToDoAppPost.Exceptions.BusinessException;
import com.example.ToDoAppPost.Response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> customHandleBusinessException(BusinessException ex, WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setErrorCode(ex.getErrorCode());
        errorResponse.setStatusCode(ex.getStatusCode());
        errorResponse.setTimestamp(new Date());
        return new ResponseEntity<>(errorResponse, HttpStatus.resolve(ex.getStatusCode()));
    }
}