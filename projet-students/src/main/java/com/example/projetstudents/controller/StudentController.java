package com.example.projetstudents.controller;


import com.example.projetstudents.model.Student;
import com.example.projetstudents.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String form(@RequestParam(value = "studentId", required = false) UUID studentId, Model model) {
        if (studentId != null) {
            Student existingStudent = studentService.getStudentById(studentId);
            model.addAttribute("student", existingStudent);
        } else {
            model.addAttribute("student", new Student());
        }
        return "inscription";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "inscription";
        } else {
            studentService.addStudent(student);
        }
        return "redirect:/students";
    }

    @RequestMapping("/students")
    public String listStudents(@RequestParam(name = "search", required = false) String search, Model model ) {
       List<Student> students;

        if (search == null || search.isBlank()) {
            students = studentService.getAllStudents();
        } else {
            students = studentService.getStudentsByName(search);
            model.addAttribute("search", search);
            if (students.isEmpty()) {
                model.addAttribute("noResult", true);
            }
        }
        model.addAttribute("students", students);
        return "students";
    }


    @RequestMapping("/update/{studentId}")
    public String update(@PathVariable UUID studentId) {
        return "redirect:/form?studentId=" + studentId;
    }

    @RequestMapping("/delete/{studentId}")
    public String delete(@PathVariable UUID studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

}
