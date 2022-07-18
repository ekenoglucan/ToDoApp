package com.example.ToDoAppPost.Request;

import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.NotEmpty;

@Data
@ToString
public class ResetPasswordRequest {
    @NotEmpty(message = "Eski şifre boş olamaz!")
    private String oldPassword;

    @NotEmpty(message = "Yeni şifre boş olamaz!")
    private String newPassword;
}
