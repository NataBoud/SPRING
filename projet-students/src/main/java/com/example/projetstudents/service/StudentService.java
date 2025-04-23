package com.example.projetstudents.service;

import com.example.projetstudents.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    private final Map<UUID, Student> students;

    public StudentService() {
        students = new HashMap<>();

        Student studentA = Student.builder()
                .id(UUID.randomUUID())
                .name("Toto Toto")
                .age(20)
                .email("toto@email.com").build();

        Student studentB = Student.builder()
                .id(UUID.randomUUID())
                .name("Tata Tata")
                .age(19)
                .email("tata@email.com").build();

        Student studentC = Student.builder()
                .id(UUID.randomUUID())
                .name("Titi Titi")
                .age(19)
                .email("titi@email.com").build();

        students.put(studentA.getId(), studentA);
        students.put(studentB.getId(), studentB);
        students.put(studentC.getId(), studentC);
    }
    public List<Student> getAllStudents() {
        return students.values().stream().toList() ;
    }

    public Student getStudentById(UUID id) {
        return students.get(id);
    }
}
