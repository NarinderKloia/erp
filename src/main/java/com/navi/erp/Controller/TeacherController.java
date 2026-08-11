package com.navi.erp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navi.erp.Dto.CreateTeacherDto;
import com.navi.erp.Dto.TeacherDto;
import com.navi.erp.Service.Impl.TeacherServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/teachers")
@AllArgsConstructor
public class TeacherController {
    private final TeacherServiceImpl service;

    @PostMapping
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody CreateTeacherDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTeacher(dto));

    };

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeachers() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllTeachers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDto> updateTeachers(@PathVariable Long id, @RequestBody CreateTeacherDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateTeachers(id, dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TeacherDto> patchTeacher(@PathVariable Long id, @RequestBody CreateTeacherDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.patchTeacher(id, dto));

    };

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long id) {
        service.deleteTeacher(id);
        return ResponseEntity.status(HttpStatus.OK).body("Teacher Deleted Permanently");

    }

}
