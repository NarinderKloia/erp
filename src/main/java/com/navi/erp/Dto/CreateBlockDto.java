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
public class CreateBlockDto {

    private String block;
    private Programs programs;
}
