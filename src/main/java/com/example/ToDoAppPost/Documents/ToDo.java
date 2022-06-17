package com.example.ToDoAppPost.Documents;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "toDo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name= "todo")
    private String text;

    @Column(name= "hour")
    private int hour;

}




