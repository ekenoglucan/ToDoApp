package com.example.ToDoAppPost.Response;

import com.example.ToDoAppPost.Documents.ToDo;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ToDoResponse {

    private Long ID;
    private String text;
    private int hour;

    public ToDoResponse(ToDo todo){

        this.ID = todo.getId();
        this.text = todo.getText();
        this.hour = todo.getHour();

    }
}
