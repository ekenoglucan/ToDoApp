package com.example.ToDoAppPost.Documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "userName")
    private String userName;

    @Column(name= "userSurname")
    private String userSurname;

    @Column(name= "userMail")
    private String userMail;

    @Column(name= "password")
    private String password;
}
