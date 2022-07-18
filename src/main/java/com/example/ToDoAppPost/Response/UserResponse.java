package com.example.ToDoAppPost.Response;
import com.example.ToDoAppPost.Documents.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponse {
    private Long id;
    private String userName;
    private String userSurname;
    private String userMail;
    private String password;

    public UserResponse(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.userSurname = user.getUserSurname();
        this.userMail = user.getUserMail();
        this.password = user.getPassword();
    }
}
