package com.navi.erp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.navi.erp.Dto.CreateTimetableDto;
import com.navi.erp.Entity.TimeTable;
import com.navi.erp.Service.TimetableService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/timetable")
@AllArgsConstructor
public class TimetableController {

    private final TimetableService timetableService;

    @PostMapping
    public ResponseEntity<TimeTable> createTimetable(
            @RequestBody CreateTimetableDto dto) {

        return new ResponseEntity<>(
                timetableService.createTimetable(dto),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TimeTable>> getAllTimetables() {

        return ResponseEntity.ok(
                timetableService.getAllTimetables());
    }
}