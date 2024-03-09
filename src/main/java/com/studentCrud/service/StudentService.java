package com.studentCrud.service;

import com.studentCrud.payload.StudentDto;

import java.util.List;

public interface StudentService {


    StudentDto createStudent(StudentDto studentDto);

    List<StudentDto> getStudent();

    StudentDto getStudentById(long id);

    void deleteStudentById(long id);

    StudentDto updateStudentById(StudentDto studentDto, long id);
}
