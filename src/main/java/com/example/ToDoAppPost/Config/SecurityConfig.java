package com.example.ToDoAppPost.Config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Configuration
@NoArgsConstructor
@Getter
@Setter
public class SecurityConfig {

    private String jwtSecret = "todo";

}
