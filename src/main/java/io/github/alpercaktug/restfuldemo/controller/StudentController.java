package io.github.alpercaktug.restfuldemo.controller;

import io.github.alpercaktug.restfuldemo.data.Student;
import io.github.alpercaktug.restfuldemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/api/v1/student")
    public ResponseEntity createNewStudent(@RequestBody Student student){

        Student createdStudent = studentService.createStudent(student);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/student/" + createdStudent.getStudentId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/student/{studentId}")
    public Student getStudentById(@PathVariable("studentId") UUID studentId){
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/api/v1/student")
    public List<Student> getAllStudents(){
        return studentService.listStudents();
    }
}
