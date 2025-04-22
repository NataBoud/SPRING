package com.example.demo.controller;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/")
    public String home() {return "home";}

    @RequestMapping("/todo")
    public String getTodo(Model model) {
        Todo todo = todoService.getOneTodo();
        model.addAttribute("todo", todo);
        return "todo/details";
    }

    @RequestMapping("/todos")
    @ResponseBody
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos(); // format JSON
    }
}
