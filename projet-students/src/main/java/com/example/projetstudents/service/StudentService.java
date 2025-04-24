package com.example.projetstudents.service;

import com.example.projetstudents.dao.StudentRepository;
import com.example.projetstudents.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Student::getId).reversed())
                .toList();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public List<Student> getStudentsByName(String name) {
//        return studentRepository.findAll().stream()
//                .filter(student -> student.getName().toLowerCase().contains(name.toLowerCase()))
//                .toList();
        return studentRepository.findAllByName(name);
    }

    public void addOrUpdateStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
