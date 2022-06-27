package com.example.ToDoAppPost.Exceptions;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ToDoException {
    private final String message;
    private final HttpStatus  httpStatus;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT+03:00")
    private Date timestamp;
}
