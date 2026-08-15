package com.navi.erp.Dto;

import com.navi.erp.Entity.Programs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private Long Id;
    private String Course;
    private Programs programs;

}
