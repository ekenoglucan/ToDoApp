package com.example.ToDoAppPost.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class BusinessException extends RuntimeException  {
    private final ErrorCode errorCode;
    private final String message;

    public int getStatusCode() {
        return errorCode.getHttpCode();
    }
}
