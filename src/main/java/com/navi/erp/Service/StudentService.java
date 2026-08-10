package com.navi.erp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.CreateStudentDto;
import com.navi.erp.Dto.StudentDto;

@Service
public interface StudentService {
    public StudentDto createStudent(CreateStudentDto dto);

    public List<StudentDto> getAllStudents();

    public StudentDto updateStudents(Long id, CreateStudentDto dto);

    public StudentDto patchStudent(Long id, CreateStudentDto dto);
}
