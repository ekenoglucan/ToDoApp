package com.example.ToDoAppPost.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;

@ControllerAdvice
public class ToDoExceptionHandler extends ResponseEntityExceptionHandler {

    Date date = new Date(System.currentTimeMillis());

    @ExceptionHandler(value = {ToDoBadRequestException.class})
    public ResponseEntity<Object> handleToDoBadRequestException(ToDoBadRequestException e){
            ToDoException toDoException = new ToDoException(e.getMessage(),
                    HttpStatus.BAD_REQUEST,
                       date
       );
       return new ResponseEntity<>(toDoException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ToDoNotFoundException.class})
    public ResponseEntity<Object> handleToDoNotFoundException(ToDoNotFoundException e){
                ToDoException toDoException = new ToDoException(e.getMessage(),
                    HttpStatus.NOT_FOUND,
                        date
        );
        return new ResponseEntity<>(toDoException, HttpStatus.NOT_FOUND);
    }
}
