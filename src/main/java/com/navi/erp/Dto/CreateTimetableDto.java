package com.navi.erp.Dto;

import java.time.LocalTime;

import com.navi.erp.Enum.Days;

import lombok.Data;

@Data
public class CreateTimetableDto {

    private Days day;

    private Long programId;
    private Long courseId;
    private Long sectionId;

    private LocalTime startFrom;
    private LocalTime endTo;

    private Long teacherId;
    private Long subjectId;
}