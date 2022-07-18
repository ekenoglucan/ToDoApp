package com.example.ToDoAppPost.Request;

import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@ToString
public class RegisterRequest {
    @NotEmpty(message = "İsim boş olamaz!")
    private String userName;

    private String userSurname;

    @Email(message = "Geçersiz email!")
    @NotEmpty(message = "Email boş olamaz!")
    private String userMail;

    @NotEmpty(message = "Şifre boş olamaz!")
    private String password;
}
