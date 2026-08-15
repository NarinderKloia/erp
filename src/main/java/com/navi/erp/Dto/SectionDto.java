package com.navi.erp.Dto;

import com.navi.erp.Entity.Courses;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SectionDto {
    private Long Id;
    private String Section;
    private Courses courses;

}
