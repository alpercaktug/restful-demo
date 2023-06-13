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

    private static final String STUDENT_PATH = "/api/v1/student";
    private static final String STUDENT_PATH_ID = STUDENT_PATH + "/{studentId}";

    @DeleteMapping(STUDENT_PATH_ID)
    public ResponseEntity deleteStudent(@PathVariable UUID studentId){

        studentService.deleteStudent(studentId);

        return new ResponseEntity(HttpStatus.OK);
    }


    @PutMapping(STUDENT_PATH_ID)
    public ResponseEntity updateStudent(@PathVariable UUID studentId, @RequestBody Student student){

        studentService.updateStudent(studentId, student);

        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping(STUDENT_PATH)
    public ResponseEntity createNewStudent(@RequestBody Student student){

        Student createdStudent = studentService.createStudent(student);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", STUDENT_PATH + createdStudent.getStudentId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping(STUDENT_PATH_ID)
    public Student getStudentById(@PathVariable("studentId") UUID studentId){
        return studentService.getStudentById(studentId);
    }

    @GetMapping(STUDENT_PATH)
    public List<Student> getAllStudents(){
        return studentService.listStudents();
    }
}
