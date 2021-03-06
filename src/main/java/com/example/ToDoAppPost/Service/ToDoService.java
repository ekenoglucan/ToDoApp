package com.example.ToDoAppPost.Service;
import com.example.ToDoAppPost.Documents.ToDo;
import com.example.ToDoAppPost.Documents.User;
import com.example.ToDoAppPost.Exceptions.BusinessException;
import com.example.ToDoAppPost.Exceptions.ErrorCode;
import com.example.ToDoAppPost.Repository.ToDoRepository;
import com.example.ToDoAppPost.Repository.UserRepository;
import com.example.ToDoAppPost.Request.ToDoAddRequest;
import com.example.ToDoAppPost.Response.ToDoHourResponse;
import com.example.ToDoAppPost.Response.ToDoResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class ToDoService {

    private ToDoRepository toDoRepository;
    private UserRepository userRepository;

    public void addToDo(ToDoAddRequest todo, Long userId) {
        User currentUser = userRepository.findById(userId).orElseThrow(() -> new BusinessException(ErrorCode.resource_missing, "Kullanıcı bulunamadı"));
        if (todo.getText().isEmpty() || todo.getHour() == 0) {
            throw new BusinessException(ErrorCode.resource_missing,"Missing information!");
        }

        ToDo newToDo = new ToDo();
        newToDo.setText(todo.getText());
        newToDo.setHour(todo.getHour());
        newToDo.setUser(currentUser);
        toDoRepository.save(newToDo);
    }

    public List<ToDo> getAllToDos(Long userId) {

        userRepository.findById(userId).orElseThrow(() -> new BusinessException(ErrorCode.resource_missing, "Kullanıcı bulunamadı"));

        return toDoRepository.findAllByUser_id(userId);
    }

    public ToDoResponse getOneToDo(Long todoid) {
        ToDo todo = toDoRepository.findById(todoid).orElseThrow(() -> new BusinessException(ErrorCode.resource_missing,"Todo can not be shown due to not found todo with id :" + todoid));
        return new ToDoResponse(todo);
    }

    public void deleteToDo(Long todoid) {
        toDoRepository.findById(todoid).orElseThrow(() -> new BusinessException(ErrorCode.resource_missing,"Todo can not be deleted due to not found todo with id :" + todoid));
        toDoRepository.deleteById(todoid);
    }

    public void updateToDo(Long todoid, String text) {

        Optional<ToDo> toDo = toDoRepository.findById(todoid);

        if (!toDo.isPresent()) {
            throw new BusinessException(ErrorCode.resource_missing,"Todo can not be updated due to not found todo with id :" + todoid); }
        if (text.isEmpty()) {
            throw new BusinessException(ErrorCode.resource_missing,"Todo field can not be empty!");}

        ToDo newToDo = toDo.get();
        newToDo.setText(text);
        toDoRepository.save(newToDo);
    }

    public List<ToDoHourResponse> getTimeToDo() {

        List<ToDoHourResponse> toDoList = new ArrayList<>();

        for (int i = 0; i < 24; i++) {
            List<ToDo> toDo = toDoRepository.findAllByHour(i);
            ToDoHourResponse toDoHourResponse = new ToDoHourResponse();
            toDoHourResponse.setHour(i);
            toDoHourResponse.setAmount(toDo.size());
            toDoList.add(toDoHourResponse);
        }
        return toDoList;
    }

    public List<ToDoResponse> getOneTimeToDo(int hour) {

        if (hour < 0 || hour>23) {
            throw new BusinessException(ErrorCode.resource_missing,"Invalid hour!");
        }
        List<ToDoResponse> toDoList = new ArrayList<>();
        List<ToDo> toDo = toDoRepository.findAllByHour(hour);
        for (int i = 0; i < toDo.size(); i++) {
            ToDoResponse toDoResponse = new ToDoResponse();
            toDoResponse.setID(toDo.get(i).getId());
            toDoResponse.setText(toDo.get(i).getText());
            toDoResponse.setHour(hour);
            toDoList.add(toDoResponse);
        }
        return toDoList;
    }
}