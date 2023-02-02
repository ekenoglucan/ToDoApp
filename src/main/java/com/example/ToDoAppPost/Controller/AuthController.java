package com.example.ToDoAppPost.Controller;

import com.example.ToDoAppPost.Request.LoginRequest;
import com.example.ToDoAppPost.Request.RegisterRequest;
import com.example.ToDoAppPost.Request.ResetPasswordRequest;
import com.example.ToDoAppPost.Response.AuthResponse;
import com.example.ToDoAppPost.Service.AuthService;
import com.example.ToDoAppPost.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;
    private UserService userService;

    @Autowired
    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest registerRequest){ authService.register(registerRequest); }

    @PostMapping("/reset-password")
    public void resetPassword(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest) {
        authService.resetPassword(userService.getAuthenticatedUserId(), resetPasswordRequest);
    }

}
