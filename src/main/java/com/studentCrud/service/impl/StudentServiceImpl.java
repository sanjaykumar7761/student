package com.studentCrud.service.impl;

import com.studentCrud.entity.Student;
import com.studentCrud.payload.StudentDto;
import com.studentCrud.repository.StudentRepository;
import com.studentCrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student=mapToEntity(studentDto);
        Student studentSaved = studentRepository.save(student);
        return mapToDto(studentSaved);
    }

    @Override
    public List<StudentDto> getStudent() {
        List<Student> student = studentRepository.findAll();
        return student.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("this student id is not present")
        );

        return mapToDto(student);
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudentById(StudentDto studentDto, long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("this Student Id is not present")
        );
        student.setName(studentDto.getName());
        student.setEducation(studentDto.getEducation());
        student.setLocation(studentDto.getLocation());

        return mapToDto(student);
    }

    Student mapToEntity (StudentDto dto){
        Student student=new Student();
        student.setName(dto.getName());
        student.setEducation(dto.getEducation());
        student.setLocation(dto.getLocation());
        return student;
    }

    StudentDto mapToDto (Student student){
        StudentDto dto=new StudentDto();
             dto.setId(student.getId());
             dto.setName(student.getName());
             dto.setEducation(student.getEducation());
             dto.setLocation(student.getLocation());
             return dto;
    }
}
