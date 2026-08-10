package com.navi.erp.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.CreateStudentDto;
import com.navi.erp.Dto.StudentDto;
import com.navi.erp.Entity.Students;
import com.navi.erp.Repository.StudentRepo;
import com.navi.erp.Service.StudentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo sRepo;

    @Override
    public StudentDto createStudent(CreateStudentDto dto) {
        Students students = new Students();
        students.setName(dto.getName());
        students.setFatherName(dto.getFatherName());
        students.setAddress(dto.getAddress());
        students.setMobile(dto.getMobile());
        Students saveStudent = sRepo.save(students);
        return new StudentDto(saveStudent.getId(), saveStudent.getName(), saveStudent.getFatherName(),
                saveStudent.getMobile(), saveStudent.getAddress());
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Students> students = sRepo.findAll();
        List<StudentDto> dtoList = new ArrayList<>();
        for (Students student : students) {
            StudentDto dto = new StudentDto(student.getId(), student.getName(), student.getFatherName(),
                    student.getMobile(), student.getAddress());
            dtoList.add(dto);
        }
        return dtoList;

    }

    @Override
    public StudentDto updateStudents(Long id, CreateStudentDto dto) {
        Students students = sRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Student Not Found"));
        students.setName(dto.getName());
        students.setAddress(dto.getAddress());
        students.setFatherName(dto.getFatherName());
        students.setMobile(dto.getMobile());
        Students saveStudent = sRepo.save(students);

        return new StudentDto(saveStudent.getId(), saveStudent.getName(), saveStudent.getFatherName(),
                saveStudent.getMobile(), saveStudent.getAddress());

    }

    public StudentDto patchStudent(Long id, CreateStudentDto dto) {
        Students students = sRepo.findById(id).orElseThrow();
        if (dto.getName() != null) {
            students.setName(dto.getName());
        }
        if (dto.getAddress() != null) {
            students.setAddress(dto.getAddress());
        }
        if (dto.getFatherName() != null) {
            students.setFatherName(dto.getFatherName());
        }
        if (dto.getMobile() != null) {
            students.setMobile(dto.getMobile());
        }
        return new StudentDto(students.getId(), students.getName(), students.getFatherName(), students.getMobile(),
                students.getAddress());

    };

}
