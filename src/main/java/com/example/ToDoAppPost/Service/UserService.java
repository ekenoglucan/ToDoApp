package com.example.ToDoAppPost.Service;

import com.example.ToDoAppPost.Documents.User;
import com.example.ToDoAppPost.Exceptions.BusinessException;
import com.example.ToDoAppPost.Exceptions.ErrorCode;
import com.example.ToDoAppPost.Repository.UserRepository;
import com.example.ToDoAppPost.Request.UpdateUserRequest;
import com.example.ToDoAppPost.Response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserResponse getUser(long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.resource_missing, "Yeterli yetki bulunmuyor!"));

        return new UserResponse(user);
    }

    public void updateUser(long userId, UpdateUserRequest body) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.resource_missing, "Yeterli yetki bulunmuyor!"));

        user.setUserName(body.getFirstName());
        user.setUserSurname(body.getLastName());
        userRepository.save(user);
    }

    public Long getAuthenticatedUserId() {
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal.equals("anonymousUser")) {
            throw new BusinessException(ErrorCode.unauthorized, "Yeterli yetki bulunmuyor!");
        }
        return Long.parseLong(principal);
    }
}