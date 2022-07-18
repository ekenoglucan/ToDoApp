package com.example.ToDoAppPost.Repository;

import com.example.ToDoAppPost.Documents.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserMail(String email);

}
