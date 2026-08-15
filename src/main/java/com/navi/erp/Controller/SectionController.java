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

import com.navi.erp.Dto.CreateSectionDto;
import com.navi.erp.Dto.SectionDto;
import com.navi.erp.Service.Impl.SectionServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/courses/{CourseId}/sections")
@AllArgsConstructor
public class SectionController {
    private final SectionServiceImpl service;

    @PostMapping
    public ResponseEntity<SectionDto> createSection(@PathVariable Long CourseId, @RequestBody CreateSectionDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.CreateSection(CourseId, dto));
    };

    @GetMapping
    public ResponseEntity<List<SectionDto>> getSectionById(@PathVariable Long CourseId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getSectionById(CourseId));

    };

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSection(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteSection(id));
    }
}