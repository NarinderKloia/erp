package com.navi.erp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navi.erp.Dto.CreateSubjectDto;
import com.navi.erp.Dto.SubjectDto;
import com.navi.erp.Service.SubjectService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/subjects")
@AllArgsConstructor
public class SubjectController {
    public final SubjectService service;

    @PostMapping
    public ResponseEntity<SubjectDto> createSubject(@RequestBody CreateSubjectDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createSubject(dto));
    }
    @GetMapping
    public ResponseEntity<List<SubjectDto>> getAllSubject() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllSubject());

    }
}
