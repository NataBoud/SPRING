package com.example.projetstudents.service;

import com.example.projetstudents.model.Student;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class StudentService {
    private final Map<UUID, Student> students;

    public StudentService(Map<UUID, Student> students) {
        this.students = students;
    }
}
