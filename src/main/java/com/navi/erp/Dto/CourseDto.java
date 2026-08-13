package com.navi.erp.Dto;

import com.navi.erp.Entity.Programs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CourseDto {
    private Long Id;
    private String Course;
    private Programs programs;

}
