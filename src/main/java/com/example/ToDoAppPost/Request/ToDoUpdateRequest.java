package com.example.ToDoAppPost.Request;
import lombok.Data;

@Data
public class ToDoUpdateRequest {
    private String text;
    private int hour;
}