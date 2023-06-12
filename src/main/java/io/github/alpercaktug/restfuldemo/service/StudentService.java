package io.github.alpercaktug.restfuldemo.service;

import io.github.alpercaktug.restfuldemo.data.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    List<Student> listStudents();

    Student getStudentById(UUID studentId);

    Student createStudent(Student student);

}
