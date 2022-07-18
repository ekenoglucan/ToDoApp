package com.example.ToDoAppPost.Documents;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name="toDo")
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name= "toDo")
    private String text;

    @Column(name= "hour")
    private int hour;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;
}




