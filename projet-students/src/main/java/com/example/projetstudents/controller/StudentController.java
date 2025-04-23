package com.example.projetstudents.controller;


import com.example.projetstudents.model.Student;
import com.example.projetstudents.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
public class StudentController {
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @RequestMapping("/students")
//    @ResponseBody
//    public List<Student> getAllStudents() {
//        return studentService.getAllStudents();
//    }

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

    @RequestMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @RequestMapping("/inscription")
    public String inscription() {
        return "inscription";
    }

}
