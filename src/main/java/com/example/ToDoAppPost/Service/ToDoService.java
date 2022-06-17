package com.example.ToDoAppPost.Service;



import com.example.ToDoAppPost.Documents.ToDo;
import com.example.ToDoAppPost.Repository.ToDoRepository;
import com.example.ToDoAppPost.Request.ToDoAddRequest;
import com.example.ToDoAppPost.Response.ToDoHourResponse;
import com.example.ToDoAppPost.Response.ToDoResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Component
public class ToDoService {

    private ToDoRepository toDoRepository;


    public void addToDo(ToDoAddRequest todo) {
        ToDo newToDo = new ToDo();
        newToDo.setText(todo.getText());
        newToDo.setHour(todo.getHour());
        toDoRepository.save(newToDo);
    }

    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    public ToDoResponse getOneToDo(Long todoid) {
        ToDo todo = toDoRepository.findById(todoid).orElse(null);
        return new ToDoResponse(todo);
    }

    public void deleteToDo(Long todoid) {
        toDoRepository.deleteById(todoid);
    }

    public void updateToDo(Long todoid, String text) {
        Optional<ToDo> toDo = toDoRepository.findById(todoid);

        if (toDo.isPresent()) {
            ToDo newToDo = toDo.get();
            newToDo.setText(text);
            toDoRepository.save(newToDo);
        }
    }

    public List<ToDoHourResponse> getTimeToDo() {
        List<ToDoHourResponse> toDoList = new ArrayList<>();
        for(int i =0; i<=24; i++){
            List<ToDo> toDo = toDoRepository.findAllByHour(i);
            if(toDo.size()!=0) {
                ToDoHourResponse toDoHourResponse = new ToDoHourResponse();
                toDoHourResponse.setHour(i);
                toDoHourResponse.setAmount(toDo.size());
                toDoList.add(toDoHourResponse);}
        }
        return toDoList;
    }

}
