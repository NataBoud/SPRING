package com.example.demo.service;

import com.example.demo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    public Todo getOneTodo() {
        return Todo.builder()
                .id(1)
                .name("Réviser Spring Boot")
                .description("Faire un exercice ...")
                .isDone(false)
                .build();
    }

    public List<Todo> getAllTodos() {
        return List.of(
                new Todo(1, "Réviser Spring Boot", "Exercice sur les contrôleurs", false),
                new Todo(2, "Faire du sport", "30 minutes de cardio", true),
                new Todo(3, "Lire un livre", "Continuer le chapitre 4", false)
        );
    }

}
