package com.example.ToDoAppPost.Repository;
import com.example.ToDoAppPost.Documents.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Long> {

    List<ToDo> findAllByHour(int hour);
}
