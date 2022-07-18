package com.example.ToDoAppPost.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuthResponse {
    private long id;
    private String token;
}