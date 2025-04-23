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
                .name("Emma Dupont")
                .age(20)
                .email("emma.dupont@example.com")
                .build();

        Student studentB = Student.builder()
                .id(UUID.randomUUID())
                .name("Lucas Martin")
                .age(19)
                .email("lucas.martin@example.com")
                .build();

        Student studentC = Student.builder()
                .id(UUID.randomUUID())
                .name("Sofia Bernard")
                .age(21)
                .email("sofia.bernard@example.com")
                .build();

        Student studentD = Student.builder()
                .id(UUID.randomUUID())
                .name("Elena Renard")
                .age(21)
                .email("sofia.bernard@example.com")
                .build();

        Student studentE = Student.builder()
                .id(UUID.randomUUID())
                .name("Victor Berd")
                .age(21)
                .email("sofia.bernard@example.com")
                .build();

        students.put(studentA.getId(), studentA);
        students.put(studentB.getId(), studentB);
        students.put(studentC.getId(), studentC);
        students.put(studentD.getId(), studentD);
        students.put(studentE.getId(), studentE);
    }
    public List<Student> getAllStudents() {
        return students.values().stream().toList() ;
    }

    public Student getStudentById(UUID id) {
        return students.get(id);
    }

    public Student getStudentByName(String name) {
        return students.values().stream().filter(student -> student.getName().equals(name)).findFirst().orElse(null);
    }

    public void addStudent(Student student) {
        student.setId(UUID.randomUUID());
        students.put(student.getId(), student);
    }
}
