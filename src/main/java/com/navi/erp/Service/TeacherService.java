package com.navi.erp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.CreateTeacherDto;
import com.navi.erp.Dto.TeacherDto;

@Service
public interface TeacherService {
    public TeacherDto createTeacher(CreateTeacherDto dto);

    public List<TeacherDto> getAllTeachers();

    public TeacherDto updateTeachers(Long id, CreateTeacherDto dto);

    public TeacherDto patchTeacher(Long id, CreateTeacherDto dto);

    public String deleteTeacher(Long id);
}
