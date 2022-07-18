package com.example.ToDoAppPost.Service;

import com.example.ToDoAppPost.Documents.User;
import com.example.ToDoAppPost.Exceptions.BusinessException;
import com.example.ToDoAppPost.Exceptions.ErrorCode;
import com.example.ToDoAppPost.Repository.UserRepository;
import com.example.ToDoAppPost.Request.LoginRequest;
import com.example.ToDoAppPost.Request.RegisterRequest;
import com.example.ToDoAppPost.Request.ResetPasswordRequest;
import com.example.ToDoAppPost.Response.AuthResponse;
import com.example.ToDoAppPost.Security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class AuthService {

    private UserService userService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;

    public AuthResponse login(@RequestBody LoginRequest loginRequest){
        User user = userRepository.findByUserMail(loginRequest.getEmail());

        if (user == null) {
            throw new BusinessException(ErrorCode.account_missing, "Email bulunamadı!");
        }

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new BusinessException(ErrorCode.password_mismatch, "Şifre uyuşmuyor!");
        }
        return AuthResponse.builder()
                .id(user.getId())
                .token(jwtService.createToken(user.getId().toString()))
                .build();
    }

    public void register(@RequestBody RegisterRequest registerRequest){
        User existingUser = userRepository.findByUserMail(registerRequest.getUserMail());

        if (existingUser != null) {
            throw new BusinessException(ErrorCode.account_already_exists, "Email zaten bulunuyor!");
        }

        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setUserSurname(registerRequest.getUserSurname());
        user.setUserMail(registerRequest.getUserMail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(user);
    }

    public void resetPassword(Long userId, ResetPasswordRequest body) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.resource_missing, "Kullanıcı Bulunamadı!"));
        System.out.println(userId);
        if (!passwordEncoder.matches(body.getOldPassword(), user.getPassword())) {
            throw new BusinessException(ErrorCode.password_mismatch, "Hatalı Şifre!");
        }

        user.setPassword(passwordEncoder.encode(body.getNewPassword()));
        userRepository.save(user);
    }
}
