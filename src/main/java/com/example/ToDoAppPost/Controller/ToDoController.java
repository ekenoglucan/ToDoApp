package com.example.ToDoAppPost.Controller;
import com.example.ToDoAppPost.Documents.ToDo;
import com.example.ToDoAppPost.Request.ToDoAddRequest;
import com.example.ToDoAppPost.Request.ToDoUpdateRequest;
import com.example.ToDoAppPost.Response.ToDoHourResponse;
import com.example.ToDoAppPost.Response.ToDoResponse;
import com.example.ToDoAppPost.Service.ToDoService;
import com.example.ToDoAppPost.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/todo")
@AllArgsConstructor
public class ToDoController {

    private ToDoService toDoService;
    private UserService userService;

    @GetMapping("/{todoid}")
    public ToDoResponse getOneToDo(@PathVariable Long todoid){
        return toDoService.getOneToDo(todoid);
    }

    @PostMapping
    public void addToDo(@RequestBody ToDoAddRequest todo){
        toDoService.addToDo(todo, userService.getAuthenticatedUserId());
    }

    @GetMapping
    public List<ToDo> getAllToDos(){ return toDoService.getAllToDos(userService.getAuthenticatedUserId());}

    @DeleteMapping("/{todoid}")
    public void deleteToDo(@PathVariable Long todoid) {
        toDoService.deleteToDo(todoid);
    }

    @PutMapping("/{todoid}")
    public void updateToDo(@PathVariable Long todoid, @RequestBody ToDoUpdateRequest todo) {
        toDoService.updateToDo(todoid, todo.getText()); }

    @GetMapping("/hours")
    public List<ToDoHourResponse> getTimeToDo() {
        return toDoService.getTimeToDo();
    }

    @GetMapping("/hours/{hour}")
    public List<ToDoResponse> getOneTimeToDo(@PathVariable int hour) {
        return toDoService.getOneTimeToDo(hour);
    }
}
