package com.example.ToDoAppPost.Exceptions;

public class ToDoBadRequestException extends  RuntimeException{
    public ToDoBadRequestException(String message) {
        super(message);
    }
}

