package com.example.ToDoAppPost.Response;

import com.example.ToDoAppPost.Exceptions.ErrorCode;
import lombok.Data;
import java.util.Date;

@Data
public class ErrorResponse {
    private Date timestamp;
    private int statusCode;
    private ErrorCode errorCode;
    private String message;
}