package com.example.ToDoAppPost.Repository;
import com.example.ToDoAppPost.Documents.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Component
public interface ToDoRepository extends JpaRepository<ToDo,Long> {

    ToDo save(ToDo todo);

    List<ToDo> findAllByHour(int hour);
}
