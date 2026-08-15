package com.navi.erp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navi.erp.Dto.CreateCourseDto;
import com.navi.erp.Dto.CourseDto;
import com.navi.erp.Service.Impl.CourseServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/programs/{programId}/courses")
@AllArgsConstructor
public class CourseController {
    private final CourseServiceImpl service;

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@PathVariable Long programId, @RequestBody CreateCourseDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.CreateCourse(programId, dto));
    };

    @GetMapping
    public ResponseEntity<List<CourseDto>> getCourseById(@PathVariable Long programId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getCourseById(programId));

    };

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteCourse(id));
    }
}