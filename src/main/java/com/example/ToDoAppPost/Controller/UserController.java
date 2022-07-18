package com.example.ToDoAppPost.Controller;

import com.example.ToDoAppPost.Request.UpdateUserRequest;
import com.example.ToDoAppPost.Response.UserResponse;
import com.example.ToDoAppPost.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/me")
    public UserResponse getUser() {
        return userService.getUser(userService.getAuthenticatedUserId());
    }

    @PutMapping("/me")
    public void updateUser(@RequestBody UpdateUserRequest body) {
        userService.updateUser(userService.getAuthenticatedUserId(), body);
    }

}
