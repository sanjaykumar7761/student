package com.studentCrud.controller;

import com.studentCrud.payload.StudentDto;
import com.studentCrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //http://localhost:8081/api/students
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
         StudentDto dto= studentService.createStudent(studentDto);

         return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudent(){
        List<StudentDto> dto= studentService.getStudent();

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable long id){
        StudentDto dto= studentService.getStudentById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable long id){
                studentService.deleteStudentById(id);
                return new ResponseEntity<>("student is deleted",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@RequestBody StudentDto studentDto,@PathVariable long id){
       StudentDto dto= studentService.updateStudentById(studentDto,id);
       return new ResponseEntity<>(dto,HttpStatus.OK);
    }

}
