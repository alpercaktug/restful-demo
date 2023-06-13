package io.github.alpercaktug.restfuldemo.service;

import io.github.alpercaktug.restfuldemo.data.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    private Map<UUID, Student> studentMap;

    public StudentServiceImpl() {
        this.studentMap = new HashMap<>();

        Student student1 = Student.builder()
                .studentId(UUID.randomUUID())
                .name("name")
                .surname("surname")
                .age(18).build();

        Student student2 = Student.builder()
                .studentId(UUID.randomUUID())
                .name("name2")
                .surname("surname2")
                .age(18).build();

        studentMap.put(student1.getStudentId(), student1);
        studentMap.put(student2.getStudentId(), student2);
    }

    @Override
    public void deleteStudent(UUID studentId) {
        studentMap.remove(studentId);
    }

    @Override
    public void updateStudent(UUID studentId, Student student) {
        Student existing = studentMap.get(studentId);
        existing.setName(student.getName());
        existing.setSurname(student.getSurname());
        existing.setAge(student.getAge());
    }

    @Override
    public Student createStudent(Student student) {
        Student created = student.builder()
                .studentId(UUID.randomUUID())
                .name(student.getName())
                .surname(student.getSurname())
                .age(student.getAge())
                .build();

        studentMap.put(student.getStudentId(), created);

        return created;

    }

    @Override
    public Student getStudentById(UUID studentId) {
        return studentMap.get(studentId);
    }

    @Override
    public List<Student> listStudents() {
        return new ArrayList<>(studentMap.values());
    }
}
