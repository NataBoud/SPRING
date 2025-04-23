package com.example.projetstudents.controller;


import com.example.projetstudents.model.Student;
import com.example.projetstudents.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class StudentController {
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/detail/{studentId}")
    public String detail(@PathVariable UUID studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        model.addAttribute("student", student);
        return "details";
    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/form")
    public String form(Model model) {
        model.addAttribute("student", new Student());
        return "inscription";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("student") Student student) {
//        System.out.println(student);
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @RequestMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @RequestMapping("/search")
    public String searchContact(@RequestParam(name = "studentName", required = false) String name, Model model) {
        Student student = studentService.getStudentByName(name);
        model.addAttribute("student", student);
        return "details";
    }
//    @RequestMapping("/inscription")
//    public String inscription() {
//        return "inscription";
//    }
}
