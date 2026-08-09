package com.navi.erp.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateStudentDto {
    private String Name;
    private String FatherName;
    private String Mobile;
    private String Address;
}
