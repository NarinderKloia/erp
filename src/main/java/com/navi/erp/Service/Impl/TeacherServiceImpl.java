package com.navi.erp.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.navi.erp.Dto.CreateTeacherDto;
import com.navi.erp.Dto.TeacherDto;
import com.navi.erp.Entity.Teachers;
import com.navi.erp.Repository.TeacherRepo;
import com.navi.erp.Service.TeacherService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepo sRepo;

    @Override
    public TeacherDto createTeacher(CreateTeacherDto dto) {
        Teachers Teachers = new Teachers();
        Teachers.setName(dto.getName());
        Teachers.setFatherName(dto.getFatherName());
        Teachers.setAddress(dto.getAddress());
        Teachers.setMobile(dto.getMobile());
        Teachers saveTeacher = sRepo.save(Teachers);
        return new TeacherDto(saveTeacher.getId(), saveTeacher.getName(), saveTeacher.getFatherName(),
                saveTeacher.getMobile(), saveTeacher.getAddress());
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        List<Teachers> Teachers = sRepo.findAll();
        List<TeacherDto> dtoList = new ArrayList<>();
        for (Teachers Teacher : Teachers) {
            TeacherDto dto = new TeacherDto(Teacher.getId(), Teacher.getName(), Teacher.getFatherName(),
                    Teacher.getMobile(), Teacher.getAddress());
            dtoList.add(dto);
        }
        return dtoList;

    }

    @Override
    public TeacherDto updateTeachers(Long id, CreateTeacherDto dto) {
        Teachers Teachers = sRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Teacher Not Found"));
        Teachers.setName(dto.getName());
        Teachers.setAddress(dto.getAddress());
        Teachers.setFatherName(dto.getFatherName());
        Teachers.setMobile(dto.getMobile());
        Teachers saveTeacher = sRepo.save(Teachers);

        return new TeacherDto(saveTeacher.getId(), saveTeacher.getName(), saveTeacher.getFatherName(),
                saveTeacher.getMobile(), saveTeacher.getAddress());

    }

    public TeacherDto patchTeacher(Long id, CreateTeacherDto dto) {
        Teachers Teachers = sRepo.findById(id).orElseThrow();
        if (dto.getName() != null) {
            Teachers.setName(dto.getName());
        }
        if (dto.getAddress() != null) {
            Teachers.setAddress(dto.getAddress());
        }
        if (dto.getFatherName() != null) {
            Teachers.setFatherName(dto.getFatherName());
        }
        if (dto.getMobile() != null) {
            Teachers.setMobile(dto.getMobile());
        }
        return new TeacherDto(Teachers.getId(), Teachers.getName(), Teachers.getFatherName(), Teachers.getMobile(),
                Teachers.getAddress());

    }

    @Override
    public String deleteTeacher(Long id) {
        sRepo.deleteById(id);
        return null;

    };

}
