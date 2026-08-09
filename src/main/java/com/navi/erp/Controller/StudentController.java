package com.navi.erp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navi.erp.Dto.CreateStudentDto;
import com.navi.erp.Dto.StudentDto;
import com.navi.erp.Service.Impl.StudentServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/students")
@AllArgsConstructor
public class StudentController {
    private final StudentServiceImpl service;

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody CreateStudentDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createStudent(dto));

    };

    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return null;

    }
}
