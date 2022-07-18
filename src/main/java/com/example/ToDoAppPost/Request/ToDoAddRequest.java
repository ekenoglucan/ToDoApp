package com.example.ToDoAppPost.Request;
import lombok.Data;

@Data
public class ToDoAddRequest {
    private String text;
    private int hour;
}