package com.example.ToDoAppPost.Exceptions;

public class ToDoNotFoundException extends RuntimeException  {
    public ToDoNotFoundException(String message) {
        super(message);
    }
}
