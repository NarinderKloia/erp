package com.navi.erp.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubjectDto {

    private String subject;
    private String sCode;
    private boolean iCompulsory;
}
